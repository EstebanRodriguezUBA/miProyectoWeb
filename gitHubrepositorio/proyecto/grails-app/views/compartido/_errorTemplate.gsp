<div class="errors"><!--Esto es para remarcado por defecto de Grails-->
  <div id="error">
    Esto es para los errores, si no hay errores no se muestra
    para ello hay que poner un g if test= si tiene errores.
    ${beanError?.nombre}
    <g:hasErrors bean="${beanError}">
      <ul><!-- ul agrega punto negro a la lista desordenada -->
        <g:eachError var="errorCometido" bean="${beanError}">
          <li> Error:${errorCometido}</li>
          Esta es una segunda variante segun i18
          <li><g:message error="${it}"/></li>
        </g:eachError>
      </ul>
    </g:hasErrors>
  </div>
</div>
