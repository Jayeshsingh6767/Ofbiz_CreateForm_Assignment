<div class="screenlet-body">
  <form id="findParty" method="post" action="<@ofbizUrl>findParty</@ofbizUrl>">
    <input type="hidden" name="findOfbizDemoFromFtl" value="Y"/>
    <fieldset>

            <div>
             <h1> Find user</h1>
              <span class="label">party id</span>
              <input type="text" name="partyId" id="partyId" class='required' maxlength="20" />*
            </div>

    </fieldset>

    <input type="submit" value="${uiLabelMap.CommonFind}" />
  </form>
</div>
