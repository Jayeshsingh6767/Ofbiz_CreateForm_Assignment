<div class="screenlet-body">
  <form id="createOfbizDemoEvent" method="post" action="<@ofbizUrl>createOfbizDemoEvent</@ofbizUrl>">
    <input type="hidden" name="addOfbizDemoFromFtl" value="Y"/>
    <fieldset>

            <div>
             <h1> Full Name</h1>
              <span class="label">Title</span>
              <select name="title" class='required'>
                  <option value='Mr.'>Mr.</option>
                  <option value='Mrs.'>Mrs.</option>

              </select>*
            </div>
            <div>
              <span class="label">First name</span>
              <input type="text" name="firstName" id="firstName" class='required' maxlength="20" />*
            </div>
            <div>
                   <span class="label">Middle initial</span>
                   <input type="text" name="middleName" id="middleName" class='input' maxlength="20" />
                 </div>

            <div>
              <span class="label">Last name</span>
              <input type="text" name="lastName" id="lastName" class='required' maxlength="20" />*
            </div>
            <div>
              <span class="label">Suffix</span>
              <input type="text" name="suffix" id="suffix" class='input'  maxlength="255" />
            </div>
      <br>
      <br>
      <div>
        <h1> Shipping Address</h1>
         <span class="label">Address Line 1</span>
         <input type="text" name="addressLine1" id="addressLine1" class='required' maxlength="50" />*

      </div>
      <div>
        <span class="label">Address Line 2</span>
        <input type="text" name="addressLine2" id="addressLine2" class='inputBox' maxlength="50" />*
      </div>
      <div>

               <span class="label">City</span>
               <input type="text" name="city" id="city" class='required' maxlength="20" />*

      </div>
      <div>

                    <span class="label">Zip/Postal Code</span>
                    <input type="text" name="zip" id="zip" class='required' maxlength="20" />*

           </div>

      <div>
        <span class="label">Country</span>
                <select name="country" class='required'>
                    <option value='india'>india</option>
                    <option value='USA'>usa</option>

                </select>*
      </div>
       <div>
              <span class="label">State</span>
                      <select name="state" class='required'>
                          <option value='Madhya Pradesh'>india</option>
                          <option value='Gujrat'>usa</option>

                      </select>*
       </div>

      <div>
        <span class="label">Allow Address Solicitation</span>
                <select name="addressSolicitation" >
                    <option value='Y'>N</option>
                    <option value='N'>Y</option>

                </select>*
      </div>
      <br>
      <br>
        <div>
        <h1> E-Mail Address</h1>
         <span class="label">E-Mail Address </span>
         <input type="email" name="email" id="email" class='required' maxlength="50" />*

        </div>

    <div>
            <span class="label">Allow Address Solicitation</span>
                    <select name="emailSolicitation" >
                        <option value='Y'>N</option>
                        <option value='N'>Y</option>

                    </select>*
    </div>

<br>
<br>
 <div>
        <h1>Phone Numbers</h1>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <span class="label">contry</span>
         <span class="label">Area Code</span>
         <span class="label">Contact Number</span>
         <span class="label">Extention</span>
         <span class="label">Allow Solicitation</span>
         <br>
         <br>
         <span class="label">Home phone</span>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="homePhoneCountryCode" id="countryCode" class='required' size="1.5" maxlength="50" />
         &nbsp;&nbsp;
         <input type="text" name="homePhoneAreaCode" id="areaCode" class='required' size="3" maxlength="50" />
         &nbsp;&nbsp;&nbsp;
         <input type="text" name="homePhoneContactNumber" id="contactNumber" class='required' size="6" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="homePhoneExtention" id="extention" class='required' size="2" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <select name="homePhoneSolicitation" >
              <option value='Y'>N</option>
              <option value='N'>Y</option>
         </select>
         <br>
         <br>
         <span class="label">Business phone</span>
         <input type="text" name="businessPhoneCountryCode" id="countryCode" class='required' size="1.5" maxlength="50" />
         &nbsp;&nbsp;
         <input type="text" name="businessPhoneAreaCode" id="areaCode" class='required' size="3" maxlength="50" />
         &nbsp;&nbsp;&nbsp;
         <input type="text" name="businessPhoneContactNumber" id="contactNumber" class='required' size="6" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="businessPhoneExtention" id="extention" class='required' size="2" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <select name="businessPhoneSolicitation" >
              <option value='Y'>N</option>
              <option value='N'>Y</option>
         </select>
         <br>
         <br>
         <span class="label">Fax phone</span>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="faxPhoneCountryCode" id="countryCode" class='required' size="1.5" maxlength="50" />
         &nbsp;&nbsp;
         <input type="text" name="faxPhoneAreaCode" id="areaCode" class='required' size="3" maxlength="50" />
         &nbsp;&nbsp;&nbsp;
         <input type="text" name="faxPhoneContactNumber" id="contactNumber" class='required' size="6" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="faxPhoneExtention" id="extention" class='required' size="2" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <select name="faxPhoneSolicitation" >
              <option value='Y'>N</option>
              <option value='N'>Y</option>
         </select>
         <br>
         <br>
         <span class="label">Mobile phone</span>
         &nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="mobilePhoneCountryCode" id="countryCode" class='required' size="1.5" maxlength="50" />
         &nbsp;&nbsp;
         <input type="text" name="mobilePhoneAreaCode" id="areaCode" class='required' size="3" maxlength="50" />
         &nbsp;&nbsp;&nbsp;
         <input type="text" name="mobilePhoneContactNumber" id="contactNumber" class='required' size="6" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="mobilePhoneExtention" id="extention" class='required' size="2" maxlength="50" />
         &nbsp;&nbsp;&nbsp;&nbsp;
         <select name="mobilePhoneSolicitation" >
              <option value='Y'>N</option>
              <option value='N'>Y</option>
         </select>


      </div>
      <br>
      <br>

      <div>
             <h1> User Name</h1>
             <label>
                                 <input type="checkbox" name="useEmailAddress" value="Y" />
                                    use Email Address
             </label>

      </div>
      <div>
              <span class="label">User name</span>
              <input type="text" name="userName" id="userName" class='required' maxlength="20" />*
      </div>
      <br>
      <br>

      <div>
             <h1> Passwords</h1>
              <span class="label">Password</span>
              <input type="text" name="password" id="password" class='required' maxlength="20" />*

      </div>
      <div>
              <span class="label">Repeat password to confirm</span>
              <input type="text" name="repeatPassword" id="repeatPassword" class='required' maxlength="20" />*
      </div>
      <div>
              <span class="label">Password Hint</span>
              <input type="text" name="passwordHint" id="passwordHint"  maxlength="20" />
      </div>



    </fieldset>

    <input type="submit" value="${uiLabelMap.CommonAdd}" />
  </form>
</div>