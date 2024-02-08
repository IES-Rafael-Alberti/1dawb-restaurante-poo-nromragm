class Pedido {
    val platos: MutableList<Plato> = mutableListOf()
    var estado:String = "pendiente"
    val numero = ++contPedidos
    companion object {
        private var contPedidos = 0
    }

    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    fun eliminarPlato(nombrePlato: String) {
        platos.forEach { if(it.nombre == nombrePlato) platos.remove(it) }
    }

    fun calcularPrecio(): Double {
        var precioTotal = 0.0
        platos.forEach { precioTotal += it.precio }
        return precioTotal
    }

    fun calcularTiempo(): Int {
        var tiempoTotal = 0
        platos.forEach { tiempoTotal += it.tiempoPreparacion }
        return tiempoTotal
    }

    override fun toString(): String {
        return "${platos.joinToString("\n")}\nEstado: $estado"
    }
}