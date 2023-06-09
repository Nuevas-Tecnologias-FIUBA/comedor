package comedor

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PedidoSpec extends Specification implements DomainUnitTest<Pedido> {

    def setup() {
    }

    def cleanup() {
    }

    // BDD
    void "test probar el pedido de un articulo cuando hay stock"() {
        given: "dado un cliente y un articulo con 50 de stock"
            Cliente cliente = new Cliente("mauro", "ciancio", "DNI", "12345678")
            Articulo articulo = new Articulo("coca cola", 10, 1, 50)

        when: "cuando hace un pedido de 5 cocas"
            cliente.crearPedido(articulo, 5)

        then: "se descuenta el stock solicitado del articulo"
            articulo.stock == 45
    }

    void "test probar el pedido de un articulo cuando lo que pido es mayor al stock"() {
        given: "dado un cliente y un articulo con 50 de stock"
            Cliente cliente = new Cliente("mauro", "ciancio", "DNI", "12345678")
            Articulo articulo = new Articulo("coca cola", 10, 1, 50)

        when: "cuando hace un pedido de 51 cocas"
            cliente.crearPedido(articulo, 51)

        then: "falla xq lo que pedi es mayor al stock del articulo"
            thrown(SinStockException)
    }

    void "test ...."() {
        given: "dado un cliente y un articulo con 50 de stock"
            Cliente cliente = new Cliente("mauro", "ciancio", "DNI", "12345678")
            Articulo articulo = new Articulo("coca cola", 10, 1, 50)

        when: "cuando hace un pedido de 0 cocas"
            cliente.crearPedido(articulo, 0)

        then: "falla xq no se puede hacer un pedido de 0"
            thrown(org.codehaus.groovy.runtime.powerassert.PowerAssertionError)
    }

    void "test si el stock es negativo por alguna razon desconocida la aplicacion pincha"() {
        given: "dado un cliente y un articulo con 50 de stock"
            Cliente cliente = new Cliente("mauro", "ciancio", "DNI", "12345678")
            Articulo articulo = new Articulo("coca cola", 10, 1, 50)
            articulo.stock = -10

        when: "cuando hace un pedido de 1 cocas"
            cliente.crearPedido(articulo, 1)

        then: "falla xq no se puede hacer un pedido de 0"
            thrown(RuntimeException)
    }
}
