package fiuba.sii7571.miproyecto.cuenta

import grails.gorm.transactions.Transactional
@Transactional
class CuentaService {
    static scope ='session'

    Iniciador validar(params){

      //def iniciador = new Iniciador (params)
      def iniciador = new Iniciador()
      
      iniciador?.validate()
      iniciador


    }


    def serviceMethod() {

    }
}
