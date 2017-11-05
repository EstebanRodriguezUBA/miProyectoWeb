package fiuba.sii7571.miproyecto.usuario

import fiuba.sii7571.miproyecto.usuario.informacion.personal.*
import fiuba.sii7571.miproyecto.usuario.informacion.comunicacion.*
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.Localizacion
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.localizacion.*
import fiuba.sii7571.miproyecto.usuario.informacion.profesional.*
import fiuba.sii7571.miproyecto.usuario.informacion.publica.Presentacion
import fiuba.sii7571.miproyecto.util.*

import grails.gorm.transactions.Transactional

@Transactional
class PerfilService {
    static scope ='session'

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
    InformePersonal determinarInformePersonal(params){
      //validar genero
      def genero = new Genero(params.genero)
      def informePersonal = new InformePersonal ()
      informePersonal.properties = params
      informePersonal.genero = genero

      informePersonal?.validate()
      informePersonal

    }

    def determinarContacto(params){
      //validar telefonos
      def celular = new Telefono (params.celular)
      def fijo    = new Telefono (params.fijo)
      def otroTelefono = new Telefono (params.otroTelefono)
      def contacto = new Contacto (celular:celular,fijo:fijo,otroTelefono:otroTelefono)

      contacto?.validate()
      contacto
    }
    def determinarLocalizacion(params){
      //validar direccion
      def direccion = new Direccion (params)
      def localizacion = new Localizacion (direccion:direccion)

      localizacion?.validate()
      localizacion
    }
    def determinarProfesion(){
      null

    }
    def detallarProfesion(params){
      params.gasista.equals(TituloProfesional.GASISTA)?{
        //validar estudio
        def estudio = new Estudio (params.estudio)
        def gasista = new Gasista (params.gasista)

        gasista?.validate()
        gasista
      }:
      {
          render" No es gasista entonces implementar ${params.toString()}"
      }
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
