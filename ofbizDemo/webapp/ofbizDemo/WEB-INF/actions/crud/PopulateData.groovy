partyId=parameters.partyId
person=from("Person").where("partyId", partyId).queryOne()
context.person=person
contacts=from("PartyContactMech").where("partyId", partyId).queryList()
if(contacts)
{
    for(int i=0;i<contacts.size();i++)
    {
        contact=contacts.get(i)
        contactMechId=contact.getString("contactMechId")
        contachMechPurpose = from("PartyContactMechPurpose").where("contactMechId", contactMechId).queryOne()
        purpose = contachMechPurpose.getString("contactMechPurposeTypeId")
        System.out.println(purpose)
        if(purpose.equals("SHIPPING_LOCATION"))
        {
        context.postalAddressPurpose=purpose
        postalAddress = from("PostalAddress").where("contactMechId", contactMechId).queryOne()
        context.address1=postalAddress.getString("address1");
            context.address1=postalAddress.getString("address1");
            context.address2=postalAddress.getString("address2");
            context.city=postalAddress.getString("city");
            context.postalCode=postalAddress.getString("postalCode");
            countryGeoId=postalAddress.getString("countryGeoId");
            stateProvinceGeoId=postalAddress.getString("stateProvinceGeoId");
            country=from("Geo").where("geoId", countryGeoId).queryOne()
            context.countryName=country.getString("geoName")
            state=from("Geo").where("geoId", stateProvinceGeoId).queryOne()
            context.stateName=state.getString("geoName")


        }else if(purpose.equals("PRIMARY_EMAIL"))
        {
            contactMech = from("ContactMech").where("contactMechId", contactMechId).queryOne()
            context.email=contactMech.getString("infoString");
            context.emailAddressPurpose=purpose

        }else if(purpose.equals("PHONE_HOME"))
        {
            telecomNumber=from("TelecomNumber").where("contactMechId", contactMechId).queryOne()
            context.homeCountryCode=telecomNumber.getString("countryCode");
            context.homeContactNumber=telecomNumber.getString("contactNumber");

        }else if(purpose.equals("PHONE_WORK"))
        {
            telecomNumber=from("TelecomNumber").where("contactMechId", contactMechId).queryOne()
            context.businessCountryCode=telecomNumber.getString("countryCode");
            context.businessContactNumber=telecomNumber.getString("contactNumber");

        }else if(purpose.equals("FAX_NUMBER"))
        {
            telecomNumber=from("TelecomNumber").where("contactMechId", contactMechId).queryOne()
            context.faxCountryCode=telecomNumber.getString("countryCode");
            context.faxContactNumber=telecomNumber.getString("contactNumber");

        }else if(purpose.equals("PHONE_MOBILE"))
        {
            telecomNumber=from("TelecomNumber").where("contactMechId", contactMechId).queryOne()
            context.phoneCountryCode=telecomNumber.getString("countryCode");
            context.phoneContactNumber=telecomNumber.getString("contactNumber");

        }

    }

}
userLogin=from("UserLogin").where("partyId", partyId).queryOne()
context.userLoginId=userLogin.getString("userLoginId");
context.currentPassword=userLogin.getString("currentPassword");