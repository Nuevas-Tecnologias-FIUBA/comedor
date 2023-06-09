package comedor.repositorio

import comedor.Cliente

class ClienteRepositorio {

    String prefijo

    ClienteRepositorio() {
        println("creando")
    }

    List<Cliente> getClientesEspeciales() {
        def nombre = "${prefijo}mauro"
        println("buscando clientes con nombre=${nombre}")
        Cliente.findAllByNombre(nombre)
    }
}