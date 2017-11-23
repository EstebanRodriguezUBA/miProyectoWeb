package fiuba.sii7571.miproyecto.consultorio
import fiuba.sii7571.miproyecto.repository.cuenta.CuentaRepositorio
import fiuba.sii7571.miproyecto.cuenta.Cuenta
import fiuba.sii7571.miproyecto.factoria.Creable

//Nota:Evaluar definir subclases consultorCuenta, consultorPerfil, etc
//Consultar aplicar singleton cuando los repositores ya lo son.
class Consultor {
  Creable repositor

  def setearRepositor(Creable repositor){
    repositor = repositor
  }
  //busqueda de cuenta para iniciar sesion por clase compuesta

 Cuenta buscarCuentaPorIniciador(Iniciador:iniciador){
   byte cantidadRecuperar = 1
   repositor?.buscarCuentaPorIniciador(iniciador,cantidadRecuperar)
 }

  Cuenta buscarCuentaUsuario(Iniciador:iniciador){
  //grails.web.servlet.mvc.GrailsParameterMap params){
    byte cantidadRecuperar = 1
    repositor?.buscarCuentaUsuario(iniciador?.nombreAcceso?.contenido,iniciador?.claveAcceso?.contenido,cantidadRecuperar)

  }
}
