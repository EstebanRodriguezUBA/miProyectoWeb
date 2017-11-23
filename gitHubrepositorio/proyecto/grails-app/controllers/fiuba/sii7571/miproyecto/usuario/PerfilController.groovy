package fiuba.sii7571.miproyecto.usuario

class PerfilController {
    def perfilService
    String msgInvalido = "Ingreso incorrecto. Verifique."

    def index() { }
**************Cambiar Factoria
    def crearPerfil(){
      render(view:"/usuario/persona")
    }

    def iniciarRegistracion(){

    }
    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    private retornarInformePersonal(){
      render (view:'informePersonalVista', model:[informePersonal:session.informePersonal])
    }

    private determinarInformePersonal(InformePersonalComando cmd){

      if (cmd.hasErrors()){
        //errores tipo databinding

        flash.hayErrores = msgInvalido
        render (view:'informePersonalVista', model:[informePersonal:cmd])
      }else{

        InformePersonal informePersonal = perfilService.determinarInformePersonal(cmd)

        if (!informePersonal?.validate()){
        //retorna a la vista para corregir, no cumple requisitos(constraints)
        flash.hayErrores = msgInvalido
        render (view:'informePersonalVista', model:[informePersonal:cmd])
        return

        }else{

          session.informePersonal = informePersonal
          render (view:'contactoVista', model:[contacto:session.contacto])
          return
        }
      }
}

    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    private retornarContacto(){
      render (view:'contactoVista', model:[contacto:session.contacto])
    }

    private determinarContacto(ContactoComando cmd){

      if (cmd.hasErrors()){
        //errores tipo databinding

        flash.hayErrores = msgInvalido
        render (view:'contactoVista', model:[contacto:cmd])

      }else{

        Contacto contacto = perfilService.determinarContacto(cmd)

        if (!contacto?.validate()){
        //retorna a la vista para corregir, no cumple requisitos(constraints)
        flash.hayErrores = msgInvalido
        render (view:'contactoVista', model:[contacto:cmd])
        return

        }else{

        session.contacto = contacto
        render (view:'localizacionVista', model:[localizacion:session.localizacion])
        return
      }
    }
  }

    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    private retornarLocalizacion(){
      render (view:'localizacionVista', model:[localizacion:session.localizacion])
    }

    private determinarLocalizacion(LocalizacionComando cmd){

      if (cmd.hasErrors()){
        //errores tipo databinding

        flash.hayErrores = msgInvalido
        render (view:'localizacionVista', model:[localizacion:cmd])
      }else{

        Localizacion localizacion = perfilService.determinarLocalizacion(cmd)

        if (!localizacion?.validate()){
        //retorna a la vista para corregir, no cumple requisitos(constraints)
          flash.hayErrores = msgInvalido
          render (view:'localizacionVista', model:[localizacion:cmd])
          return

        }else{

          session.localizacion = localizacion
          render (view:'profesionVista', model:[profesion:session.profesion])
          return
        }
    }
  }

    //Acccion a la que se accede de la vista al presionar Volver mientras se esta registrando la persona
    private retornarSelectorProfesion(){
      render (view:'profesionVista', model:[profesion:session.profesion])
    }


    private determinarProfesion(ProfesionComando cmd){
      render "Digame cual es su profesion, si es gasista detallar, sino ingresar otro."
      render "Esta definiendose la profesion con NULL de perfilService OJO falta implementar"
      if (cmd.hasErrors()){
        //errores tipo databinding

        flash.hayErrores = msgInvalido
        render (view:'profesionVista', model:[profesion:cmd])

      }else{

        Profesion profesion = perfilService.determinarProfesion(cmd)

        if (!profesion?.validate()){
          //retorna a la vista para corregir, no cumple requisitos(constraints)
          flash.hayErrores = msgInvalido
          render (view:'profesionVista', model:[profesion:cmd])
          return

        }else{

          session.profesion = profesion
          if (profesion?.tituloProfesional == TituloProfesional.GASISTA){
            render (view:'gasistaVista', model:[profesion:session.profesion])
            return
          }else
            render (view:'estudioVista', model:[estudio:session.estudio])
            return
        }
      }
    }

    private detallarProfesionGasista(ProfesionGasistaComando cmd){
      if (cmd.hasErrors()){
        //errores tipo databinding
        flash.hayErrores = msgInvalido
        render (view:'gasistaVista', model:[gasista:cmd])

      }else{

        Gasista gasista = perfilService.detallarProfesionGasista(cmd)

        if (!gasista?.validate()){
          //retorna a la vista para corregir, no cumple requisitos(constraints)
          flash.hayErrores = msgInvalido
          render (view:'gasistaVista', model:[gasista:cmd])
          return

        }else{

          session.profesion = gasista
          render (view:'estudioVista', model:[estudio:session.estudio])
          return
        }
      }
    }
    private detallarEstudios(EstudioComando cmd){
      if (cmd.hasErrors()){
        //errores tipo databinding

        flash.hayErrores = msgInvalido
        render (view:'estudioVista', model:[estudio:cmd])

      }else{

        Estudio estudio = perfilService.detallarEstudios(cmd)

        if (!estudio?.validate()){
          //retorna a la vista para corregir, no cumple requisitos(constraints)
          flash.hayErrores = msgInvalido
          render (view:'estudioVista', model:[estudio:cmd])
          return

        }else{

            session.estudio = estudio
            forward (action:'crearPerfil')
            return
        }
      }
    }

    private crearPerfil(){

      Perfil perfil = PerfilFactoria.crear()?.configurar(session.informePersonal,        session.contacto,session.localizacion,null,   profesion:session.profesion).obtener()

        pefil?.hasErrors()?{
        render "Algo salio mal ${session.toString()} ${persona.toString()}"
      }:{
          render "Exito creando perfil y se envia a controlador de persona para persistir. ${perfil.toString()}"
          return
        }:{
          render "Algo salio mal no pudo ser creado perfil. ${persona.toString()}"
          return
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

class InformePersonalComando {
  String nombre
  String apellido
  String nacionalidad
  boolean nativo
  char genero


}
class ContactoComando{

  String celular_codigoRegional
  String celular_numero
  String residencial_codigoRegional
  String residencial_numero
  String otroTelefono

}
class LocalizacionComando {
  String provincia
  String ciudad
  String barrio
}
class ProfesionComando{
  TituloProfesional tituloProfesional
}
class ProfesionGasistaComando{

  byte categoria
  int matricula
  String distribuidora
}
class EstudioComando{

  String tituloHabilitante
  String institucion
}
