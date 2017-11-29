package fiuba.sii7571.miproyecto.usuario.informacion.profesional

import fiuba.sii7571.miproyecto.util.tituloProfesional.TituloProfesional
import  fiuba.sii7571.miproyecto.factoria.Creable
class Profesion implements Creable{
    TituloProfesional tituloProfesional
    //String nombre

    Estudio estudio
    static constraints = {
      estudio nullable:true
    }
}
