package br.com.digitalhouse.listadegastos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GastosAdapter(private val listGastos: ArrayList<Gasto>, val listener: OnGastoClickListener): RecyclerView.Adapter<GastosAdapter.GastoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GastosAdapter.GastoViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gasto, parent, false)
        return GastoViewHolder(itemView)

    }

    //Onde irá acontecer as repetiçoes - podendo trabalhar a logica abaixo
    override fun onBindViewHolder(holder: GastosAdapter.GastoViewHolder, position: Int) {
        var gasto = listGastos.get(position)
        holder.tvDescricao.text = gasto.descricao

    }

    interface OnGastoClickListener{
        fun gastoClick(position: Int)
    }

    override fun getItemCount() = listGastos.size

    // passando inner você podera acessar a classe pai
    inner class GastoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvDescricao: TextView = itemView.findViewById(R.id.tvDescricao)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            // verificar se o recyclerview está vazio
            if(RecyclerView.NO_POSITION != position){
                listener.gastoClick(position)
            }
        }
    }
}