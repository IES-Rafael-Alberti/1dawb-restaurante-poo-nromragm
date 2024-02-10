class Mesa(var numero:Int, var capacidad:Int) {

    var estado: String = "libre"
    var pedidos: MutableList<Pedido> = mutableListOf()

    init {
        require(capacidad in 1..6) { "Solo existen mesas de 1 a 6 comensales" }
    }

    fun ocuparMesa() {
        if (estado == "libre") {
            estado = "ocupada"
        }
    }

    fun ocuparReserva() {
        if (estado == "reservada") {
            estado = "ocupada"
        }
    }

    fun liberarMesa() {
        if (estado != "libre") {
            estado = "libre"
        }
    }

    fun agregarPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }

    override fun toString(): String {
        return "Mesa $numero: $estado \n${pedidos.joinToString("\n")}"
    }
}




