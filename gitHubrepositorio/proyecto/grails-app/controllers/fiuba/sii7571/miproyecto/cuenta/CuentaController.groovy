package fiuba.sii7571.miproyecto.cuenta
import fiuba.sii7571.miproyecto.consultorio.Consultor
import fiuba.sii7571.miproyecto.factoria.repositorio.RepositorFactoria
import fiuba.sii7571.miproyecto.util.texto.*


class CuentaController {

  def cuentaService
  Consultor consultor = new Consultor()

  def index(){
    flash.message = "Usted esta siendo redirigido a inicio()"
    render view:'iniciarSesion'

  }
  def inicio(){
    render "Esta es la vista de escape de prueba.Testing invalidToken"
  }

  //corregir :falta comando.
  def registrar(falta_IniciadorcomandoCorregido){
    render "Esta es la pantalla de registracion, en construccion"
    render "REGISTRACION:Total cuentas:${Cuenta.count()} hasta el momento"

    cuentaService.validarCorregir(params)?.hasErrors()?{
      registrador ->
      render (view:'registrar', model:[bean:registrador,nombreAccion:${actionName}])
    }:
    {
        Consultor consultor = new Consultor()
        consultor.setearRepositor(CuentaRepositorio.obtenerRepositor())

        consultor?.buscarCuentaPorIniciador(new Iniciador(new Email (params.nombre),new ClaveSecreta(params.claveAcceso)))?{
          cuentaEncontrada ->
          flash.message = "Ya existe un usuario con ese mail. Elija otro."
          redirect view:'registrar'
        }:
        {
          flash.message = "Felicitaciones. Creando cuenta..."
        }
    }
  }
  /**
  Nota:
  Se suspende el empleo de useToken, entonces no es necesario .withForm
  Se usa para CSRF y dobleclick(doblePost,dobleSubmitt,lo que sea).

  Se emplea en casos críticos. Ejemplo comprar (compra dos veces), depositar (deposita dos veces).
  */
  def iniciarSesion(IniciadorComando cmd){
    /**
    *
    Nota:IniciadorComando implementa Validateable
    */

    //corregir
    IniciadorComan cmd = cuentaService.iniciarSesion(cmd_Corregir)

    cmd?:{render "Algo salio mal: accion $actionName -- controlador $controlName"
    return}

    String msg =''

    if (cmd.instanciaRetornada){
      render "${cmd.mensaje}. Info cuenta: ${cmd.instanciaRetornada.dump()}"
      return
    }else{

      println "ERROR VALIDACION ${cmd.instancia.dump()}"
      msg    = cmd.mensaje
      flash.message = msg
      flash.hayErrores = msg + "Fecha:${new Date()}"

      render (view:'iniciarSesion', model: [beanError:cmd.instancia])

      return
    }
    render "algo salio mal ---${cmd.dump()}---"
    return

}

  def finalizarSesion(){
    session.cuenta = null
    render "Sesion Finalizada. Los esperamos nuevamente."
  }
/****************************************************************/
/**
*Interceptor: La referencia al metodo, .& ,para convertirlo en closure
*/
    def beforeInterceptor = [action: this.&autorizar, except:["index","inicio"]]
//Evaluo si no hay sesion iniciada volver al indice
    private autorizar(){
      session.cuenta?:{redirect (action:"index")}
    }
}
/*********Objetos Comando*************/
class IniciadorComando {

  String nombreAcceso
  String claveAcceso

  def instanciaRetornada=null

  static static constraints = {
    /***Grails NO SOPORTA validaciOn en cascada,sino es con un plugin de versiones anteriores.
    Considerar definir global constraints, shared constraints.
    **/
    //importFrom Iniciador  no sirve
    //importFrom Email      no sirve
    //importFrom ClaveSecreta no sirve
    nombreAcceso blank:false, email:true,validator:{nombre,esteObjeto->
      def encontrado = null

      Email email = CuentaFactoria.crearEmail(nombre)
      ClaveSecreta claveSecreta = CuentaFactoria.crearClaveSecreta(esteObjeto.claveAcceso)
      Iniciador iniciador = CuentaFactoria.crearIniciador(email,claveSecreta)

      encontrado = (new Consultor()?.CuentaRepositorio.obtenerRepositor()?.buscarCuentaPorIniciador(iniciador) == null)

      encontrado
    }
      claveAcceso size: 4..25, blank:false, matches:'[A-Za-z0-9_]+',validator: { clave, esteObjeto->
      boolean igualados = true
      igualados  = clave.compareTo(esteObjeto.nombreAcceso)? true:false
      igualados
    }



  }


}
/**
*Nota personal:inconvenientes al implementar invalid con retorno de Vista.
withForm {

    sleep (2000)//para test invalidToken
    String msg =""
    def iniciador = new Iniciador()
    iniciador.nombre = params.nombre
    iniciador.claveAcceso = params.claveAcceso

    if (iniciador.hasErrors()){
      msg ="Errores databinding:" // ${params.dump()}"
    }else if (!iniciador.validate()){
      msg ="Errores de validacion:"
      //${params.dump()}>>>>>>>>>>>> ${iniciador.dump()}"
    }else {
      msg ="Exito:"// ${params.dump()} >>>>>>>>>>>> ${iniciador.dump()}"
    }
    /*Nota: Si se realiza un duplicateSubmission, dobleclick,va a ir a invalidToken.
    pero el retorno muestra el mensaje en pantalla de errores existentes o Exito.
    Lo que parece suceder es que el retorno a la pagina anterior,que corresponde al primer click,primer submitt, pero el contenido de model se pierde para esa petición. flash subsiste, vale para la petición siguiente(desde el primer click)..
    Según se entiende de documentación.
*/
//          flash.message = msg
//          flash.hayErrores = msg + "Fecha:${new Date()}"

/*redirect envia una solicitud que no pasa por la vista y entra en invalidToken nuevamente
redirect (action:'iniciarSesion',model: [beanError:iniciador])
*/
//          render (view:'iniciarSesion', model: [beanError:iniciador])
      //return no hace falta luego de pruebas.Considerar si bean queda null

//   }.invalidToken {
 /**
 * Nota personal: Sin este bloque, usando solo "g:it test flash.tokeninvalido"
 * da a lugar a error error-muchos-direccionamientos
 porlo que se maneja a priori el error derivando a otra vista
 */

//        flash.invalidToken = "Token Invalido: Fecha:${new Date()}"
//        render (template:'/compartido/tokenInvalidoTemplate')

    //return
//    }
