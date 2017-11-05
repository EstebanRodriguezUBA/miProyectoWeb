package fiuba.sii7571.miproyecto.usuario
import fiuba.sii7571.miproyecto.util.fecha.*

class Actividad {
  Fecha fechaInscripto
  Fecha fechaUltimoAcceso
  Fecha fechaUltimoEgreso

  static embedded = ['fechaInscripto','fechaUltimoAcceso','fechaUltimoEgreso']
    static constraints = {
    }
}
