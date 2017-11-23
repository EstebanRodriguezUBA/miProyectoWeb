package fiuba.sii7571.miproyecto.comando.cuenta
import fiuba.sii7571.miproyecto.comando.Comando

class IniciadorComando extends Comando{

  def instanciaRetornada=null //caso de exito retorna instancia de Cuenta
  //nota:recordar los constructores no se heredan
  IniciadorComando(Object params){
    super(params)

  }


  def enlazarParametros (){
    instancia?.nombre = parametros.nombre
    instancia?.claveAcceso = parametros.claveAcceso
  }

}
