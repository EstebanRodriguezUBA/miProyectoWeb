package fiuba.sii7571.miproyecto.usuario
import fiuba.sii7571.miproyecto.util.fecha.*

class Actividad {
  Fecha fechaInscripto
  RangoFecha ultimaSesion
  Fecha inicioSesionActual
  
  //ultima publicacion?primera publicacion?
  static embedded = ['fechaInscripto','ultimaSesion']
    static constraints = {
    }
}
