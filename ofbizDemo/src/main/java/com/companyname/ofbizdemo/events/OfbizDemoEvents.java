package com.companyname.ofbizdemo.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilDateTime;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.util.EntityQuery;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OfbizDemoEvents {

    public static final String module = OfbizDemoEvents.class.getName();

    public static String createPartyEvent(HttpServletRequest request, HttpServletResponse response) {
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");
        //for(int i=0;i<100;System.out.println("***************"),i++);
        String title = request.getParameter("title");
        String firstName = request.getParameter("firstName");
        String middleName= request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String suffix = request.getParameter("suffix");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String addressSolicitation = request.getParameter("addressSolicitation");
        String email = request.getParameter("email");
        String emailSolicitation = request.getParameter("emailSolicitation");

        String homePhoneCountryCode = request.getParameter("homePhoneCountryCode");
        String homePhoneAreaCode = request.getParameter("homePhoneAreaCode");
        String homePhoneContactNumber = request.getParameter("homePhoneContactNumber");
        String homePhoneExtention = request.getParameter("homePhoneExtention");
        String homePhoneSolicitation = request.getParameter("homePhoneSolicitation");

        String businessPhoneCountryCode = request.getParameter("businessPhoneCountryCode");
        String businessPhoneAreaCode = request.getParameter("homePhoneAreaCode");
        String businessPhoneContactNumber = request.getParameter("businessPhoneContactNumber");
        String businessPhoneExtention = request.getParameter("businessPhoneExtention");
        String businessPhoneSolicitation = request.getParameter("businessPhoneSolicitation");

        String faxPhoneCountryCode = request.getParameter("faxPhoneCountryCode");
        String faxPhoneAreaCode = request.getParameter("faxPhoneAreaCode");
        String faxPhoneContactNumber = request.getParameter("faxPhoneContactNumber");
        String faxPhoneExtention = request.getParameter("faxPhoneExtention");
        String faxPhoneSolicitation = request.getParameter("faxPhoneSolicitation");
        String mobilePhoneCountryCode = request.getParameter("mobilePhoneCountryCode");
        String mobilePhoneAreaCode = request.getParameter("mobilePhoneAreaCode");
        String mobilePhoneContactNumber = request.getParameter("mobilePhoneContactNumber");
        String mobilePhoneExtention = request.getParameter("mobilePhoneExtention");
        String mobilePhoneSolicitation = request.getParameter("mobilePhoneSolicitation");
        String useEmailAddress = request.getParameter("useEmailAddress");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        String passwordHint = request.getParameter("passwordHint");

        if (UtilValidate.isEmpty(firstName) || UtilValidate.isEmpty(lastName)) {
            String errMsg = "First Name and Last Name are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        if (UtilValidate.isEmpty(addressLine1)) {
            String errMsg = "address line 1 are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        if (UtilValidate.isEmpty(city)) {
            String errMsg = "city are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        if (UtilValidate.isEmpty(zip)) {
            String errMsg = "zip/postal code are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        if (UtilValidate.isEmpty(password)) {
            String errMsg = "password are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        if (UtilValidate.isEmpty(repeatPassword)) {
            String errMsg = "repeat password are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        if (!password.equals(repeatPassword)) {
            String errMsg = "password and repeat password must be same.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        if(useEmailAddress==null && UtilValidate.isEmpty(userName) )
        {
            String errMsg = "user name are required fields on the form and can't be empty.";
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        try {
            Debug.logInfo("=======Creating person record in event using service createOfbizDemoByGroovyService=========", module);
            Map<String, Object> fieldMap= new HashMap<>();
            fieldMap.put("title", title);
            fieldMap.put("firstName", firstName);
            fieldMap.put("lastName", lastName);
            fieldMap.put("middleName", middleName);
            fieldMap.put("suffix", suffix);
            Map<String, Object> serviceResult= dispatcher.runSync("createOfBizDemoPerson", fieldMap);
            String partyId= (String) serviceResult.get("partyId");

            // postal address
            fieldMap.clear();
            fieldMap.put("partyId", partyId);
            fieldMap.put("address1", addressLine1);
            fieldMap.put("address2", addressLine2);
            fieldMap.put("city", city);
            fieldMap.put("countryGeoId", country);
            fieldMap.put("stateProvinceGeoId", state);
            fieldMap.put("postalCode", zip);
            fieldMap.put("userLogin", userLogin);
            fieldMap.put("contactMechPurposeTypeId", "SHIPPING_LOCATION");
            fieldMap.put("allowSolicitation", addressSolicitation);
            Map<String, Object> outMap = dispatcher.runSync("createPartyPostalAddress", fieldMap);
            String postalAddressContactMechId = (String) outMap.get("contactMechId");

            // email
            fieldMap.clear();
            fieldMap.put("emailAddress", email);
            fieldMap.put("contactMechPurposeTypeId", "PRIMARY_EMAIL");
            fieldMap.put("partyId", partyId);
            fieldMap.put("userLogin", userLogin);
            fieldMap.put("allowSolicitation", emailSolicitation);

            dispatcher.runSync("createPartyEmailAddress",fieldMap);

            if(!UtilValidate.isEmpty(homePhoneContactNumber)) {
                fieldMap.clear();
                fieldMap.put("contactNumber", homePhoneContactNumber);
                fieldMap.put("partyId", partyId);
                fieldMap.put("userLogin", userLogin);
                fieldMap.put("contactMechPurposeTypeId", "PHONE_HOME");
                fieldMap.put("countryCode", homePhoneCountryCode);
                fieldMap.put("areaCode", homePhoneAreaCode);
                fieldMap.put("extention", homePhoneExtention);
                fieldMap.put("allowSolicitation", homePhoneSolicitation);
                dispatcher.runSync("createPartyTelecomNumber", fieldMap);

            }
            if(!UtilValidate.isEmpty(businessPhoneContactNumber)) {

                fieldMap.clear();
                fieldMap.put("contactNumber", businessPhoneContactNumber);
                fieldMap.put("partyId", partyId);
                fieldMap.put("userLogin", userLogin);
                fieldMap.put("contactMechPurposeTypeId", "PHONE_WORK");
                fieldMap.put("countryCode", businessPhoneCountryCode);
                fieldMap.put("areaCode", businessPhoneAreaCode);
                fieldMap.put("extention", businessPhoneExtention);
                fieldMap.put("allowSolicitation", businessPhoneSolicitation);
                dispatcher.runSync("createPartyTelecomNumber", fieldMap);
            }
            if(!UtilValidate.isEmpty(faxPhoneContactNumber)) {
                fieldMap.clear();
                fieldMap.put("contactNumber", faxPhoneContactNumber);
                fieldMap.put("partyId", partyId);
                fieldMap.put("userLogin", userLogin);
                fieldMap.put("contactMechPurposeTypeId", "FAX_NUMBER");
                fieldMap.put("countryCode", faxPhoneCountryCode);
                fieldMap.put("areaCode", faxPhoneAreaCode);
                fieldMap.put("extention", faxPhoneExtention);
                fieldMap.put("allowSolicitation", faxPhoneSolicitation);
                dispatcher.runSync("createPartyTelecomNumber", fieldMap);
            }

            if(!UtilValidate.isEmpty(mobilePhoneContactNumber)) {
                fieldMap.clear();
                fieldMap.put("contactNumber", mobilePhoneContactNumber);
                fieldMap.put("partyId", partyId);
                fieldMap.put("userLogin", userLogin);
                fieldMap.put("contactMechPurposeTypeId", "PHONE_MOBILE");
                fieldMap.put("countryCode", mobilePhoneCountryCode);
                fieldMap.put("areaCode", mobilePhoneAreaCode);
                fieldMap.put("extention", mobilePhoneExtention);
                fieldMap.put("allowSolicitation", mobilePhoneSolicitation);
                dispatcher.runSync("createPartyTelecomNumber", fieldMap);
            }

            for(int i=0;i<50;i++,System.out.println("****************"));
            System.out.println(homePhoneSolicitation);
            System.out.println(businessPhoneSolicitation);
            System.out.println(faxPhoneSolicitation);
            System.out.println(mobilePhoneSolicitation);
            System.out.println(useEmailAddress);
            if(useEmailAddress!=null && useEmailAddress.equals("Y")) {
                userName=email;
            }

            Timestamp now = UtilDateTime.nowTimestamp();
            fieldMap.clear();
            fieldMap.put("userLoginId",userName);
            System.out.println(userName);

            fieldMap.put("currentPassword", password);
            fieldMap.put("currentPasswordVerify", repeatPassword);
            fieldMap.put("passwordHint", passwordHint);
            fieldMap.put("userLogin", userLogin);
            fieldMap.put("partyId",partyId);

            dispatcher.runSync("createUserLogin", fieldMap);
            fieldMap.clear();
            fieldMap.put("userLoginId", userName);
            fieldMap.put("groupId", "PARTY_VIEWER");
            fieldMap.put("fromDate", now);
            fieldMap.put("userLogin", userLogin);
            dispatcher.runSync("addUserLoginToSecurityGroup", fieldMap);

            String eventMessage="OFBiz Demo created succesfully.,party id ="+partyId;
            request.setAttribute("_EVENT_MESSAGE_",eventMessage );

        } catch (GenericServiceException e) {
            String errMsg = "Unable to create new records in person entity: " + e.toString();
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }

        return "success";
    }
}




/*UtilMisc.toMap("title", title,
                    "firstName", firstName, "lastName", lastName, "middleName", middleName,"addressLine1", addressLine1,
                    "suffix", suffix,"addressLine2", addressLine2,"city", city,
                    "zip", zip,"country", country,"state", state,
                    "addressSolicitation", addressSolicitation,"email", email,"emailSolicitation", emailSolicitation,
                    "middleName", middleName,"middleName", middleName,"middleName", middleName,
                    "middleName", middleName,"middleName", middleName,"middleName", middleName,
                    "middleName", middleName,"middleName", middleName,"middleName", middleName,
                    "middleName", middleName,"middleName", middleName,"middleName", middleName,
                    "middleName", middleName,"middleName", middleName,"middleName", middleName,
                    "middleName", middleName,"middleName", middleName,"middleName", middleName,
                    "middleName", middleName,"middleName", middleName,"middleName", middleName,"userLogin", userLogin)*/