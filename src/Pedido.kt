class Pedido(val platos: MutableList<Plato>, val estado:String = "pendiente") {

    val numero = ++contPedidos
    companion object {
        private var contPedidos = 0
    }

    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    fun eliminarPlato(nombrePlato: String) {
        platos.forEach { if(it.nombre == nombrePlato) platos.remove(it) }
//        val platoEliminar = platos.find { nombrePlato == it.nombre }
//        if (platoEliminar != null) {
//            platos.remove(platoEliminar)
//        }
    }

    fun calcularPrecio() {
        var precioTotal = 0.0
        platos.forEach { precioTotal += it.precio }

    }

    fun calcularTiempo() {
        var tiempoTotal = 0
        platos.forEach { tiempoTotal += it.tiempoPreparacion }
    }

    override fun toString(): String {
        return super.toString()
    }
}