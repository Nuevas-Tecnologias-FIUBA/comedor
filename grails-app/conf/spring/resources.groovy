import comedor.repositorio.*

// scope
// singleton
// prototype
// request
// session

beans = {
    clienteRepositorio1(ClienteRepositorio) {
        prefijo = "sr"
    }

    clienteRepositorio2(ClienteRepositorio) {
        prefijo = "sra"
    }

    enviadorMail(EnviadorMail) {
        clienteRepositorio1 = ref('clienteRepositorio1')
        clienteRepositorio2 = ref('clienteRepositorio2')
    }
}
