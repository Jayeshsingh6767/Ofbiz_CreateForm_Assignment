package com.companyname.ofbizdemo.services;
import java.sql.Timestamp;
import java.util.*;

import org.apache.ofbiz.base.util.*;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.util.EntityQuery;
import org.apache.ofbiz.party.party.PartyServices;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ModelService;
import org.apache.ofbiz.service.ServiceUtil;

public class OfbizDemoServices {

    private static final String MODULE = OfbizDemoServices.class.getName();
    private static final String RESOURCE = "PartyUiLabels";
    private static final String RES_ERROR = "PartyErrorUiLabels";



    public static Map<String, Object> createPerson(DispatchContext ctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = new HashMap<>();
        Delegator delegator = ctx.getDelegator();
        Timestamp now = UtilDateTime.nowTimestamp();
        List<GenericValue> toBeStored = new LinkedList<>();
        Locale locale = (Locale) context.get("locale");
        // in most cases userLogin will be null, but get anyway so we can keep track of that info if it is available
        GenericValue userLogin = (GenericValue) context.get("userLogin");

        String partyId = (String) context.get("partyId");
        String description = (String) context.get("description");

        // if specified partyId starts with a number, return an error
        if (UtilValidate.isNotEmpty(partyId) && partyId.matches("\\d+")) {
            return ServiceUtil.returnError(UtilProperties.getMessage(RES_ERROR,
                    "party.id_is_digit", locale));
        }

        // partyId might be empty, so check it and get next seq party id if empty
        if (UtilValidate.isEmpty(partyId)) {
            try {
                partyId = delegator.getNextSeqId("Party");
            } catch (IllegalArgumentException e) {
                return ServiceUtil.returnError(UtilProperties.getMessage(RES_ERROR,
                        "party.id_generation_failure", locale));
            }
        }

        // check to see if party object exists, if so make sure it is PERSON type party
        GenericValue party = null;

        try {
            party = EntityQuery.use(delegator).from("Party").where("partyId", partyId).queryOne();
        } catch (GenericEntityException e) {
            Debug.logWarning(e.getMessage(), MODULE);
        }

        if (party != null) {
            if (!"PERSON".equals(party.getString("partyTypeId"))) {
                return ServiceUtil.returnError(UtilProperties.getMessage(RES_ERROR,
                        "person.create.party_exists_not_person_type", locale));
            }
        } else {
            // create a party if one doesn't already exist with an initial status from the input
            String statusId = (String) context.get("statusId");
            if (statusId == null) {
                statusId = "PARTY_ENABLED";
            }
            Map<String, Object> newPartyMap = UtilMisc.toMap("partyId", partyId, "partyTypeId", "PERSON", "description", description,
                    "createdDate", now, "lastModifiedDate", now, "statusId", statusId);
            String preferredCurrencyUomId = (String) context.get("preferredCurrencyUomId");
            if (UtilValidate.isNotEmpty(preferredCurrencyUomId)) {
                newPartyMap.put("preferredCurrencyUomId", preferredCurrencyUomId);
            }
            String externalId = (String) context.get("externalId");
            if (UtilValidate.isNotEmpty(externalId)) {
                newPartyMap.put("externalId", externalId);
            }
            if (userLogin != null) {
                newPartyMap.put("createdByUserLogin", userLogin.get("userLoginId"));
                newPartyMap.put("lastModifiedByUserLogin", userLogin.get("userLoginId"));
            }
            party = delegator.makeValue("Party", newPartyMap);
            toBeStored.add(party);

            // create the status history
            GenericValue statusRec = delegator.makeValue("PartyStatus",
                    UtilMisc.toMap("partyId", partyId, "statusId", statusId, "statusDate", now));
            if (userLogin != null) {
                statusRec.put("changeByUserLoginId", userLogin.get("userLoginId"));
            }
            toBeStored.add(statusRec);
        }

        GenericValue person = null;

        try {
            person = EntityQuery.use(delegator).from("Person").where("partyId", partyId).queryOne();
        } catch (GenericEntityException e) {
            Debug.logWarning(e.getMessage(), MODULE);
        }

        if (person != null) {
            return ServiceUtil.returnError(UtilProperties.getMessage(RES_ERROR,
                    "person.create.person_exists", locale));
        }

        person = delegator.makeValue("Person", UtilMisc.toMap("partyId", partyId));
        person.setNonPKFields(context);
        toBeStored.add(person);

        try {
            delegator.storeAll(toBeStored);
        } catch (GenericEntityException e) {
            Debug.logWarning(e.getMessage(), MODULE);
            return ServiceUtil.returnError(UtilProperties.getMessage(RES_ERROR,
                    "person.create.db_error", new Object[] {e.getMessage() }, locale));
        }

        result.put("partyId", partyId);
        result.put(ModelService.RESPONSE_MESSAGE, ModelService.RESPOND_SUCCESS);
        return result;
    }




    public static Map<String, Object> createOfbizDemo(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = ServiceUtil.returnSuccess();
        Delegator delegator = dctx.getDelegator();
        try {
            GenericValue ofbizDemo = delegator.makeValue("OfbizDemo");
            // Auto generating next sequence of ofbizDemoId primary key
            ofbizDemo.setNextSeqId();
            // Setting up all non primary key field values from context map
            ofbizDemo.setNonPKFields(context);
            // Creating record in database for OfbizDemo entity for prepared value
            ofbizDemo = delegator.create(ofbizDemo);
            result.put("ofbizDemoId", ofbizDemo.getString("ofbizDemoId"));
            Debug.log("==========This is my first Java Service implementation in Apache OFBiz. OfbizDemo record created successfully with ofbizDemoId: "+ofbizDemo.getString("ofbizDemoId"));
        } catch (GenericEntityException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError("Error in creating record in OfbizDemo entity ........" +MODULE);
        }
        return result;
    }
}