package comedor

import java.time.LocalDateTime

class Pedido {

    Cliente cliente
    Articulo articulo

    BigDecimal precioTotal

    LocalDateTime momentoCreacion
    LocalDateTime momentoEntrega

    Set<ItemDePedido> items = []

    static hasMany = [
        items: ItemDePedido,
    ]

    static constraints = {
        cliente nullable: false
        precioTotal nullable: false
        momentoCreacion nullable: false
        momentoEntrega nullable: true
    }

    Pedido(Cliente cliente, Articulo articulo, int cantidadDeArticulos, LocalDateTime momentoActual) {
        assert cliente != null
        assert articulo != null
        assert cantidadDeArticulos >= 1
        if (articulo.stock < 0) throw new RuntimeException()
        if (articulo.stock < cantidadDeArticulos) throw new SinStockException()

        this.cliente = cliente
        this.articulo = articulo
        this.cantidadDeArticulos = cantidadDeArticulos
        this.precioTotal = cantidadDeArticulos * articulo.precio
        this.momentoCreacion = momentoActual
        articulo.stock -= cantidadDeArticulos
    }
}
