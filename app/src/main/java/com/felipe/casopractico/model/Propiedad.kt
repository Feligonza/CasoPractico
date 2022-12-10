package com.felipe.casopractico.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "propiedad")

data class Propiedad(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "correo")
    val precio: Long?,
    @ColumnInfo(name = "telefono")
    val tamano: String?,
    @ColumnInfo(name = "web")
    val direccion: String?

) : Parcelable



