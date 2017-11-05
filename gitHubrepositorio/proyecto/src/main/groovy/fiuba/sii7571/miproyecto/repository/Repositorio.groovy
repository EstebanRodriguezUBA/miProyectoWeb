package fiuba.sii7571.miproyecto.repository

interface Repositorio{

def obtener(Object id)
def crear()
def actualizar(Object entidad)
def modificar(Object entidad)
def borrar(Object entidad)

}
