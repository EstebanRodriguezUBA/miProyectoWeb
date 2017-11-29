package  fiuba.sii7571.miproyecto.factoria.usuario

import  fiuba.sii7571.miproyecto.factoria.*
import  fiuba.sii7571.miproyecto.usuario.informacion.profesional.Estudio
import  fiuba.sii7571.miproyecto.usuario.informacion.profesional.Profesion
import  fiuba.sii7571.miproyecto.util.tituloProfesional.TituloProfesional

class ProfesionFactoria  extends Factoria{

  Creable profesion

  def crear(){
    profesion = new Profesion()

  }
  boolean configurar(TituloProfesional tituloProfesional, Estudio estudio){
    profesion?{

      profesion.tituloProfesional = tituloProfesional
      profesion.estudio = estudio
      return true

    }:false
  }
  Creable obtener(){
    profesion
  }

  static Estudio crearEstudio(String tituloHabilitante, String institucion){
    new Estudio (tituloHabilitante,institucion)
  }
}
