package fiuba.sii7571.miproyecto.cuenta
import fiuba.sii7571.miproyecto.consultorio.Consultor
import fiuba.sii7571.miproyecto.util.texto.*
import fiuba.sii7571.miproyecto.cuenta.Iniciador

import grails.gorm.DetachedCriteria

class CuentaController {

  def cuentaService
  String msgInvalido = "Ingreso incorrecto. Verifique."
  String mensaje_1 ="NO EXISTE UN USUARIO CON ESA INFORMACION.VERIFIQUE. "
  String mensaje_2 = "[Accion: ${actionName}, Controlador:${controllerName}] "


  def index(){
    flash.message = mensaje_2
    render view:'iniciarSesionVista'

  }
  def inicio(){
    render "Esta es la vista de escape de prueba.Testing invalidToken"
  }

  def iniciarRegistracionUsuario(){
    flash.message = "Fecha:${new Date()}"
    render view:'registrarUsuarioVista'
  }

  def registrarUsuario(IniciadorComando cmd){
    //render "Esta es la pantalla de registracion, en construccion"
    //render "Total usuarios registrados:${Cuenta.count()}"
    //render "Fecha:${new Date()}"

    if (cmd.hasErrors() || !cmd.validate() ){
      //errores de tipo DataBinding y constraints

      flash.message = "Fecha:${new Date()}"
      flash.hayErrores = msgInvalido

      render (view:'registrarUsuarioVista', model:[beanError:cmd])
      return
    }
    Cuenta cuentaEncontrada = cuentaService.verificarUnicidadCuenta(cmd)
      if (cuentaEncontrada){

        flash.message = "Ya existe ese usuario. Elija otro."
        render view:'registrarUsuarioVista'
        return
      }
      flash.message = "Felicitaciones. Creando cuenta..."
      Iniciador iniciador = cuentaService.crearIniciadorCuenta(cmd)

      if(!iniciador ){
        flash.message = "Error creando Iniciador de acceso a cuenta nueva.[Iniciador: datos para creacion:${cmd?.toString()}]"
        render view:'registrarUsuarioVista'
        return
      }
      //se redirige a que complete los formularios con su perfil
      session.iniciador = iniciador
      redirect (controller:'Perfil', action:'iniciarRegistracion')
}
  /**
  Nota:
  Se suspende el empleo de useToken, entonces no es necesario .withForm
  Se usa para CSRF y dobleclick(doblePost,dobleSubmitt,lo que sea).

  Se emplea en casos críticos. Ejemplo comprar (compra dos veces), depositar (deposita dos veces).
  */
  def iniciarSesion(IniciadorComando cmd){

    if (cmd.hasErrors() || !cmd.validate() ){
      flash.message = "Fecha:${new Date()}"
      flash.hayErrores = msgInvalido
      render (view:'iniciarSesionVista', model: [beanError:cmd])
      return
    }
    Cuenta cuentaEncontrada = cuentaService.verificarExisteCuenta(cmd)

    if(cuentaEncontrada){
      render "Bienvenido de nuevo a su sesion"
      session.cuenta = cuentaEncontrada
      render (view:'menuPrincipalUsuarioVista', model:[cuenta:session.cuenta])
      return
    }

    String mensaje_3 =" [Mail:${cmd?.nombreAcceso}, claveSecreta:${cmd?.claveAcceso}]"

    flash.message = mensaje_1 + "Fecha:${new Date()}"
    flash.hayErrores = mensaje_2 + mensaje_3
    render view:'iniciarSesionVista'


}

  def finalizarSesion(){
    session.cuenta = null
    render "Sesion Finalizada. Los esperamos nuevamente."
  }

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

  /***Grails NO SOPORTA validaciOn en cascada,sino es con un plugin de versiones anteriores.
  Considerar definir global constraints, shared constraints.
  **/
  //importFrom Iniciador  no sirve

   static constraints = {

    nombreAcceso blank:false, email:true
    /* Si utilizo este validator entro en conflicto entre registrar e iniciarSesion al querer reutilizarlo
    ,validator:{nombre->
      //evaluo que el nombre acceso sea unico
      //unique true falla con excepcion, asi sea correcto o no
      boolean consulta =(Cuenta.where{ iniciador.nombreAcceso.contenido == nombre} == null)
      consulta
    }
    */
    claveAcceso size: 4..25, blank:false, matches:'[A-Za-z0-9_]+',validator: { clave, esteObjeto->
    boolean igualados = true
    igualados  = clave.compareTo(esteObjeto.nombreAcceso)? true:false
    igualados
    }

    instanciaRetornada nullable:true
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
