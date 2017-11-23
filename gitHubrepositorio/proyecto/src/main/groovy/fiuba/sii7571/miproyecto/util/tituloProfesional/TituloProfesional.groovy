package fiuba.sii7571.miproyecto.util.tituloProfesional
//Nota los enumerados en groovy no se instancian,
//se llaman ej: TituloProfesional.GASISTA
//http://grails.asia/groovy-enum-examples
enum TituloProfesional {
  GASISTA('Instalador Gasista Profesional Matriculado'),
  MONTADOR('Montador de instalaciones de gas'),
  OTRO('Otra Profesion ')

  final String nombre

  TituloProfesional(String nombre) {
    this.nombre = nombre
  }

}
