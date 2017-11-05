package fiuba.sii7571.miproyecto.usuario

class PerfilController {
    def perfilService

    def index() { }

    def crearPersona(){
      render(view:"/usuario/persona")
    }

    def iniciarRegistracion(){

    }
    private determinarInformePersonal(){
      def informePersonal = perfilService.determinarInformePersonal(params)
      informePersonal.hasErrors()?{
        invalido ->
        forward (view:'informePersonalVista', bean:invalido)
      }:{
        chain (action:'determinarContacto',model:[informePersonal:informePersonal])
      }

    }
    private determinarContacto(){
      def contacto = perfilService.determinarContacto(params)
      contacto.hasErrors()?{
        invalido ->
        forward (view:'contactoVista', bean:invalido)
      }:{
        chain (action:'determinarLocalizacion',model:[contacto:contacto])
      }

    }
    private determinarLocalizacion(){
      def localizacion = perfilService.determinarLocalizacion(params)
      localizacion.hasErrors()?{
        invalido ->
        forward (view:'localizacionVista', bean:invalido)
      }:{
        chain (action:'determinarProfesion',model:[localizacion:localizacion])
      }
    }
    private determinarProfesion(){
      render "Digame cual es su profesion, si es gasista detallar, sino ingresar otro."
      forward (view:'profesionVista')
      perfilService.determinarProfesion(params)?:{
        flash.message ="Esta definiendose la profesion con NULL de perfilService OJO falta implementar"
        chain (action:'detallarProfesion')
      }

    }
    private detallarProfesion(){
      def profesion = perfilService.detallarProfesion(params)
      profesion.hasErrors()?{
        invalido ->
        forward (view:'detallarProfesionVista', bean:invalido)
      }:{
        chain (action:'crearUsuario',model:[profesion:profesion])
      }
    }
    private crearUsuario(){

    def persona = perfilService.crearUsuario(informePersonal:informePersonal,
      contacto:contacto,
      localizacion:localizacion,
      presentacion:null,//falta implementar
      profesion:profesion
      )?.hasErrors()?{
      render "Algo salio mal ${params.toString()} ${persona.toString()}"
    }:{
      //TEMPORALmente:a proposito no valido si fuese null
      persona.save(failOnError)?{
        render "Exito creando usuario y persistiendo. ${persona.toString()}"
      }:{
        render "Algo salio mal no pudo ser persistido. ${persona.toString()}"
      }
    }
    }
/**
*Interceptor: La referencia al metodo, .& ,para convertirlo en closure
*/
    def beforeInterceptor = [action: this.&autorizar, except:["index","iniciarRegistracion"]]
//Evaluo si no hay sesion iniciada volver al indice
    private autorizar(){
      //Evaluar determinar si esta la sesion iniciada y puede acceder alguna accion de registracion. Y si lo hace en el acto de registro
      session.cuenta?:{redirect (action:"index")}
    }
}
