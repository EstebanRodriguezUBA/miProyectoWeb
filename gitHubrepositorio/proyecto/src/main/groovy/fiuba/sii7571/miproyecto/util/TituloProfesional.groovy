package fiuba.sii7571.miproyecto.util
//Nota los enumerados en groovy no se instancian,
//se llaman ej: TituloProfesional.GASISTA
//http://grails.asia/groovy-enum-examples
enum TituloProfesional {
  GASISTA('Instalador Gasista Profesional Matriculado'),
  MONTADOR('Montador de instalaciones de gas'),
  OTRO('Profesion no definida')

  String nombre

  TituloProfesional(String nombre) {
    this.nombre = nombre
  }

}
