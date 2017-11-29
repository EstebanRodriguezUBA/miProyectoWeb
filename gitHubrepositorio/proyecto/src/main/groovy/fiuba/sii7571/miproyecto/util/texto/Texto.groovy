package fiuba.sii7571.miproyecto.util.texto

import grails.validation.Validateable

class Texto implements Validateable{
  String contenido

    private Texto(){}
    Texto(String contenido){
      this.contenido = contenido
    }
    static Texto obtener(String contenido){
      new Texto(contenido)
    }
    static constraints = {

    }

}
/**
org.springframework.orm.hibernate5.HibernateSystemException: No default constructor for entity:  : fiuba.sii7571.miproyecto.util.texto.Texto; nested exception is org.hibernate.InstantiationException: No default constructor for entity:  : fiuba.sii7571.miproyecto.util.texto.Texto
Solucion:
http://docs.groovy-lang.org/latest/html/api/groovy/transform/TupleConstructor.html
http://mrhaki.blogspot.com.ar/2011/04/groovy-goodness-tuple-constructor.html
The @TupleConstructor annotation instructs the compiler to execute an AST transformation which adds the necessary constructor method to your class.
A tuple constructor is created with a parameter for each property (and optionally field and super properties). A default value is provided (using Java's default values) for all parameters in the constructor. Groovy's normal conventions then allows any number of parameters to be left off the end of the parameter list including all of the parameters - giving a no-arg constructor which can be used with the map-style naming conventions.
*/
