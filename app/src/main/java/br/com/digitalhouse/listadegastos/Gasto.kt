package br.com.digitalhouse.listadegastos

data class Gasto(val id: Int, var descricao: String, var valor: Double){
    override fun toString(): String {
        return "Gasto(id=$id, descricao='$descricao', valor=$valor)"
    }
}