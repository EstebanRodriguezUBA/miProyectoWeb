package proyecto
import fiuba.sii7571.miproyecto.cuenta.*
import fiuba.sii7571.miproyecto.util.texto.*

class BootStrap {

    def init = { servletContext ->

    Cuenta.count()?:crearCuentasTemporales()
/*
    new Cuenta (nombre:"miproyecto@fiuba.org",claveAcceso:"012345678").save(failOnError: true)
*/
  }
  private crearCuentasTemporales = {
    def iniciador = new Iniciador(new Email("miproyecto@fiuba.org.ar"),new ClaveSecreta("012345678"))
  def primerCuenta = new Cuenta (iniciador:iniciador)

    primerCuenta.save(failOnError: true)

    def segundaCuenta = new Cuenta (iniciador:new Iniciador(new Email("miproyecto@gmail.com"),new ClaveSecreta("01234"))
     segundaCuenta.save(failOnError: true)

    def terceraCuenta = new Cuenta (iniciador:new Iniciador(new Email("miproyecto@fiuba.org"),new ClaveSecreta("01234"))
     terceraCuenta.save(failOnError: true)
  }

    def destroy = {
    }
}
