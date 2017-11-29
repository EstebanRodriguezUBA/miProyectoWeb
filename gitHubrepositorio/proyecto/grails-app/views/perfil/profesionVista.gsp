<!DOCTYPE html>
<%! import fiuba.sii7571.miproyecto.util.tituloProfesional.TituloProfesional %>
<html>
  <head>
      <title><g:render template="/compartido/tituloPrincipalTemplate" /></title>
    <!-- desactivado de momento  <meta name="layout" content="main"/> -->
    <meta name="layout" content="principal"/>
  </head>

  <body>

    <g:render template="/compartido/mensajeTemplate" />

    <g:form  action="determinarProfesion">

      <g:select name="tituloProfesional" from="${TituloProfesional?.values()}" optionKey="nombre" value="{tituloProfesional?.nombre}"/>

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
