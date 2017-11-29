package fiuba.sii7571.miproyecto.factoria.cuenta

import  fiuba.sii7571.miproyecto.factoria.Factoria
import  fiuba.sii7571.miproyecto.factoria.Creable
import  fiuba.sii7571.miproyecto.cuenta.Cuenta
import fiuba.sii7571.miproyecto.cuenta.Iniciador
import fiuba.sii7571.miproyecto.usuario.*
import fiuba.sii7571.miproyecto.util.texto.Texto

class CuentaFactoria  extends Factoria{

  Creable cuenta

  def crear(){
    cuenta = new Cuenta()

  }
  boolean configurar(Iniciador iniciador,Persona persona,Actividad actividadCuenta){

    cuenta?{

      cuenta.iniciador        = iniciador
      cuenta.persona          = persona
      cuenta.actividadCuenta  = actividadCuenta
      return true

    }:false
  }
  Creable obtener(){
    cuenta
  }
  static Iniciador crearIniciador(Texto nombreAcceso,Texto claveAcceso){
    new Iniciador(nombreAcceso:nombreAcceso, claveAcceso:claveAcceso)
  }
  static Actividad CrearActividad(){
    null
  }


}
