package fiuba.sii7571.miproyecto.cuenta
import fiuba.sii7571.miproyecto.usuario.*
import fiuba.sii7571.miproyecto.cuenta.Iniciador
import fiuba.sii7571.miproyecto.factoria.Creable

class Cuenta implements Creable {
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
    
      persona nullable:true
      actividadCuenta nullable:true


    }
}
