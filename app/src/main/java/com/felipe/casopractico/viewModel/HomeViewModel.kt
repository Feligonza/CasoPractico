package com.felipe.casopractico.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.felipe.casopractico.data.PropiedadDatabase
import com.felipe.casopractico.model.Propiedad
import com.felipe.casopractico.repository.PropiedadRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PropiedadRepository
    val obtenerPropiedad: LiveData<List<Propiedad>>

    init {
        val propiedadDao = PropiedadDatabase.getDatabase(application).PropiedadDao()
        repository = PropiedadRepository(propiedadDao)
        obtenerPropiedad = repository.obtenerPropiedad
    }

    fun guardarPropiedad(propiedad: Propiedad){
        viewModelScope.launch { repository.guardarPropiedad(propiedad) }
    }

    fun eliminarPropiedad(propiedad: Propiedad){
        viewModelScope.launch { repository.eliminarPropiedad(propiedad) }
    }

}