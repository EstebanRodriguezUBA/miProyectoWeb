package fiuba.sii7571.miproyecto.cuenta

import fiuba.sii7571.miproyecto.util.texto.Texto
import grails.validation.Validateable
//Consultar: Lo que se recupera de la base de datos precisa ser validado?

class Iniciador implements Validateable{
  /**
  *RegistraciOn-acceso a sesiOn de usuario.
  */
  //nombreAcceso es un mail. Unico por usuario.
  Texto nombreAcceso
  //claveAcceso distinta mail de acceso.
  Texto claveAcceso

  static embedded = ['nombreAcceso','claveAcceso']

  static constraints = {

      claveAcceso validator: { clave, esteObjeto->

      //retorna cero si son iguales compareTo() OK
      println "Estoy en validator:${esteObjeto?.toString()}"
      println "----${esteObjeto?.claveAcceso?.contenido} ----- ${esteObjeto?.nombreAcceso?.contenido}"
      println "${esteObjeto?.dump()}"
        boolean igualados = true
        igualados  = clave?.contenido?.compareTo(esteObjeto?.nombreAcceso?.contenido)? true:false
        println "Resultado validator ${igualados}_****"
        igualados
      }
    }
}
/**
*NotaPersonal:NO se puede componer, en el sentido de Grails, embedded, clases con propiedades final. No funciona. No compone.
*/
/**
NotaPersonal: Fuente:Applying Validation to Other Classes

Domain classes and Command Objects support validation by default. Other classes may be made validateable by defining the static constraints property in the class (as described above) and then telling the framework about them. It is important that the application register the validateable classes with the framework. Simply defining the constraints property is not sufficient.
The Validateable Trait

Classes which define the static constraints property and implement the Validateable trait will be validateable.


src/main/groovy/com/mycompany/myapp/User.groovy

package com.mycompany.myapp

import grails.validation.Validateable

class User implements Validateable {
    ...

    static constraints = {
        login size: 5..15, blank: false, unique: true
        password size: 5..15, blank: false
        email email: true, blank: false
        age min: 18
    }
}


Accessing the constraints on a validateable object is slightly different. You can access a command object’s constraints programmatically in another context by accessing the constraintsMap static property of the class. That property is an instance of Map<String, ConstrainedProperty>

In the example above, accessing User.constraintsMap.login.blank would yield false, while User.constraintsMap.login.unique would yield true.
*************
RECORDATORIO:
Inicialmente se propone un tipo de "objeto comando" propio, que encapsula la tarea de capturar parametros.Suponiendo que, el inconviente de object Commands, es repetir los atributos de clase de dominio.
Tras consultar, se reutilizan los object commands, que como dice la fuente, son validables por default. No asi toda clase componente que no esté en el dominio y tiene que implementar una interface para tal fin.
Entonces:
import grails.validation.Validateable
class Iniciador implements Validateable{
Luego de encapsular atributos Validateable.
*************/
