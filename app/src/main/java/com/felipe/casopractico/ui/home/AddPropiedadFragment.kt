package com.felipe.casopractico.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.felipe.casopractico.R
import com.felipe.casopractico.databinding.FragmentAddPropiedadBinding
import com.felipe.casopractico.model.Propiedad
import com.felipe.casopractico.viewModel.HomeViewModel


class AddPropiedadFragment : Fragment() {

    private var _binding: FragmentAddPropiedadBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentAddPropiedadBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener{ agregarPropiedad() }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun agregarPropiedad(){
        val nombre = binding.etNombre.text.toString()
        val precioAux = binding.etPrecio.text.toString()
        val precio = java.lang.Long.valueOf(precioAux)
        val tamano = binding.etTamano.text.toString()
        val direccion = binding.etDireccion.text.toString()

        if(nombre.isNotEmpty()){
            val propiedad = Propiedad(0,nombre,precio,tamano,direccion)
            homeViewModel.guardarPropiedad(propiedad)
            Toast.makeText(requireContext(), "Lugar agregado", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addPropiedadFragment_to_nav_home)

        }
        else{
            Toast.makeText(requireContext(), "Faltan Valores", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}