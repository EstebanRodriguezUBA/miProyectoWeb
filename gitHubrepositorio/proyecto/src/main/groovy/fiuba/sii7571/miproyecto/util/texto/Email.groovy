package fiuba.sii7571.miproyecto.util.texto


class Email extends Texto {

    static constraints = {
      contenido blank:false, email:true
      // unique:true ,NO SE PUEDE, SALTA EXCEPCION en validate() no se puede procesar porque no la evalua.Funciona con un validator
    }
}
