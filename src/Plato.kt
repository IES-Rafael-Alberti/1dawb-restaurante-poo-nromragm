class Plato(nombre:String, precio:Double, tiempoPreparacion:Int, ingredientes:MutableList<String>)  {

    var nombre:String = nombre
        set(value) {
            requiereNombre()
            field = value
        }

    var precio:Double = precio
        set(value) {
            requierePrecio()
            field = value
        }

    var tiempoPreparacion:Int = tiempoPreparacion
        set(value) {
            requiereTiempoPreparacion()
            field = value
        }

    private fun requiereNombre() {
        require(nombre.isNotBlank()) { "El nombre no puede estar vacio" }
    }
    private fun requierePrecio() {
        require(precio > 0) { "El precio no puede ser negativo" }
    }
    private fun requiereTiempoPreparacion() {
        require(tiempoPreparacion > 1) { "El tiempo de preparacion no puede ser inferior a 1" }
    }

    val ingredientes = mutableListOf<String>()

    fun agregarIngrediente(ingrediente: String) {
        require(ingrediente.isNotBlank()) { "El ingrediente no puede ser vacío." }
            ingredientes.add(ingrediente)
    }

    init {
        requiereNombre()
        requierePrecio()
        requiereTiempoPreparacion()
        require(ingredientes.isNotEmpty()) { "" }
    }


    override fun toString(): String {
        return "$nombre ($tiempoPreparacion min.) -> $precio€ (${ingredientes.joinToString(", ")})"
    }
}