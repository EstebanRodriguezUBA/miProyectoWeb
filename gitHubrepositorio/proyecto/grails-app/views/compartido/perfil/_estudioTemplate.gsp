<div id="estudio">
 <fieldset> <!-- Recuadro-->

  <legend>Información de localización </legend>
  <div class="Direccion">

    <label for="estudio.tituloHabilitante">Título</label>
    <g:textField required="true" name="direccion.provincia" value="${estudio?.tituloHabilitante}"/>
    </br>
    <label for="estudio.institucion">Establecimiento educativo</label>
    <g:textField required="" name="estudio.institucion" value="${estudio?.institucion}"/>
    </br>

  </div>

  <!-- required es para que no deje vacio los campos al presionar boton -->
 </fieldset>
</div>
