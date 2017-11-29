package proyecto
import fiuba.sii7571.miproyecto.cuenta.*
import fiuba.sii7571.miproyecto.util.texto.*

class BootStrap {

    def init = { servletContext ->

    Cuenta.count()?:crearCuentasTemporales()

  }
  private crearCuentasTemporales = {
    Texto email = Texto.obtener("miproyecto@fiuba.org.ar")
    Texto claveSecreta = Texto.obtener("012345678")
    def iniciador = new Iniciador(nombreAcceso:email,claveAcceso:claveSecreta)
  def primerCuenta = new Cuenta (iniciador:iniciador)

    primerCuenta.save(failOnError: true)

    def segundaCuenta = new Cuenta (iniciador:new Iniciador(nombreAcceso: Texto.obtener("miproyecto@gmail.com"),claveAcceso:Texto.obtener("01234")))

    segundaCuenta.save(failOnError: true)

    def terceraCuenta = new Cuenta (iniciador:new Iniciador(nombreAcceso: Texto.obtener("miproyecto@fiuba.org"),claveAcceso:Texto.obtener("01234")))

    terceraCuenta.save(failOnError: true)

    println "BOOTSTRAP ____________________"
    Cuenta.list().each {
      println "${it.dump()}"
      println "INICIADOR: ${it.iniciador?.dump()}"
  }
    println "Cuentas: ${Cuenta.count()}"
    println "***************BOOOTSTRAPP"
  }

    def destroy = {
    }
}
