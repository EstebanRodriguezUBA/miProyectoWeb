<div class="errors"><!--Esto es para remarcado por defecto de Grails-->
  <div id="error">
    <g:if test="${flash.hayErrores}" >
      <fieldset>
        <legend>Errores detectados</legend>
        <g:message error="${flash.hayErrores}"/>
        <g:hasErrors bean="${beanError}">
            <fieldset>
              <ul><!-- ul agrega punto negro a la lista desordenada -->
                <g:eachError var="errorCometido" bean="${beanError}">

                  <li> Error:
                    <span style='color:red'>
                      ${errorCometido}
                    </span>
                  </li>
              <%-- <h3>Esta es una segunda variante segun i18.</h3>
                   <li>ERROR ==><g:message error="${it}"/></li>
              --%>

                </g:eachError>
              </ul>
            </fieldset>
        </g:hasErrors>
      </fieldset>
    </g:if>
  </div>
</div>
