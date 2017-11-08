package fiuba.sii7571.miproyecto.comando

class Comando {

  boolean validado        = false
  boolean erradoEnlazado  = false //errores de databinding
  boolean erradoValidado  = false//errores de validacion en constraints
  def  instancia          = null
  def  parametros         = null
  Comando (parametros:params){
    parametros = params
  }
  def setearInstancia(instancia: instanciaEnlazable){
    instancia = instanciaEnlazable
  }
  def enlazarParametros (){
    //databinding automatico en clase padre
    //Nota:recordar error salta debido al uso de useToken en g:form
    //xq no encuentra parametros a quien asignar SYNCHORONIZED_[id,uri]
    //tambien esta metodo dataBind(...) de DataBinder
    instancia?{
      instancia.properties = parametros
    }
  }
  def comprobarErrores = {
    erradoEnlazado = instancia?.hasErrors()?true:false
    validado = instancia?.validate()?true:false
    erradoValidado = instancia?.hasErrors()?true:false
    (!erradoEnlazado && validado && !erradoValidado)
  }
  boolean validar (){

    enlazarParametros()
    comprobarErrores() //retorna boolean
  }
}
