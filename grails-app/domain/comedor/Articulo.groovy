package comedor

class Articulo {

    String nombre
    BigDecimal precio
    int codigo
    int stock

    Set<Pedido> pedidos = []

    static hasMany = [
        pedidos: Pedido,
    ]

    static constraints = {
        nombre nullable: false
        precio nullable: false, min: 0.0
    }

    Articulo(String nombre, BigDecimal precio, int codigo, int stock) {
        // TODO validar que no sean null
        assert precio > 0
        assert stock >= 0
        this.nombre = nombre
        this.precio = precio
        this.codigo = codigo
        this.stock = stock
    }
}
