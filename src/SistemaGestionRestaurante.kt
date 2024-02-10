class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
        //TODO desarrollar este método...
        if (mesas[numeroMesa - 1].estado == "ocupada") {
            mesas[numeroMesa - 1].agregarPedido(pedido)
        }
    }

    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        if (numeroPedido == null) {
            mesas[numeroMesa - 1].pedidos[(mesas[numeroMesa - 1].pedidos.size - 1)].estado = "servido"
        } else  {
            mesas[numeroMesa - 1].pedidos[numeroPedido].estado = "servido"
        }
    }

    fun cerrarMesa(numeroMesa: Int) {
        if (mesas[numeroMesa - 1].pedidos.all { it.estado == "servido" }) {
            mesas[numeroMesa - 1].estado = "libre"
        }
    }

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}