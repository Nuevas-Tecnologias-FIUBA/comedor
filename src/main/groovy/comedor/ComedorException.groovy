package comedor

import groovy.transform.InheritConstructors

@InheritConstructors
class ComedorException extends RuntimeException {
}

@InheritConstructors
class SinStockException extends ComedorException {
}

@InheritConstructors
class ClienteInhabilitadoException extends ComedorException {
}