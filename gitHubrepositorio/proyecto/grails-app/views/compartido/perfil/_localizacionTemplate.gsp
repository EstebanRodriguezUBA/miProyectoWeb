<div id="localizacion">
 <fieldset> <!-- Recuadro-->

  <legend>Información de localización </legend>
  <div class="Direccion">

    <label for="provincia">Provincia<span style="color:red">*</span></label>
    <g:textField required="true" name="provincia" value="${localizacion?.direccion?.provincia}"/>

    <label for="direccion.ciudad">Ciudad<span style="color:red">*</span></label>
    <g:textField required='true' name="ciudad" value="${localizacion?.direccion?.ciudad}"/>
    </br>


    <label for="direccion">Barrio</label>
    <g:textField required='false' name="barrio" value="${localizacion?.direccion?.barrio}"/>
    </br>

  </div>

  <!-- required es para que no deje vacio los campos al presionar boton -->
 </fieldset>
</div>
