package fiuba.sii7571.miproyecto.factoria.usuario

import  fiuba.sii7571.miproyecto.factoria.Factoria
import  fiuba.sii7571.miproyecto.factoria.Creable
import  fiuba.sii7571.miproyecto.usuario.Persona
import  fiuba.sii7571.miproyecto.usuario.Perfil
import  fiuba.sii7571.miproyecto.util.rol.Rol


class PersonaFactoria  extends Factoria{

  Creable persona

  def crear(){
    persona = new Persona()

  }
  boolean configurar(Rol rol,Perfil perfil){
    persona?{

      persona.rol = rol
      persona.perfil = perfil
      return true

    }:false
  }
  Creable obtener(){
    persona
  }
}
