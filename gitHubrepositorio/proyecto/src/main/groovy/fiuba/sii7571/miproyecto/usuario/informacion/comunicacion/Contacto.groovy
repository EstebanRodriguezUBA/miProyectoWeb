package fiuba.sii7571.miproyecto.usuario.informacion.comunicacion

import fiuba.sii7571.miproyecto.usuario.informacion.comunicacion.Telefono
class Contacto {
    Telefono celular
    Telefono residencial
    String otroTelefono
    static embedded = ['celular','residencial']
      static constraint
    static constraints = {
    }
}
