package comedor

import grails.gorm.transactions.Transactional
import java.time.LocalDateTime
import java.time.LocalDate

@Transactional
class PedidoService {

    def clienteRepositorio1
    def clienteRepositorio2

    Pedido crearPedido(long clienteId, long articuloId, int cantidad) {
        Cliente cliente = Cliente.get(clienteId)
        Articulo articulo = Articulo.get(articuloId)

        // si acá hay logica de negocio está mal.
        // if (articulo.stock < cantidad) throw new IllegalArgumentException("no hay stock") // esto está MAL acá
        // esta regla de negocio tiene q estar dentro de las entidades

        Pedido p = cliente.crearPedido(articulo, cantidad)
        p.save(failOnError: true)
    }
}
