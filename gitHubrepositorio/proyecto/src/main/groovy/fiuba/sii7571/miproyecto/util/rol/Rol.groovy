package fiuba.sii7571.miproyecto.util.rol

enum Rol {
  ADMINISTRADOR('Administrador del sistema'),
  USUARIO('Usuario del sistema')

  String nombre

  Rol(String nombre) {
    this.nombre = nombre
  }

}
