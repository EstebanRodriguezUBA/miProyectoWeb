package proyecto
import fiuba.sii7571.miproyecto.cuenta.*
class BootStrap {

    def init = { servletContext ->

    Cuenta.count()?:crearCuentasTemporales()
/*
    new Cuenta (nombre:"miproyecto@fiuba.org",claveAcceso:"012345678").save(failOnError: true)
*/
  }
  private crearCuentasTemporales = {
    def iniciador = new Iniciador(nombre:"miproyecto@fiuba.org",claveAcceso:"012345678")
  def primerCuenta = new Cuenta (iniciador:iniciador)

    primerCuenta.save(failOnError: true)

  }

    def destroy = {
    }
}
