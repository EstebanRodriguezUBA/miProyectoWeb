package fiuba.sii7571.miproyecto.factoria.usuario

import  fiuba.sii7571.miproyecto.factoria.Factoria
import  fiuba.sii7571.miproyecto.factoria.Creable

import  fiuba.sii7571.miproyecto.usuario.*
import  fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.Localizacion
import  fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.localizacion.Direccion
import  fiuba.sii7571.miproyecto.usuario.informacion.comunicacion.*
import  fiuba.sii7571.miproyecto.usuario.informacion.personal.*
import  fiuba.sii7571.miproyecto.usuario.informacion.profesional.*
import  fiuba.sii7571.miproyecto.usuario.informacion.publica.presentacion.*
import  fiuba.sii7571.miproyecto.util.tituloProfesional.TituloProfesional

class PerfilFactoria  extends Factoria{

  Creable perfil

  def crear(){
    perfil = new Perfil()

  }
  boolean configurar(InformePersonal informePersonal,Contacto contacto,Localizacion localizacion,Presentacion presentacion,Profesion profesion){
    perfil?{

      perfil.informePersonal  = informePersonal
      perfil.contacto         = contacto
      perfil.localizacion     = localizacion
      perfil.presentacion     = presentacion
      return true

    }:false

  }

  Creable obtener(){
    perfil
  }

  static Profesion crearProfesion(TituloProfesional tituloProfesional,Estudio estudio){
  new Profesion(tituloProfesional,estudio)
  }
  static Direccion crearDireccion(String provincia,String ciudad,String barrio){
    new Direccion(provincia:provincia,ciudad:ciudad,barrio:barrio)
  }

  static Localizacion crearLocalizacion(Direccion direccion){
    new Localizacion(direccion:direccion)
  }

  static Telefono crearTelefono(String codigoRegional,String numero){
    new Telefono(codigoRegional:codigoRegional,numero:numero)
  }

  static Contacto crearContacto(Telefono celular, Telefono residencial, String otroTelefono){
    new Contacto(celular:celular,residencial:residencial,otroTelefono:otroTelefono)
  }
  static Genero crearGenero(char genero){
  new Genero (genero)
 }

  static InformePersonal crearInformePersonal(String nombre,String apellido,  String nacionalidad,boolean nativo,char genero ){
    new InformePersonal(nombre:nombre,apellido:apellido,nacionalidad:nacionalidad,nativo:nativo,genero:genero)

  }
}
