package fiuba.sii7571.miproyecto.usuario.informacion.comunicacion

class Contacto {
    Telefono celular
    Telefono fijo
    String otroTelefono
    static embedded = ['celular','fijo']
    static constraints = {
    }
}
