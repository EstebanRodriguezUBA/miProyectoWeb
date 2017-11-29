package fiuba.sii7571.miproyecto.cuenta

import fiuba.sii7571.miproyecto.cuenta.CuentaController
import fiuba.sii7571.miproyecto.repository.cuenta.CuentaRepositorio
import fiuba.sii7571.miproyecto.consultorio.Consultor
import fiuba.sii7571.miproyecto.util.texto.Texto
import fiuba.sii7571.miproyecto.factoria.cuenta.CuentaFactoria

import grails.gorm.transactions.Transactional

@Transactional
class CuentaService {
    static scope ='session'

  Cuenta verificarUnicidadCuenta(IniciadorComando cmd) {
    
    Consultor.obtener(CuentaRepositorio.obtenerRepositor())?.buscarCuentaPorNombreAcceso(cmd.nombreAcceso)
  }
  Cuenta verificarExisteCuenta (IniciadorComando cmd){
    /*Nota: en controlador, en comando evaluo correcto DataBinding y aplica validate a las propiedades importando los constrains correspondientes
    Entonces aqui mismo, verifico: si existe la cuenta, retornarla, sino null
    */
    Iniciador iniciador = this.crearIniciadorCuenta(cmd)

    Consultor.obtener(CuentaRepositorio.obtenerRepositor())?.buscarCuentaPorIniciador(iniciador)

  }
  Iniciador crearIniciadorCuenta(IniciadorComando cmd){

    Texto email = Texto.obtener(cmd.nombreAcceso)
    Texto claveSecreta = Texto.obtener(cmd.claveAcceso)
    Iniciador iniciador = CuentaFactoria.crearIniciador(email,claveSecreta)
    iniciador
    }
    def serviceMethod() {

    }
}
