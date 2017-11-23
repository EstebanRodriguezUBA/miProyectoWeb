<div id="informePersonal">
 <fieldset> <!-- Recuadro-->

  <legend>Información Personal </legend>

    <label for="nombre">Nombre<span style="color:red">*</span></label>
    <g:textField required="true" name="nombre" value="${informePersonal?.nombre}"/>
    </br>
    <label for="apellido">Apellido<span style="color:red">*</span></label>
    <g:textField required='true' name="apellido" value="${informePersonal?.apellido}"/>
    </br>
    <label for="nacionalidad">Nacionalidad<span style="color:red">*</span></label>
    <g:textField required='true' name="nacionalidad" value="${informePersonal?.nacionalidad}"/>
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

  <!--required es para que no deje vacio los campos al presionar boton-->
 </fieldset>
</div>
