package com.felipe.casopractico.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipe.casopractico.R
import com.felipe.casopractico.adapter.PropiedadAdapter
import com.felipe.casopractico.databinding.FragmentHomeBinding
import com.felipe.casopractico.viewModel.HomeViewModel

class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null



  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  private lateinit var homeViewModel: HomeViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    _binding = FragmentHomeBinding.inflate(inflater, container, false)

    binding.btAddPropiedad.setOnClickListener{
        findNavController().navigate(R.id.action_nav_home_to_addPropiedadFragment)
    }

      //Listado de propiedades
      val propiedadAdapter = PropiedadAdapter()
      val reciclador = binding.reciclador
      reciclador.adapter = propiedadAdapter
      reciclador.layoutManager = LinearLayoutManager(requireContext())

      homeViewModel.obtenerPropiedad.observe(viewLifecycleOwner){
          propiedades -> propiedadAdapter.setPropiedades(propiedades)
          //propiedadAdapter.setPropiedad(it)

      }

    return binding.root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}