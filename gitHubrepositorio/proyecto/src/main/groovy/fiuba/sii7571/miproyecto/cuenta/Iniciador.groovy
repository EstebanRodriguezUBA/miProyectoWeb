package fiuba.sii7571.miproyecto.cuenta
import grails.validation.Validateable

/**
Applying Validation to Other Classes

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
*/
class Iniciador implements Validateable{
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
      nombre blank:false, email:true, validator:{nombre,esteObjeto->
        /*NOTA:ATENCION!!!
        *
        PARA BUSCAR POR OBJETO EMBEBIDO CON DINAMIC FINDER TIENEN QUE *COINCIDIR TODaAS SUS PROPIEDADES DECLARADAS O FALLA
        Alternativa precisa usar where query
        def consulta=Cuenta.where{ iniciador.nombre == ini.nombre}
        println consulta.dump()
        println consulta.list().dump()
        println consulta.list([max:1]).head().dump()
        */

        //unicidad OK
        boolean encontrado = true
        encontrado = (Cuenta.findByIniciador(esteObjeto/*new Iniciador(nombre:nombre,claveAcceso:esteObjeto.claveAcceso)*/) == null)
        encontrado
      }
      // unique:true ,NO SE PUEDE, SALTA EXCEPCION en validate() no se puede procesar porque no la evalua,probar opcion validator

      //alfanumErico incluyendo guiOn bajo
      claveAcceso size: 8..25, blank:false, matches:'[A-Za-z0-9_]+', validator: { clave, esteObjeto->
      //  clave notEqual: nombre
      //retorna cero si son iguales compareTo() OK
        boolean igualados = true
        igualados  = clave.compareTo(esteObjeto.nombre)? true:false
        igualados
      }


    }
}
