package fiuba.sii7571.miproyecto.cuenta
import fiuba.sii7571.miproyecto.consultorio.Consultor
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
        render (view:'registrar', bean:registrador)
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
