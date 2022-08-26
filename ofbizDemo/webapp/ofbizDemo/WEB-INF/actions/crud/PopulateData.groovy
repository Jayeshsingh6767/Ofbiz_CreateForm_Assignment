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
        context.postalAddressPurpose="Shipping Destination Address"
        postalAddress = from("PostalAddress").where("contactMechId", contactMechId).queryOne()
        context.address1=postalAddress.getString("address1");
            context.address1=postalAddress.getString("address1");
            context.address2=postalAddress.getString("address2");
            context.city=postalAddress.getString("city");
            context.postalCode=postalAddress.getString("postalCode");
            context.countryGeoId=postalAddress.getString("countryGeoId");
            context.stateProvinceGeoId=postalAddress.getString("stateProvinceGeoId");

        }else if(purpose.equals("PRIMARY_EMAIL"))
        {

        }else if(purpose.equals("PHONE_HOME"))
        {

        }
    }

}