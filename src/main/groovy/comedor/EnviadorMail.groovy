package comedor.repositorio

import comedor.Cliente

class EnviadorMail {

    def clienteRepositorio1
    def clienteRepositorio2

    EnviadorMail() {
        println("creando EnviadorMail")
    }

    void enviarMail() {
        [clienteRepositorio1, clienteRepositorio2].collectMany {
            it.getClientesEspeciales()
        }.each { Cliente c ->
            println("mandando mail a ${c.nombre}")
        }
    }
}