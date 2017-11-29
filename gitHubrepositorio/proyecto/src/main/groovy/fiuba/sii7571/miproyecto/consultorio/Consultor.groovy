package fiuba.sii7571.miproyecto.consultorio
import fiuba.sii7571.miproyecto.repository.cuenta.CuentaRepositorio
import fiuba.sii7571.miproyecto.cuenta.Cuenta
import fiuba.sii7571.miproyecto.cuenta.Iniciador
import fiuba.sii7571.miproyecto.factoria.Creable

//Nota:Evaluar definir subclases consultorCuenta, consultorPerfil, etc
//Consultar aplicar singleton cuando los repositores ya lo son.
class Consultor {
  private Creable repositor

  private Consultor(){}
  private Consultor(Creable repositor){
    this.repositor = repositor
  }

  public static Consultor obtener(Creable repositor){
    Consultor consultor = repositor?new Consultor(repositor):null
    consultor
  }

  def setearRepositor(Creable repositor){
    this.repositor = repositor
  }
  //busqueda de cuenta para iniciar sesion por clase compuesta

 Cuenta buscarCuentaPorIniciador(Iniciador iniciador){
   byte cantidadRecuperar = 1
   repositor?.buscarCuentaPorIniciador(iniciador,cantidadRecuperar)
 }
 Cuenta buscarCuentaPorNombreAcceso(String contenido){
   repositor?.buscarCuentaPorNombreAcceso(contenido)
 }
/*
  Cuenta buscarCuentaUsuario(Iniciador iniciador){
  //grails.web.servlet.mvc.GrailsParameterMap params){
    byte cantidadRecuperar = 1
    repositor?.buscarCuentaUsuario(iniciador?.nombreAcceso?.contenido,iniciador?.claveAcceso?.contenido,cantidadRecuperar)
  }
  */



}
