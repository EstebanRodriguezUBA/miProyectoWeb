package fiuba.sii7571.miproyecto.factoria.usuario

import  fiuba.sii7571.miproyecto.factoria.Factoria
import  fiuba.sii7571.miproyecto.factoria.Creable
import  fiuba.sii7571.miproyecto.usuario.informacion.profesional.Estudio
import  fiuba.sii7571.miproyecto.util.tituloProfesional.TituloProfesional

class GasistaFactoria  extends ProfesionFactoria{


  boolean configurar(TituloProfesional tituloProfesional, Estudio estudio,byte categoria,int matricula,String distribuidora){
    profesion?{

      profesion.tituloProfesional = tituloProfesional
      profesion.estudio           = estudio
      profesion.categoria         = categoria
      profesion.matricula         = matricula
      profesion.distribuidora     = distribuidora
      return true

    }:false
  }
  Creable obtener(){
    profesion
  }


}
