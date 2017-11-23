package fiuba.sii7571.miproyecto.factoria

/**
Abstract classes are commonly compared to interfaces. But there are at least two important differences of choosing one or another. First, while abstract classes may contain fields/properties and concrete methods, interfaces may contain only abstract methods (method signatures). Moreover, one class can implement several interfaces, whereas it can extend just one class, abstract or not.*/
abstract class Factoria {

    abstract def crear()
    //abstract def configurar()
