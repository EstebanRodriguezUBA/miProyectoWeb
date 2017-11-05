package fiuba.sii7571.miproyecto.usuario

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonaSpec extends Specification implements DomainUnitTest<Persona> {

    def setup() {

    }

    def cleanup() {
    }

    void "establecer rol"() {
        given:"Dado un rol a determinar"
        Rol rol
        String nombreRol = "Administrador del sistema"
        when:"se asigna un rol"
        rol = Rol.ADMINISTRADOR
        then:"el rol es definido"
        assert rol.nombre == nombreRol
    }
    void "establecer rol a persona"() {
        given:"Dado una persona y un rol a determinar"
        Rol rol
        String nombreRol = "Administrador del sistema"
        Persona persona
        when:"se asigna un rol"
        rol = Rol.ADMINISTRADOR
        persona = new Persona(rol:rol)
        then:"el rol es definido"
        assert persona.rol.nombre == nombreRol
    }
}
