package br.com.digitalhouse.listadegastos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GastosAdapter.OnGastoClickListener {
    var listaGastos = getAllGastos()
    var adapter = GastosAdapter(listaGastos,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGastos.adapter = adapter
        rvGastos.layoutManager = LinearLayoutManager(this)
        rvGastos.setHasFixedSize(false)

    }

    // Retorna uma lista fixa de gastos - podendo fazer o construtor dentro do return
    fun getAllGastos(): ArrayList<Gasto> {
        val gasto1 = Gasto(1, "Uber", 15.0)
        val gasto2 = Gasto(2, "Passagem", 5.0)
        val gasto3 = Gasto(3, "Perdi na Rua", 50.0)
        val gasto4 = Gasto(4, "Alimentação", 20.0)

        return arrayListOf(gasto1, gasto2, gasto3, gasto4)

// faz a mesma coisa que o codigo acima
//      return  arrayListOf(Gasto(1, "Uber", 15.0), Gasto(2, "Passagem", 5.0), Gasto(3, "Perdi na Rua", 50.0,Gasto(4, "Alimentação", 20.0))
    }

    override fun gastoClick(position: Int) {
        // esse gasto é o que foi clicado na lista
        val gasto = listaGastos.get(position)
        gasto.descricao = "Deu Certo"
        adapter.notifyItemChanged(position)
        Toast.makeText(this, gasto.toString(), Toast.LENGTH_SHORT).show()

    }
}