package fiuba.sii7571.miproyecto.repository

class Repositor implements Repositorio{

  def obtener(Object id){
    "IMPLEMENTAR"
}
  def crear(){
    "IMPLEMENTAR"
  }
  def actualizar(Object entidad){
    "IMPLEMENTAR"
  }
  def modificar(Object entidad){
    "IMPLEMENTAR"
  }
  def borrar(Object entidad){
    "IMPLEMENTAR"
  }
  def buscar(Object entidad,String nombrePropiedad_A,String nombrePropiedad_B,byte max){
    entidad.findAllByNombreAndClaveAcceso(nombrePropiedad_A,nombrePropiedad_B,[max:max])
  }
  def buscar(Object entidad,String nombre,byte max){
    entidad.findAllByNombre(nombre,[max:max])
  }
}
