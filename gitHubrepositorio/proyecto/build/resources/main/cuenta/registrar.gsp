<!DOCTYPE html>
<html>
  <head>

      <title><g:render template="/compartido/tituloPrincipalTemplate"/></title>
      <meta name="layout" content="principal"/>
  </head>
    <body>
      <g:render template="/compartido/mensajeTemplate" />
      <g:render template="/compartido/tokenInvalidoTemplate" />

      <p>Registracion</p>
      <g:render template="/compartido/iniciadorTemplate" />
      aqui va g if tal class entonces editar
      <!--Errores en el ingreso -->
      <g:render template="/compartido/errorTemplate" p />
      <div id="botonRegistrar">
        <g:form useToken="true">
          <div id="miBotonRegistrar">
            <g:actionSubmit value="Acepto Registrarme" action="registrar"/>
          </div>
        </g:form>
      </div>
    </body>
</html>
