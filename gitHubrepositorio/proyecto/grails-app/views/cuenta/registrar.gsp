<!DOCTYPE html>
<html>
  <head>

      <title><g:render template="/compartido/tituloPrincipalTemplate"/></title>
      <meta name="layout" content="principal"/>
  </head>
    <body>
      <g:render template="mensajeTemplate" />
      <g:render template="tokenInvalidoTemplate" />

      <p>Registracion</p>
      <g:render template="iniciadorTemplate" />

      <!--Errores en el ingreso -->
      <g:render template="errorTemplate" />

    </body>
</html>
