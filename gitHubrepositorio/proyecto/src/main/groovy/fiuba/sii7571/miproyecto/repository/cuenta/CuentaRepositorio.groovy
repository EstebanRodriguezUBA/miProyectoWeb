package fiuba.sii7571.miproyecto.repository.cuenta
import fiuba.sii7571.miproyecto.repository.Repositor
import fiuba.sii7571.miproyecto.cuenta.*
import grails.gorm.DetachedCriteria
class CuentaRepositorio extends Repositor {

private CuentaRepositorio(){}

public static CuentaRepositorio obtenerRepositor(){
  new CuentaRepositorio()
}
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

  Cuenta buscarCuentaPorIniciador(Iniciador iniciador,byte max){
    def retorno = Cuenta.findByNombreAcceso(email,[max:max])

    (!retorno && retorno.size() > 0)?retorno.head():null
  }
  Cuenta buscarCuentaPorNombreAcceso(String contenido){
    //No Funcionan where queries con embedded objects.
    //Cuenta.where{ iniciador.nombreAcceso.contenido == cmd.nombreAcceso}
    //Cuenta retorno = Cuenta.where{iniciador.nombreAcceso.contenido == contenido }.find()
    def criterio = new DetachedCriteria(Cuenta).build {
    eq 'iniciador.nombreAcceso.contenido', contenido
  }
  /*Tambien para un solo valor de retorno find(). //criteriO.list(max:1)*/
    def resultado = criterio?criterio.get():null

    resultado
  }
/*
  Cuenta buscarCuentaUsuario (String nombre,String claveAcceso,byte max){
    //se supone que esto es mas robusto,segun documentacion Grails
  def retorno =  Cuenta.findAllByNombreAndClaveAcceso(nombre,claveAcceso,[max:max])
  (!retorno && retorno.size() > 0)?retorno.head():null
}
*/


}
