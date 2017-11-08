package fiuba.sii7571.miproyecto.cuenta
import fiuba.sii7571.miproyecto.consultorio.Consultor
import fiuba.sii7571.miproyecto.comando.cuentaComando.IniciadorComando
class CuentaController {

  def cuentaService

  def index(){
    flash.message = "Usted fue redirigido a inicio()"
    render view:'iniciarSesion'
    /*
CORREGIR
    tienen que ir a view inicio y el codigo de iniciandoSesion dentro de inicio(). luego de que pudo loguearse redirecciona a view iniciarSesion, entonces  se procesa en action iniciarSesion() lo que pase alli
    */
  }
  def inicio(){

  }

  def registrar(){
    render "Esta es la pantalla de registracion, en construccion"
    render "REGISTRACION:Total cuentas:${Cuenta.count()} hasta el momento"

    cuentaService.validar(params)?.hasErrors()?{
      registrador ->
      render (view:'registrar', model:[bean:registrador,nombreAccion:${actionName}])
    }:
    {
        new Consultor()?.buscar(Cuenta,params)?{
          cuentaEncontrada ->
          flash.message = "Ya existe un usuario con ese mail. Elija otro."
          redirect view:'registrar'
        }:
        {
          flash.message = "Felicitaciones. Creando cuenta..."
        }
    }
  }
  def iniciarSesion(){
    withForm {
        String msg =""
        def iniciador = new Iniciador()
        iniciador.nombre = params.nombre
        iniciador.claveAcceso = params.claveAcceso
        //def iniciador = new Iniciador(params)
        if (iniciador.hasErrors()){
          msg ="Hay errores databinding ${params.dump()}"
        }else if (!iniciador.validate()){
          msg ="Hay errores de validacion en constraints ${params.dump()}>>>>>>>>>>>> ${iniciador.dump()}"
        }else {
          msg ="Todo un exito ${params.dump()} >>>>>>>>>>>> ${iniciador.dump()}"
        }
          flash.message = msg
          //render (view:'iniciarSesion', model:[params:params])

        render (view:'iniciarSesion', model: [beanError:iniciador])
        return
      /*
        cuentaService.validar(params)?.hasErrors()?{
          iniciador ->
          render (view:'iniciarSesion', bean:iniciador)
        }:
        {
          new Consultor()?.buscarCuentaUsuario(Cuenta, params)?{
            cuentaEncontrada ->
            flash.message  = "Bienvenido ${cuentaEncontrada?.persona?.nombre}"
            session.cuenta = cuentaEncontrada
            redirect view:'inicio'
        }:
        {
            flash.message  = "No existe esa cuenta de usuario. Lo ingresado es valido pero no se corresponde con un usuario existente."
        }
        }
        */
    }.invalidToken {
        flash.message  = "Solicitud Duplicada. Paciencia."
        }


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
