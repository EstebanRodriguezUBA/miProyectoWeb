package fiuba.sii7571.miproyecto.usuario

import fiuba.sii7571.miproyecto.usuario.informacion.personal.*
import fiuba.sii7571.miproyecto.usuario.informacion.comunicacion.*
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.Localizacion
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.localizacion.*
import fiuba.sii7571.miproyecto.usuario.informacion.profesional.*
import fiuba.sii7571.miproyecto.usuario.informacion.publica.presentacion.Presentacion

import fiuba.sii7571.miproyecto.factoria.usuario.PerfilFactoria
import fiuba.sii7571.miproyecto.factoria.usuario.ProfesionFactoria
import fiuba.sii7571.miproyecto.factoria.usuario.GasistaFactoria

import grails.gorm.transactions.Transactional

@Transactional
class PerfilService {
    static scope ='session'
/**********************************CAMBIAR FACTORIA!!
    Persona crearUsuario(informePersonal,
      contacto,
      localizacion,
      presentacion,//falta implementar
      profesion){

      def usuario = new Persona (informePersonal:informePersonal,
        contacto:contacto,
        localizacion:localizacion,
        presentacion:null,//falta implementar
        profesion:profesion
        )
      usuario?.validate()
      usuario
    }
*/
    InformePersonal determinarInformePersonal(InformePersonalCommand cmd){

      //validar genero
      //def genero = PerfilFactoria.crearGenero(cmd.genero)
      def informePersonal = PerfilFactoria.crearInformePersonal(cmd.nombre,cmd.apellido,cmd.nacionalidad,cmd.nativo,cmd.genero)
      //informePersonal.genero = genero

      informePersonal

    }

    def determinarContacto(ContactoCommand cmd){
      //validar telefonos
      def celular = PerfilFactoria.crearTelefono (cmd.celular_codigoRegional,cmd.celular_numero)
      def fijo    = PerfilFactoria.crearTelefono (cmd.residencial_codigoRegional,cmd.residencial_numero)
      def otroTelefono = cmd.otroTelefono
      def contacto = PerfilFactoria.crearContacto (celular,fijo,otroTelefono)

      contacto
    }

    def determinarLocalizacion(LocalizacionCommand cmd){
      //validar direccion
      def direccion = PerfilFactoria.crearDireccion (cmd.provincia,cmd.ciudad,cmd.barrio)
      def localizacion = PerfilFactoria.crearLocalizacion (direccion)

      localizacion
    }

    def determinarProfesion(ProfesionCommand cmd){

      null

    }
    def detallarProfesionGasista(ProfesionGasistaCommand cmd){
      //Se que es gasista

        //Estudio aun no fue completado por usuario

        def gasista = new GasistaFactoria()?.crear().configurar(TituloProfesional.GASISTA,null,cmd.categoria,cmd.matricula,cmd.distribuidora).obtener()

        return gasista

    }
    def detallarEstudios(EstudioCommand cmd){

      def estudio = ProfesionFactoria.crearEstudio(cmd.properties)
      estudio
    }
    def crearPresentacion(){
      null
    }
    def crearProfesion(){
      null
    }

    def serviceMethod() {

    }
}
