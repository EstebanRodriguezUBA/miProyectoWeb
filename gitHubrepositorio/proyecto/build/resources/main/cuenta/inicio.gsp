<!DOCTYPE html>
<html>
  <%-- ESTO ES UN COMENTARIO --%>
  <head>

      <title>
        <g:render template="/compartido/tituloPrincipalTemplate" />
      </title>

      <meta name="layout" content="principal"/>
  </head>
    <body>
      <g:render template="/compartido/mensajeTemplate" />

      <g:render template="/compartido/tokenInvalidoTemplate" />

      <g:render template="/compartido/iniciadorTemplate" />

      <g:render template="/compartido/menuSesionPrincipalTemplate" />

    </body>
</html>
