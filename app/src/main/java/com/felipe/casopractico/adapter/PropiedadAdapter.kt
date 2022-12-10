package com.felipe.casopractico.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipe.casopractico.databinding.PropiedadFilaBinding
import com.felipe.casopractico.model.Propiedad

class PropiedadAdapter: RecyclerView.Adapter<PropiedadAdapter.PropiedadViewHolder>() {

    //lista de propiedades
    private var listaPropiedades = emptyList<Propiedad>()

    fun setPropiedades(propiedades: List<Propiedad>){
        listaPropiedades = propiedades
        notifyDataSetChanged()
    }

    inner class PropiedadViewHolder(private val itemBinding: PropiedadFilaBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun dibujar(propiedad: Propiedad){
            itemBinding.tvNombre.text = propiedad.nombre
            itemBinding.tvPrecio.text = propiedad.precio.toString()
            itemBinding.tvTamano.text = propiedad.tamano
            itemBinding.tvDireccion.text = propiedad.direccion
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropiedadViewHolder {
        val itemBinding = PropiedadFilaBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PropiedadViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PropiedadViewHolder, position: Int) {
        val propiedad = listaPropiedades[position]
        holder.dibujar(propiedad)
    }

    override fun getItemCount(): Int {
        return listaPropiedades.size
    }


}