<!DOCTYPE html>
<html>
  <head>
      <title><g:render template="/compartido/tituloPrincipalTemplate" /></title>
    <!-- desactivado de momento  <meta name="layout" content="main"/> -->
    <meta name="layout" content="principal"/>
  </head>

  <body>

    <g:render template="/compartido/mensajeTemplate" />

    <g:form  action="determinarContacto">
      <g:render template="/compartido/perfil/contactoTemplate" />
      <g:submitButton name="ingresar" value="Continuar"/>
    </g:form>

    <div id="Volver">
      <g:form>
      <g:actionSubmit value="Volver" action ='retornarInformePersonal'/>
      </g:form>
    </div>

    <!--Errores en el ingreso -->

    <g:render template="/compartido/errorTemplate" />

  </body>
</html>
