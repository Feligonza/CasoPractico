package com.felipe.casopractico.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.felipe.casopractico.model.Propiedad

@Dao

interface PropiedadDao {

    @Query("SELECT * FROM PROPIEDAD")
    fun getPropiedad() : LiveData<List<Propiedad>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarPropiedad(propiedad: Propiedad)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun actualizarPropiedad(propiedad: Propiedad)

    @Delete
    suspend fun eliminarPropiedad(propiedad: Propiedad)

}