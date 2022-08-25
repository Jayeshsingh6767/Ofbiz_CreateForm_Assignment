package com.companyname.ofbizdemo.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilMisc;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

import java.util.HashMap;
import java.util.Map;

public class OfbizDemoEvents {

    public static final String module = OfbizDemoEvents.class.getName();

    public static String createOfbizDemoEvent(HttpServletRequest request, HttpServletResponse response) {
        Delegator delegator = (Delegator) request.getAttribute("delegator");
        LocalDispatcher dispatcher = (LocalDispatcher) request.getAttribute("dispatcher");
        GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");
        //for(int i=0;i<100;System.out.println("***************"),i++);
        String ofbizDemoTypeId = request.getParameter("ofbizDemoTypeId");
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


        Map<String, Object> fieldMap= new HashMap<>();
        fieldMap.put("title", title);
        fieldMap.put("firstName", firstName);
        fieldMap.put("lastName", lastName);
        fieldMap.put("middleName", middleName);
        fieldMap.put("addressLine1", addressLine1);
        fieldMap.put("suffix", suffix);
        fieldMap.put("addressLine2", addressLine2);
        fieldMap.put("city", city);
        fieldMap.put("country", country);
        fieldMap.put("state", state);
        fieldMap.put("addressSolicitation", addressSolicitation);
        fieldMap.put("email", email);
        fieldMap.put("emailSolicitation", emailSolicitation);

        if(!UtilValidate.isEmpty(homePhoneContactNumber)) {
            fieldMap.put("homePhoneCountryCode", homePhoneCountryCode);
            fieldMap.put("homePhoneAreaCode", homePhoneAreaCode);
            fieldMap.put("homePhoneContactNumber", homePhoneContactNumber);
            fieldMap.put("homePhoneExtention", homePhoneExtention);
            fieldMap.put("homePhoneSolicitation", homePhoneSolicitation);
        }
        if(!UtilValidate.isEmpty(businessPhoneContactNumber)) {

            fieldMap.put("businessPhoneCountryCode", businessPhoneCountryCode);
            fieldMap.put("businessPhoneContactNumber", businessPhoneContactNumber);
            fieldMap.put("businessPhoneExtention", businessPhoneExtention);
            fieldMap.put("businessPhoneSolicitation", businessPhoneSolicitation);
        }
        if(!UtilValidate.isEmpty(faxPhoneContactNumber)) {

            fieldMap.put("faxPhoneCountryCode", faxPhoneCountryCode);
            fieldMap.put("faxPhoneAreaCode", faxPhoneAreaCode);
            fieldMap.put("faxPhoneContactNumber", faxPhoneContactNumber);
            fieldMap.put("faxPhoneExtention", faxPhoneExtention);
            fieldMap.put("faxPhoneSolicitation", faxPhoneSolicitation);
        }

        if(!UtilValidate.isEmpty(mobilePhoneContactNumber)) {

            fieldMap.put("mobilePhoneCountryCode", mobilePhoneCountryCode);
            fieldMap.put("mobilePhoneAreaCode", mobilePhoneAreaCode);
            fieldMap.put("mobilePhoneContactNumber", mobilePhoneContactNumber);
            fieldMap.put("mobilePhoneExtention", mobilePhoneExtention);
            fieldMap.put("mobilePhoneSolicitation", mobilePhoneSolicitation);
        }
        fieldMap.put("useEmailAddress", useEmailAddress);
        fieldMap.put("userName", userName);
        fieldMap.put("password", password);
        fieldMap.put("repeatPassword", repeatPassword);
        fieldMap.put("passwordHint", passwordHint);



        try {
            Debug.logInfo("=======Creating person record in event using service createOfbizDemoByGroovyService=========", module);
            dispatcher.runSync("createOfbizDemoByGroovyService", fieldMap);
        } catch (GenericServiceException e) {
            String errMsg = "Unable to create new records in person entity: " + e.toString();
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        }
        request.setAttribute("_EVENT_MESSAGE_", "OFBiz Demo created succesfully.");
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