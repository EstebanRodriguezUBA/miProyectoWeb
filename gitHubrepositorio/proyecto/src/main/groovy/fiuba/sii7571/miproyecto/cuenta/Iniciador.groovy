package fiuba.sii7571.miproyecto.cuenta

class Iniciador {
  /**
  *registracion
  */
  //nombre de acceso es un mail vAlido
  String nombre
  //clave distinta mail vAlido
  String claveAcceso
  /*****************/
    static constraints = {
      //que no sean iguales
      nombre blank:false, email:true//, unique:true
      //alfanumErico incluyendo guiOn bajo

      claveAcceso size: 8..25, blank:false, matches:'[A-Za-z0-9_]+'/*, validator: { clave, nombre ->
      //  clave notEqual: nombre
      //retorna cero si son iguales
        clave.compareTo(nombre)

      }
      */

    }
}
