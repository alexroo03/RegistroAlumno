package com.example.resgistroalumno.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AlumnoDao {
    @Insert
    fun insert(alumno:Alumno)

    @Update
    fun delete(alumno:Alumno)

    @Delete
    fun update(alumno: Alumno)

    @Query("SELECT * FROM Alumnos WHERE nombre like :nombre")
    fun getElementoId(nombre: String): Alumno
}