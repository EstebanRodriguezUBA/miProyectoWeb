package fiuba.sii7571.miproyecto.consultorio
import fiuba.sii7571.miproyecto.repository.cuentaRepositorio.CuentaRepositorio

class Consultor {

  def buscar(Object entidad,params){
    new CuentaRepositorio ()?.buscar(entidad,params.nombre,1)
  }
  //busqueda de cuenta para iniciar sesion
  def buscarCuentaUsuario(Object entidad,params){
    new CuentaRepositorio ()?.buscar(entidad,params.nombre,params.claveAcceso,1)
  }
}
