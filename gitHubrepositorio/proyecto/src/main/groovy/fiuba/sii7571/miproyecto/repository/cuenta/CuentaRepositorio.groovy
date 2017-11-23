package fiuba.sii7571.miproyecto.repository.cuenta
import fiuba.sii7571.miproyecto.repository.Repositor
import fiuba.sii7571.miproyecto.cuenta.Cuenta

class CuentaRepositorio extends Repositor {

  def obtener(Object id){
    "IMPLEMENTAR"
}
  def crear(){
    "IMPLEMENTAR"
  }
  def actualizar(Object entidad){
    "IMPLEMENTAR"
  }
  def modificar(Object entidad){
    "IMPLEMENTAR"
  }
  def borrar(Object entidad){
    "IMPLEMENTAR"
  }
  Cuenta buscarCuentaPorIniciador(Iniciador iniciador,1){
    Cuenta retorno = Cuenta.findByNombreAcceso(email,[max:max])

    (!retorno && retorno.size() > 0)?retorno.head():null
  }
  Cuenta buscarCuentaPorNombreAcceso(Email email,byte max){
    Cuenta retorno = Cuenta.findByNombreAcceso(email,[max:max])

    (!retorno && retorno.size() > 0)?retorno.head():null
  }

  Cuenta buscarCuentaUsuario (String nombre,String claveAcceso,byte max){
    //se supone que esto es mas robusto,segun documentacion Grails
  Cuenta retorno =  Cuenta.findAllByNombreAndClaveAcceso(nombre,claveAcceso,[max:max])

  (!retorno && retorno.size() > 0)?retorno.head():null

}

}
