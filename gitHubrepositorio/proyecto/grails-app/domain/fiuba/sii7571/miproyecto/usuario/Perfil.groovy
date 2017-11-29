package fiuba.sii7571.miproyecto.usuario
import fiuba.sii7571.miproyecto.usuario.informacion.personal.InformePersonal
import fiuba.sii7571.miproyecto.usuario.informacion.comunicacion.Contacto
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.Localizacion
import fiuba.sii7571.miproyecto.usuario.informacion.publica.presentacion.Presentacion

import fiuba.sii7571.miproyecto.factoria.Creable

class Perfil implements Creable{

  InformePersonal informePersonal
  Contacto contacto
  Localizacion localizacion
  Presentacion presentacion

  static embedded = ['informePersonal','contacto','localizacion','presentacion']
    static constraints = {
    }
}
