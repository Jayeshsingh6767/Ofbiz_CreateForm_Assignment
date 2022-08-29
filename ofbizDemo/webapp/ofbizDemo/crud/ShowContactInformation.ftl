<div class="screenlet-body">
    <fieldset>

            <div>

              <span class="label">Postal Address</span><br><br>
              ${postalAddressPurpose}<br>
              ${address1}
              <#if address2?has_content>
                   ${address2}
              </#if>
              <br>
              ${city}<br>
              ${postalCode}<br>
              ${stateName},
              ${countryName}<br><br>
            </div>
            <div>

                          <span class="label">Email Address</span><br><br>
                          ${emailAddressPurpose}<br>
                          ${email}<br><br>
                         </div>

            <div>
            <div>
              <#if homeContactNumber?has_content>
                          <span class="label">Phone Number</span><br><br>
                          Home Phone Number<br>
                          <#if homeCountryCode?has_content>
                            ${homeCountryCode}
                          </#if>
                          ${homeContactNumber}<br><br>
               </#if>

            </div>
            <div>
              <#if businessContactNumber?has_content>
                          <span class="label">Phone Number</span><br><br>
                          Business Phone Number<br>
                          <#if homeCountryCode?has_content>
                            ${businessCountryCode}
                          </#if>
                          ${businessContactNumber}<br><br>
               </#if>

            </div>
            <div>
              <#if faxContactNumber?has_content>
                          <span class="label">Phone Number</span><br><br>
                          Fax Phone Number<br>
                          <#if homeCountryCode?has_content>
                            ${faxCountryCode}
                          </#if>
                          ${faxContactNumber}<br><br>
               </#if>

            </div>
            <div>
              <#if mobileContactNumber?has_content>
                          <span class="label">Phone Number</span><br><br>
                          Mobile Phone Number<br>
                          <#if homeCountryCode?has_content>
                            ${mobileCountryCode}
                          </#if>
                          ${mobileContactNumber}<br><br>
               </#if>

            </div>


    </fieldset>
</div>
