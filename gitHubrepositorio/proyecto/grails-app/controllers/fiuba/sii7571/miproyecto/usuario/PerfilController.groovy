package fiuba.sii7571.miproyecto.usuario
import fiuba.sii7571.miproyecto.util.tituloProfesional.TituloProfesional
import fiuba.sii7571.miproyecto.usuario.informacion.profesional.Estudio
import fiuba.sii7571.miproyecto.usuario.informacion.profesional.Gasista
import fiuba.sii7571.miproyecto.usuario.informacion.profesional.Profesion
import fiuba.sii7571.miproyecto.usuario.informacion.profesional.Gasista
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.Localizacion
import fiuba.sii7571.miproyecto.usuario.informacion.comunicacion.*
import fiuba.sii7571.miproyecto.usuario.informacion.personal.*

class PerfilController {
    def perfilService
    String msgInvalido = "Ingreso incorrecto. Verifique."

    def index() {
      render "Esto es el indice del controlador de perfil"
     }

    def iniciarRegistracion(){
      flash.message = "Bienvenido ${session.cuenta?.nombreAcceso?.contenido}. A continuacion ingrese su perfil. Muchas Gracias"
      //render "Redirigiendo desde ${actionName}"
      render view:'informePersonalVista'
      return
    }
    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    private retornarInformePersonal(){
      render (view:'informePersonalVista', model:[informePersonal:session.informePersonal])
    }

    def determinarInformePersonal(InformePersonalCommand cmd){

      if (cmd.hasErrors()){
        //errores tipo databinding

        flash.hayErrores = msgInvalido
        render (view:'informePersonalVista', model:[informePersonal:cmd,beanError:cmd])
        return
      }

      InformePersonal informePersonal = perfilService.determinarInformePersonal(cmd)

      if (!cmd.validate()){//(!informePersonal?.validate()){
      //retorna a la vista para corregir, no cumple requisitos(constraints)
      flash.hayErrores = msgInvalido
      render (view:'informePersonalVista', model:[informePersonal:cmd,beanError:informePersonal])
      return
      }

      session.informePersonal = informePersonal
      render (view:'contactoVista', model:[contacto:session.contacto])
    }

    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    private retornarContacto(){
      render (view:'contactoVista', model:[contacto:session.contacto])
    }

    def determinarContacto(ContactoCommand cmd){

      if (cmd.hasErrors()){
        //errores tipo databinding

        flash.hayErrores = msgInvalido
        render (view:'contactoVista', model:[contacto:cmd,beanError:cmd])
        return
      }
      Contacto contacto = perfilService.determinarContacto(cmd)

      if (!cmd?.validate()){//(!contacto?.validate()){
      //retorna a la vista para corregir, no cumple requisitos(constraints)
      flash.hayErrores = msgInvalido
      render (view:'contactoVista', model:[contacto:cmd,beanError:contacto])
      return
      }

      session.contacto = contacto
      render (view:'localizacionVista', model:[localizacion:session.localizacion])

    }
    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    def retornarLocalizacion(){
      render (view:'localizacionVista', model:[localizacion:session.localizacion])
    }

    def determinarLocalizacion(LocalizacionCommand cmd){

      if (cmd.hasErrors()){
        //errores tipo databinding
        flash.hayErrores = msgInvalido
        render (view:'localizacionVista', model:[localizacion:cmd,beanError:cmd,beanError:cmd])
        return
      }
      Localizacion localizacion = perfilService.determinarLocalizacion(cmd)

      if (!cmd.validate()){//(!localizacion?.validate()){
      //retorna a la vista para corregir, no cumple requisitos(constraints)
        flash.hayErrores = msgInvalido
        render (view:'localizacionVista', model:[localizacion:cmd,beanError:localizacion])
        return
      }

      session.localizacion = localizacion
      render (view:'profesionVista', model:[profesion:session.profesion])
    }
    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    def retornarSelectorProfesion(){
      render (view:'profesionVista', model:[profesion:session.profesion])
    }
    def determinarProfesion(ProfesionCommand cmd){
      /*render "Digame cual es su profesion, si es gasista detallar, sino ingresar otro."
      render "Esta definiendose la profesion con NULL de perfilService OJO falta implementar"
*/
      if (cmd.hasErrors()){
        //errores tipo databinding
        flash.hayErrores = msgInvalido
        render (view:'profesionVista', model:[profesion:cmd,beanError:cmd])
        return
      }
      Profesion profesion = perfilService.determinarProfesion(cmd)

      if (!cmd.validate()){//(!(profesion?.validate())){
        //retorna a la vista para corregir, no cumple requisitos(constraints)
        flash.hayErrores = msgInvalido
        render (view:'profesionVista', model:[profesion:cmd,beanError:profesion])
        return
      }
      session.profesion = profesion

      if (profesion?.tituloProfesional == TituloProfesional.GASISTA){
        render (view:'gasistaVista', model:[profesion:session.profesion])
        return
      }
      render (view:'estudioVista', model:[estudio:session.estudio])
    }

    def detallarProfesionGasista(ProfesionGasistaCommand cmd){
      if (cmd.hasErrors()){
        //errores tipo databinding
        flash.hayErrores = msgInvalido
        render (view:'gasistaVista', model:[gasista:cmd,beanError:cmd])
        return
      }
      Gasista gasista = perfilService.detallarProfesionGasista(cmd)

      if (!cmd?.validate()){//(!gasista?.validate()){
        //retorna a la vista para corregir, no cumple requisitos(constraints)
        flash.hayErrores = msgInvalido
        render (view:'gasistaVista', model:[gasista:cmd,beanError:gasista])
        return
      }
      session.profesion = gasista
      render (view:'estudioVista', model:[estudio:session.estudio])
    }

    def detallarEstudios(EstudioCommand cmd){
      if (cmd.hasErrors()){
        //errores tipo databinding
        flash.hayErrores = msgInvalido
        render (view:'estudioVista', model:[estudio:cmd,beanError:cmd])
        return
      }
      Estudio estudio = perfilService.detallarEstudios(cmd)

      if (!cmd.validate()){//(!estudio?.validate()){
        //retorna a la vista para corregir, no cumple requisitos(constraints)
        flash.hayErrores = msgInvalido
        render (view:'estudioVista', model:[estudio:cmd,beanError:estudio])
        return
      }
      session.estudio = estudio
      forward (action:'crearPerfil')
    }

    def crearPerfil(){

      Perfil perfil = PerfilFactoria.crear()?.configurar(session.informePersonal,        session.contacto,session.localizacion,null,   profesion:session.profesion).obtener()

      if(perfil?.hasErrors() && !perfil?.validate()){
        render "Algo salio mal ${session.toString()} ${persona.toString()}"
        return
      }
      render "Exito creando perfil y se envia a controlador de persona para persistir. ${perfil.toString()}"
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

class InformePersonalCommand {
  String nombre
  String apellido
  String nacionalidad
  boolean nativo
  char genero
  static constraints = {

  }

}
class ContactoCommand{

  String celular_codigoRegional
  String celular_numero
  String residencial_codigoRegional
  String residencial_numero
  String otroTelefono

}
class LocalizacionCommand {
  String provincia
  String ciudad
  String barrio
}
class ProfesionCommand{
  TituloProfesional tituloProfesional
}
class ProfesionGasistaCommand{

  byte categoria
  int matricula
  String distribuidora
}
class EstudioCommand{

  String tituloHabilitante
  String institucion
}
