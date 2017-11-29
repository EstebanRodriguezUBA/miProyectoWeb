<div id="accessoSesion">
 <fieldset> <!-- Recuadro-->
  <legend>Acceso a cuenta</legend>
  <g:form useToken="false" action="iniciarSesion">

      <label for="nombreAcceso">Email<span style="color:red">*</span></label>
      <!--value pone algo por defecto en el campo-->
      <g:textField required="true" name="nombreAcceso" value="Ingrese email."/>
      </br>
      <label for="claveAcceso">Clave<span style="color:red">*</span></label>
    <g:passwordField required='true' name="claveAcceso" value=""/>
      <!--<g:hiddenField required='true' name="claveAcceso" value="Ingrese  clave alfanumerica." />
    -->
<!--required es para que no deje vacio los campos al presionar boton-->
<!--Escrito de esta manera, notar CUALQUIER Otro actionName desde donde se dirija aqui va a aparecer el botón. Asi no sirve-->
    <g:if test="${actionName != 'registrarUsuario'}">
       <g:submitButton name="ingresar" value="Iniciar Sesion"/>
    </g:if>

  </g:form>
 </fieldset>
</div>
