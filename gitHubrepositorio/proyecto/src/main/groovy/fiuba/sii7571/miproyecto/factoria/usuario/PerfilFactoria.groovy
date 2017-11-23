package fiuba.sii7571.miproyecto.factoria.usuario
import  fiuba.sii7571.miproyecto.factoria.Factoria
import  fiuba.sii7571.miproyecto.usuario.*

class PefilFactoria  extends Factoria{

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
  static Direccion crearDireccion(String provincia,String direccion,String ciudad,String barrio){
    new Direccion(provincia,direccion,ciudad,barrio)
  }

  static Localizacion crearLocalizacion(Direccion direccion){
    new Localizacion(direccion)
  }

  static Telefono crearTelefono(String codigoRegional,String numero){
    new Telefono(codigoRegional,numero)
  }

  static Contacto crearContacto(Telefono celular, Telefono residencial, String otroTelefono){
    new Contacto(celular,residencial,otroTelefono)
  }
  static Genero crearGenero(char genero)
  new Genero (genero)

  static InformePersonal crearInformePersonal(String nombre,String apellido,  String nacionalidad,boolean nativo,char genero ){
    new InformePersonal(nombre,apellido,nacionalidad,nativo,genero)

  }
}
