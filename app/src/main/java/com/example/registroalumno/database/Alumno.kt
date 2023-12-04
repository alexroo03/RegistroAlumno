package com.example.listacompra.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alumnos")
data class Alumno(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var nombre:String="",
    var apellidos:String="",
    var curso:String=""
)