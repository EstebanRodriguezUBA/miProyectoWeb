<!DOCTYPE html>
<html>
  <head>
      <title><g:render template="/compartido/tituloPrincipalTemplate" /></title>
    <!-- desactivado de momento  <meta name="layout" content="main"/> -->
    <meta name="layout" content="principal"/>
  </head>
  <body>
    <g:render template="/compartido/mensajeTemplate" />

    <g:render template="/compartido/tokenInvalidoTemplate" />

<!-- token de form para doble "post" y control de CSRF = Cross-site request forgery o falsificación de petición en sitios cruzados -->
    <g:render template="/compartido/iniciadorTemplate" />

    <div id="registrar">
      <g:form useToken="true" ><!--controller='perfil' action="crearPersona"-->
      <g:actionSubmit value="REGISTRARSE" action ='registrar'/>
      </g:form>
    </div>
    <!--Errores en el ingreso -->
    aqui llega beanError. El nombre es __${beanError?.nombre}__
    <g:render template="/compartido/errorTemplate" />
  </body>
</html>
