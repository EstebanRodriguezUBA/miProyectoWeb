<!DOCTYPE html>
<html>
  <head>
      <title><g:render template="/compartido/tituloPrincipalTemplate" /></title>
    <!-- desactivado de momento  <meta name="layout" content="main"/> -->
    <meta name="layout" content="principal"/>
  </head>

  <body>

    <g:render template="/compartido/mensajeTemplate" />

    <g:form  action="determinarProfesion">
      <g:select name="tituloProfesional" from="${TituloProfesional.values()}" optionKey="key" value="${profesion?.tituloProfesional?.key}"/>

      <g:submitButton name="Confirmar y continuar" value="Continuar"/>


    </g:form>

    <div id="Volver">
      <g:form>
      <g:actionSubmit value="Volver" action ='retornarLocalizacion'/>
      </g:form>
    </div>

    <!--Errores en el ingreso -->

    <g:render template="/compartido/errorTemplate" />

  </body>
</html>
