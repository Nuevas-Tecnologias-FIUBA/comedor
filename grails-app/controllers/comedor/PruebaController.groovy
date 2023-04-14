package comedor

import java.time.LocalDateTime
import java.time.LocalDate

class PruebaController {

    def index() {
    }

    def crearCliente() {

        Cliente cliente = new Cliente(
            nombre: params.nombre,
            apellido: params.apellido,
            identificadorTipo: params.identificadorTipo,
            identificadorValor: params.identificadorValor,
            fechaDeNacimiento: LocalDate.now(),
        ).save(failOnError: true)

        render "registrandome ${cliente}"
    }
    
    def listadoClientes() {
        [clientes: Cliente.list()]
    }

    
    def crearPedido(Long idCliente, Long idArticulo) {
        Cliente cliente = Cliente.get(idCliente)
        Articulo articulo = Articulo.get(idArticulo)
        
        Pedido p = new Pedido(cliente, articulo, 10, LocalDateTime.now())
        p.save(failOnError: true)
        render "${p}"
    }
}
