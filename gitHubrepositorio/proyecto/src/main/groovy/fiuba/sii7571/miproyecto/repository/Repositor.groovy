package fiuba.sii7571.miproyecto.repository

import fiuba.sii7571.miproyecto.factoria.Creable

class Repositor implements Repositorio,Creable{


  
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
  def buscar(def entidad,String nombrePropiedad_A,String nombrePropiedad_B,byte max){
  // aqui aplicar un metodo mas general como consultas  where entidad.findAllByNombreAndClaveAcceso(nombrePropiedad_A,nombrePropiedad_B,[max:max])
  }
  def buscar(def entidad,String nombre,byte max){
    entidad.findAllByNombre(nombre,[max:max])
  }
}
