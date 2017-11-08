<div id="accessoSesion">
 <fieldset> <!-- Recuadro-->
  <legend>Acceso a cuenta</legend>
  <g:form useToken="true" action="iniciarSesion">

      <label for="nombre">Email<span style="color:red">*</span></label>
      <!--value pone algo por defecto en el campo-->
      <g:textField required="true" name="nombre" value="Ingrese email."/>
      </br>
      <label for="claveAcceso">Clave<span style="color:red">*</span></label>
    <g:passwordField required='true' name="claveAcceso" value="Ingrese  su clave alfanumerica."/>
      <!--<g:hiddenField required='true' name="claveAcceso" value="Ingrese  clave alfanumerica." />
    -->
<!--required es para que no deje vacio los campos al presionar boton-->
    <g:if test="${actionName != 'registrar'}">
       <g:submitButton name="ingresar" value="Iniciar Sesion"/>
    </g:if>

  </g:form>
 </fieldset>
</div>
