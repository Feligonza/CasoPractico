package com.felipe.casopractico.repository

import androidx.lifecycle.LiveData
import com.felipe.casopractico.data.PropiedadDao
import com.felipe.casopractico.model.Propiedad

class PropiedadRepository(private val propiedadDao: PropiedadDao) {

    suspend fun guardarPropiedad(propiedad : Propiedad){
        if(propiedad.id == 0){
            propiedadDao.agregarPropiedad(propiedad)
        }
        else{
            propiedadDao.actualizarPropiedad(propiedad)
        }
    }

    suspend fun eliminarPropiedad(propiedad : Propiedad){
        propiedadDao.eliminarPropiedad(propiedad)
    }

    val obtenerPropiedad: LiveData<List<Propiedad>> = propiedadDao.getPropiedad()

}