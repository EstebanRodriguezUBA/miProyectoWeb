package fiuba.sii7571.miproyecto.usuario.informacion.ubicacion
import fiuba.sii7571.miproyecto.usuario.informacion.ubicacion.localizacion.Direccion
class Localizacion {
    Direccion direccion

    static embedded = ['direccion']
    static constraints = {
    }
}
