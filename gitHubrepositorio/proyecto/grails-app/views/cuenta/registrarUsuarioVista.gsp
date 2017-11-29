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

      <div id="botonRegistrar">
        <g:form useToken="false">
          <div id="miBotonRegistrar">
            <label for="nombreAcceso">Email<span style="color:red">*</span></label>
            <!--value pone algo por defecto en el campo-->
            <g:textField required="true" name="nombreAcceso" value="Ingrese email."/>
            </br>
            <label for="claveAcceso">Clave<span style="color:red">*</span></label>
          <g:passwordField required='true' name="claveAcceso" value=""/>

            <g:actionSubmit value="Acepto Registrarme" action="registrarUsuario"/>
            <g:actionSubmit value="Cancelar" action="index"/>
          </div>
        </g:form>
      </div>
      <!--Errores en el ingreso -->
      <g:render template="/compartido/errorTemplate" />
    </body>
</html>
