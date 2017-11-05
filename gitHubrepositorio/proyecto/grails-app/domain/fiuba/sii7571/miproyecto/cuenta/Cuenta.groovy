package fiuba.sii7571.miproyecto.cuenta
import fiuba.sii7571.miproyecto.usuario.*
import fiuba.sii7571.miproyecto.cuenta.Iniciador

class Cuenta {
  /**
  *registracion
  */
  Iniciador iniciador

  Persona persona

  Actividad actividadCuenta
  /**
  *ComposiciOn
  */
  static embedded = ['persona','actividadCuenta','iniciador']

    static constraints = {
      //que no sean iguales
/*
      nombre blank:false, email:true, unique:true
      //alfanumErico incluyendo guiOn bajo
      claveAcceso size: 8..25, matches:"[A-Za-z0-9_]+", validator: { clave, nombre ->
        //clave notEqual: nombre corregir
        true
      }
*/
      persona nullable:true
      actividadCuenta nullable:true


    }
}
