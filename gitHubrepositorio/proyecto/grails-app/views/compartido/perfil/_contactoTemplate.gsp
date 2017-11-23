<div id="contacto">
 <fieldset> <!-- Recuadro-->

  <legend>Información de contacto </legend>
  <div class="Telefono">

    <p>Teléfono celular</p>

    <label for="celular_codigoRegional">Código Regional (Ejemplo; CABA 011)<span style="color:red">*</span></label>
    <g:textField required="true" name="celular_codigoRegional" value="${contacto?.celular?.codigoRegional}"/>

    <label for="celular_numero">Numero</label>
    <g:textField required='true' name="celular_numero" value="${contacto?.celular?.numero}"/>
    </br>

    </br>
    <p>Teléfono residencial</p>

    <label for="residencial_codigoRegional">Código Regional (Ejemplo; CABA 011)</label>
    <g:textField required='false' name="residencial_codigoRegional" value="${contacto?.residencial?.codigoRegional}"/>
    </br>
    <label for="residencial_numero">Número</label>
    <g:textField required='false' name="residencial_numero" value="${contacto?.residencial.numero}"/>
    </br>

    <p>Otro teléfono de contacto</p>
    <label for="otroTelefono">Numero</label>
    <g:textField required='false' name="otroTelefono" value="${contacto?.residencial?.codigoRegional}"/>
    </br>



  <!--required es para que no deje vacio los campos al presionar boton-->
 </fieldset>
</div>
