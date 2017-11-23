package fiuba.sii7571.miproyecto.factoria.cuenta

import  fiuba.sii7571.miproyecto.factoria.Factoria
import  fiuba.sii7571.miproyecto.cuenta.Cuenta
import fiuba.sii7571.miproyecto.cuenta.Iniciador
import fiuba.sii7571.miproyecto.usuario.*
import fiuba.sii7571.miproyecto.util.texto.*

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
  static Iniciador crearIniciador(Email nombreAcceso,ClaveSecreta claveAcceso){
    new Iniciador(nombreAcceso, claveAcceso)
  }
  static Actividdad CrearActividad(){
    null
  }
  static Email crearEmail (String email){
    new Email(email)
  }
  static ClaveSecreta crearClaveSecreta(String claveSecreta){
    new ClaveSecreta(claveSecreta)
  }
}
