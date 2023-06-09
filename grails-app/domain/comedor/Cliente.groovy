package comedor

import java.time.LocalDate
import java.time.LocalDateTime

class Cliente {

    String nombre
    String apellido

    String identificadorTipo
    String identificadorValor

    LocalDate fechaDeNacimiento

    // medio dudoso tener esta colección acá, puede ser peligroso por tema de performance
    // sirven cuando la cardinalidad no es muy grande.
    // si tengo < 100 objetos, dale que va.
    // si ya tengo > 100 o 1000, se pone dudoso
    Set<Pedido> pedidos = []

    static hasMany = [
        pedidos: Pedido,
    ]

    static constraints = {
        nombre nullable: false, blank: false
        apellido nullable: false, blank: false
        identificadorTipo nullable: false, blank: false
        identificadorValor nullable: false, blank: false
        fechaDeNacimiento nullable: true
    }

    Cliente(String nombre, String apellido, String identificadorTipo, String identificadorValor) {
        // TODO agregar validaciones de que estos 4 parámetros no sean null ni strings vacíos
        this.nombre = nombre
        this.apellido = apellido
        this.identificadorTipo = identificadorTipo
        this.identificadorValor = identificadorValor
    }

    Pedido crearPedido(Articulo articulo, int cantidad) {
        // acá podría validar reglas de negocio que afecten al cliente
        // por ejemplo si hizo mas de 10 pedidos en el ultimo mes, no lo dejo avanzar

        Pedido p = new Pedido(this, articulo, cantidad, LocalDateTime.now())
        pedidos << p
        p
    }
}
