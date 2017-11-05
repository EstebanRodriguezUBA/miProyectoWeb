package fiuba.sii7571.miproyecto.publicacion
import fiuba.sii7571.miproyecto.etiqueta.*
import fiuba.sii7571.miproyecto.util.fecha.*
class Publicacion {
  Fecha fechaPublicacion
  String nombre
  String contenido
  static hasMany = [etiquetas:Etiqueta]
  static embedded = ['fechaPublicacion']
    static constraints = {
    }
}
