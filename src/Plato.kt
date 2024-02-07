class Plato(nombre:String, precio:Double, tiempoPreparacion:Int, ingredientes:MutableList<String>)  {

    var nombre:String = nombre
        set(value) {
            requiereNombre()
            field = value  //value.ifBlank() { throw IllegalArgumentException("El nombre no puede estar vacio") }
        }

    var precio:Double = precio
        set(value) {
            requierePrecio()
            field = value  //if (value > 0) value else throw IllegalArgumentException("El precio no puede ser negativo")
        }

    var tiempoPreparacion:Int = tiempoPreparacion
        set(value) {
            requiereTiempoPreparacion()
            field = value  //if (value >= 1) value else throw IllegalArgumentException("")
        }

    private fun requiereNombre() {
        TODO("Not yet implemented")
    }
    private fun requierePrecio() {
        TODO("Not yet implemented")
    }
    private fun requiereTiempoPreparacion() {
        TODO("Not yet implemented")
    }

    val ingredientes = mutableListOf<String>()

    fun agregarIngrediente(ingrediente: String) {
        if (ingrediente.isNotBlank()) {
            ingredientes.add(ingrediente)
        }
        else throw IllegalArgumentException("El ingrediente no puede estar vacio")
    }

    init {
        requiereNombre()
        requierePrecio()
        requiereTiempoPreparacion()

    }


    override fun toString(): String {
        return "$nombre ($tiempoPreparacion min.) -> $precio€ (${ingredientes.joinToString { ", " }})"
    }
}