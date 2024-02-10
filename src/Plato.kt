class Plato(nombre:String, precio:Double, tiempoPreparacion:Int, val ingredientes:MutableList<String>)  {

    var nombre:String = nombre
        set(value) {
            requiereNombre(value)
            field = value
        }

    var precio:Double = precio
        set(value) {
            requierePrecio(value)
            field = value
        }

    var tiempoPreparacion:Int = tiempoPreparacion
        set(value) {
            requiereTiempoPreparacion(value)
            field = value
        }

    private fun requiereNombre(nombre: String) {
        require(nombre.isNotBlank()) { "El nombre no puede estar vacio" }
    }
    private fun requierePrecio(precio: Double) {
        require(precio > 0) { "El precio no puede ser negativo" }
    }
    private fun requiereTiempoPreparacion(tiempoPreparacion: Int) {
        require(tiempoPreparacion > 1) { "El tiempo de preparacion no puede ser inferior a 1" }
    }


    fun agregarIngrediente(ingrediente: String) {
        require(ingrediente.isNotBlank()) { "El ingrediente no puede estar vacío." }
        ingredientes.add(ingrediente)
    }

    init {
        requiereNombre(nombre)
        requierePrecio(precio)
        requiereTiempoPreparacion(tiempoPreparacion)
        require(ingredientes.isNotEmpty()) { "El ingrediente no puede estar vacío." }
    }


    override fun toString(): String {
        return "$nombre ($tiempoPreparacion min.) -> $precio€ (${ingredientes.joinToString(", ")})"
    }
}