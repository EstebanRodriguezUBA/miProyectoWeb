<!DOCTYPE html>
<html>
  <head>
      <title>Bienvenidos, servicios profesionales a su alcance</title>
      PERSONA
    <!-- desactivado de momento  <meta name="layout" content="main"/> -->
    <meta name="layout" content="principal"/>
  </head>
  <body>
<div class="Persona">
  <g:form useToken="true" action="crearUsuario">
    <div class="Rol">
      Este es el rol de la persona
          <g:render template="/rolTemplate" />
    </div>
  <div class="Perfil">

    <div class="InformePersonal">


      <label for="nombre">Nombre<span style="color:red">*</span></label>
      <g:textField required="true" name="nombre" value=""/>
      </br>
      <label for="apellido">Apellido<span style="color:red">*</span></label>
      <g:textField required='true' name="apellido" value=""/>
      </br>
      <label for="nacionalidad">Nacionalidad<span style="color:red">*</span></label>
      <g:textField required='true' name="nacionalidad" value=""/>
      </br>

      <div id="nativo">
        <label for="nativo">Nativo</label>
        <g:checkBox name="nativo" value="${true}" checked='true'/>
        </br>
      </div>
      <div class="Genero">
        <label for="genero">Macho</label>
        <g:radio name="genero" value="M" checked="true"/>

        <label for="genero">Hembra</label>
        <g:radio name="genero" value="F" />  <!--checked="true"-->
      </div>
    </div>
    <div class="Profesion">

    </div>

    <div class="Contacto">
      <div class="Telefono">

      </div>
    </div>

    <div class="Localizacion">
      <div class="Direccion">

      </div>

    </div>

    <div class="Presentacion">

    </div>
  </div>
  <g:submitButton name="ingresar" value="Continuar"/>
  </g:form>
</div>
</body>
</html>
