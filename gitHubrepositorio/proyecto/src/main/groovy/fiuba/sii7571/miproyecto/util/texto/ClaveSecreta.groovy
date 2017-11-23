package fiuba.sii7571.miproyecto.util.texto


class ClaveSecreta extends Texto {

    static constraints = {
      //alfanumErico incluyendo guiOn bajo
      contenido size: 4..25, blank:false, matches:'[A-Za-z0-9_]+'
    }
}
