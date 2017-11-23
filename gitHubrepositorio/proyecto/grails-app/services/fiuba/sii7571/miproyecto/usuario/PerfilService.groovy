package fiuba.sii7571.miproyecto.usuario

import fiuba.sii7571.miproyecto.usuario.informacion.personal.*
import fiuba.sii7571.miproyecto.usuario.informacion.comunicacion.*
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.Localizacion
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.localizacion.*
import fiuba.sii7571.miproyecto.usuario.informacion.profesional.*
import fiuba.sii7571.miproyecto.usuario.informacion.publica.Presentacion
import fiuba.sii7571.miproyecto.util.*
import fiuga.sii7571.miproyecto.factoria.usuario.PerfilFactoria
import fiuga.sii7571.miproyecto.factoria.usuario.ProfesionFactoria
import grails.gorm.transactions.Transactional

@Transactional
class PerfilService {
    static scope ='session'
**********************************CAMBIAR FACTORIA!!
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
    InformePersonal determinarInformePersonal(InformePersonalComando cmd){

      //validar genero
      //def genero = PerfilFactoria.crearGenero(cmd.genero)
      def informePersonal = PerfilFactoria.crearInformePersonal(cmd.properties)
      //informePersonal.genero = genero

      informePersonal

    }

    def determinarContacto(ContactoComando cmd){
      //validar telefonos
      def celular = PerfilFactoria.crearTelefono (codigoRegional:cmd.celular_codigoRegional,numero:cmd.celular_numero)
      def fijo    = PerfilFactoria.crearTelefono (codigoRegional:cmd.residencial_codigoRegional,numero:cmd.residencial_numero)
      def otroTelefono = cmd.otroTelefono
      def contacto = PerfilFactoria.crearContacto (celular:celular,fijo:fijo,otroTelefono:otroTelefono)

      contacto
    }

    def determinarLocalizacion(LocalizacionComando cmd){
      //validar direccion
      def direccion = PerfilFactoria.crearDireccion (cmd.properties)
      def localizacion = PerfilFactoria.crearLocalizacion (direccion:direccion)

      localizacion
    }

    def determinarProfesion(ProfesionComando cmd){

      null

    }
    def detallarProfesionGasista(ProfesionGasistaComando cmd){
      //Se que es gasista

        //Estudio aun no fue completado por usuario

        def gasista = new GasistaFactoria()?.crear().configurar(TituloProfesional.GASISTA,null,cmd.categoria,cmd.matricula,cmd.distribuidora).obtener()

        return gasista

    }
    def detallarEstudios(EstudioComando cmd){

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
