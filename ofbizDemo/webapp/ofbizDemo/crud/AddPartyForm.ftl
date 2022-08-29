<div class="screenlet-body">
  <form id="createPartyEvent" method="post" action="<@ofbizUrl>createPartyEvent</@ofbizUrl>">
    <input type="hidden" name="addOfbizDemoFromFtl" value="Y"/>
    <fieldset>
      <div>
        <h1> Full Name</h1>
        <span class="label">Title</span>
        <select name="title" class='required'>
          <option value='Mr.'>Mr.</option>
          <option value='Mrs.'>Mrs.</option>
        </select>
        *
      </div>
      <div>
        <span class="label">First name</span>
        <input type="text" name="firstName" id="firstName" class='required' maxlength="20" value="${parameters.firstName!}" />*
      </div>
      <div>
        <span class="label">Middle initial</span>
        <input type="text" name="middleName" id="middleName" class='input' maxlength="20" value="${parameters.middleName!}"/>
      </div>
      <div>
        <span class="label">Last name</span>
        <input type="text" name="lastName" id="lastName" class='required' maxlength="20" value="${parameters.lastName!}" />*
      </div>
      <div>
        <span class="label">Suffix</span>
        <input type="text" name="suffix" id="suffix" class='input'  maxlength="255" value="${parameters.suffix!}"/>
      </div>
      <br>
      <br>
      <div>
        <h1> Shipping Address</h1>
        <span class="label">Address Line 1</span>
        <input type="text" name="addressLine1" id="addressLine1" class='required' maxlength="50" value="${parameters.addressLine1!}"/>*
      </div>
      <div>
        <span class="label">Address Line 2</span>
        <input type="text" name="addressLine2" id="addressLine2" class='inputBox' maxlength="50" value="${parameters.addressLine2!}"/>*
      </div>
      <div>
        <span class="label">City</span>
        <input type="text" name="city" id="city" class='required' maxlength="20" value="${parameters.city!}"/>*
      </div>
      <div>
        <span class="label">Zip/Postal Code</span>
        <input type="text" name="zip" id="zip" class='required' maxlength="20" value="${parameters.zip!}"/>*
      </div>
      <div>
        <span class="label">Country</span>
        <select name="country" class='required'>
          <option value=""</option>
          <#list countries as country>
            <option value=${country.geoId}>${country.geoName}</option>
          </#list>
        </select>
        *
      </div>
      <div>
        <span class="label">State</span>
        <select name="state" class='required'>
          <option value=""</option>
          <#list states as state>
            <option value=${state.geoId}>${state.geoName}</option>
          </#list>
        </select>
        *
      </div>
      <div>
        <span class="label">Allow Address Solicitation</span>
        <select name="addressSolicitation" >
          <option value=""></option>
          <option value='Y'>N</option>
          <option value='N'>Y</option>
        </select>
        *
      </div>
      <br>
      <br>
      <div>
        <h1> E-Mail Address</h1>
        <span class="label">E-Mail Address </span>
        <input type="email" name="email" id="email" class='required' maxlength="50" value="${parameters.email!}"/>*
      </div>
      <div>
        <span class="label">Allow Email Address Solicitation</span>
        <select name="emailSolicitation" >
          <option value=""></option>
          <option value='Y'>N</option>
          <option value='N'>Y</option>
        </select>
        *
      </div>
      <br>
      <br>
      <div>
        <h1>Phone Numbers</h1>        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="label">contry</span>
        <span class="label">Area Code</span>
        <span class="label">Contact Number</span>
        <span class="label">Extention</span>
        <span class="label">Allow Solicitation</span>
        <br>
        <br>
        <span class="label">Home phone</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="homePhoneCountryCode" id="homePhoneCountryCode" class='required' size="1.5" maxlength="50" value="${parameters.homePhoneCountryCode!}"/>        &nbsp;&nbsp;
        <input type="text" name="homePhoneAreaCode" id="homePhoneAreaCode" class='required' size="3" maxlength="50" value="${parameters.homePhoneAreaCode!}"/>&nbsp;&nbsp;&nbsp;
        <input type="text" name="homePhoneContactNumber" id="homePhoneContactNumber" class='required' size="6" maxlength="50" value="${parameters.homePhoneContactNumber!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="homePhoneExtention" id="homePhoneExtention" class='required' size="2" maxlength="50" value="${parameters.homePhoneExtention!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="homePhoneSolicitation" >
          <option value=""></option>
          <option value='N'>N</option>
          <option value='Y'>Y</option>
        </select>
        <br>
        <br>
        <span class="label">Business phone</span>
        <input type="text" name="businessPhoneCountryCode" id="businessPhoneCountryCode" class='required' size="1.5" maxlength="50" value="${parameters.businessPhoneCountryCode!}"/>&nbsp;&nbsp;
        <input type="text" name="businessPhoneAreaCode" id="businessPhoneAreaCode" class='required' size="3" maxlength="50" value="${parameters.businessPhoneAreaCode!}"/>&nbsp;&nbsp;&nbsp;
        <input type="text" name="businessPhoneContactNumber" id="businessPhoneContactNumber" class='required' size="6" maxlength="50" value="${parameters.businessPhoneContactNumber!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="businessPhoneExtention" id="businessPhoneExtention" class='required' size="2" maxlength="50" value="${parameters.businessPhoneExtention!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="businessPhoneSolicitation" >
          <option value=""></option>
          <option value='N'>N</option>
          <option value='Y'>Y</option>
        </select>
        <br>
        <br>
        <span class="label">Fax phone</span>        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="faxPhoneCountryCode" id="faxPhoneCountryCode" class='required' size="1.5" maxlength="50" value="${parameters.faxPhoneCountryCode!}"/>        &nbsp;&nbsp;
        <input type="text" name="faxPhoneAreaCode" id="faxPhoneAreaCode" class='required' size="3" maxlength="50" value="${parameters.faxPhoneAreaCode!}"/>&nbsp;&nbsp;&nbsp;
        <input type="text" name="faxPhoneContactNumber" id="faxPhoneContactNumber" class='required' size="6" maxlength="50" value="${parameters.faxPhoneContactNumber!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="faxPhoneExtention" id="faxPhoneExtention" class='required' size="2" maxlength="50" value="${parameters.faxPhoneExtention!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="faxPhoneSolicitation" >
          <option value=""></option>
          <option value='N'>N</option>
          <option value='Y'>Y</option>
        </select>
        <br>
        <br>
        <span class="label">Mobile phone</span>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="mobilePhoneCountryCode" id="mobilePhoneCountryCode" class='required' size="1.5" maxlength="50" value="${parameters.mobilePhoneCountryCode!}"/>&nbsp;&nbsp;
        <input type="text" name="mobilePhoneAreaCode" id="mobilePhoneAreaCode" class='required' size="3" maxlength="50" value="${parameters.mobilePhoneAreaCode!}"/>&nbsp;&nbsp;&nbsp;
        <input type="text" name="mobilePhoneContactNumber" id="mobilePhoneContactNumber" class='required' size="6" maxlength="50" value="${parameters.mobilePhoneContactNumber!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="mobilePhoneExtention" id="mobilePhoneExtention" class='required' size="2" maxlength="50" value="${parameters.mobilePhoneExtention!}"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="mobilePhoneSolicitation" >
          <option value=""></option>
          <option value='N'>N</option>
          <option value='Y'>Y</option>
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
        <input type="text" name="userName" id="userName" class='required' maxlength="20" value="${parameters.userName!}"/>*
      </div>
      <br>
      <br>
      <div>
        <h1> Passwords</h1>
        <span class="label">Password</span>
        <input type="text" name="password" id="password" class='required' maxlength="20" value="${parameters.password!}"/>*
      </div>
      <div>
        <span class="label">Repeat password to confirm</span>
        <input type="text" name="repeatPassword" id="repeatPassword" class='required' maxlength="20" value="${parameters.repeatPassword!}"/>*
      </div>
      <div>
        <span class="label">Password Hint</span>
        <input type="text" name="passwordHint" id="passwordHint"  maxlength="20" value="${parameters.passwordHint!}" />
      </div>
    </fieldset>
    <input type="submit" value="${uiLabelMap.CommonAdd}" />
  </form>
</div>