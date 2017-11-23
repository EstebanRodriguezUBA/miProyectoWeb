Token Invalido
<%--"NO SE PUEDE COLOCAR ASI g:render template="/compartido/tokenInvalidoTemplate" />" --%>
<g:if test="${flash.invalidToken}">
<g:message code="${flash.invalidToken}"/>
<div id="tokenInvalido" style="display: block">
  <fieldset>
    <legend>
      Intento repetido de solicitud antes de terminar
    </legend>
    <p>
      Tenga paciencia, gracias.
    </p>
    <g:if test="${flash.invalidToken}">
      <div class="flash" style="display: block">
        Espere, no desespere.
      </div>
      <p>Hubo solicitud duplicada.(o CSRF)</p>
      <g:message code="request.error.invalidtoken.message.PROBANDO CODE"/>
    </g:if>
  </fieldset>

  <g:link url="${request.getHeader('referer')}">
   Volver-retorna a la ultima accion pero si es iniciarSesion,nada sucede porque resulta en esta vista, a la que vuelve por token invalido segun entiendo-
 </g:link>
</div>
</g:if>
