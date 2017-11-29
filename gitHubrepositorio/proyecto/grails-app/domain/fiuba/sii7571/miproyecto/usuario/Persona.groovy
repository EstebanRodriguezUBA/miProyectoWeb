package fiuba.sii7571.miproyecto.usuario

import fiuba.sii7571.miproyecto.util.rol.Rol
import fiuba.sii7571.miproyecto.factoria.Creable

class Persona implements Creable{
  Rol rol
  Perfil perfil
  /**
  *Personas que sigo y que me siguen
  */
  static hasMany = [seguidos:Persona,siguiendome:Persona]

  //Actividad actividad

  static embedded = ['rol']

    static constraints = {
    }
}
