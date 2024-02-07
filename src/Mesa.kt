class Mesa(var numero:Int, var capacidad:Int, var estado:String, var pedidos:MutableList<Pedido>) {

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
}