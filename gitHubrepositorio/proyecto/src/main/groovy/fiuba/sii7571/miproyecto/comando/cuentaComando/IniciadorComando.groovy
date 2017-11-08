package fiuba.sii7571.miproyecto.comando

class IniciadorComando extends Comando{

  boolean validado = false
  boolean erradoEnlazado = false //errores de databinding
  boolean erradoValidado = false//errores de validacion en constraints
  def  instancia = null
  def  parametros
  Comando (parametros:params){
    parametros = params
  }

  def enlazarParametros (){
    instancia?.nombre = parametros.nombreAccion
    instancia?.claveAcceso = parametros.claveAcceso
  }

}
