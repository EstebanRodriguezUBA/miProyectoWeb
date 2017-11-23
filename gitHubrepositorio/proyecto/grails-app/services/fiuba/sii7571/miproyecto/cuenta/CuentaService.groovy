package fiuba.sii7571.miproyecto.cuenta

import fiuba.sii7571.miproyecto.cuenta.CuentaController
import fiuba.sii7571.miproyecto.repository.cuenta.CuentaRepositorio
import fiuba.sii7571.miproyecto.consultorio.Consultor
import fiuba.sii7571.miproyecto.util.texto.
import grails.gorm.transactions.Transactional

@Transactional
class CuentaService {
    static scope ='session'

*************Cambiar COMANDO
  Comando iniciarSesion (Comando cmd){
    /*Nota: en controlador, en comando evaluo correcto DataBinding y aplica validate a las propiedades importando los constrains correspondientes
    Entonces aqui mismo, verifico: si existe la cuenta, retornarla, sino null
    */
    Consultor consultor = new Consultor()
    consultor.setearRepositor(CuentaRepositorio.obtenerRepositor())

    cmd.instanciaRetornada = consultor?.buscarCuentaUsuario(new Iniciador(new Email (cmd.nombre),new ClaveSecreta(cmd.claveAcceso)))
    if (cmd.Cuenta){
      cmd.mensaje = "Bienvenido: iniciando su sesión..."
    }else{
        cmd.mensaje = "No existe esa cuenta. Verifique lo ingresado."
      }

    cmd
  }


    def serviceMethod() {

    }
}
