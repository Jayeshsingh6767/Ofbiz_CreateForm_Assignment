countries = from("Geo").where("geoTypeId", "COUNTRY").queryList()
context.countries = countries
states = from("Geo").where("geoTypeId", "STATE").queryList()
context.states = states
