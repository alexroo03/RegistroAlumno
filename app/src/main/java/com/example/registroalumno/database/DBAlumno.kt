package com.example.listacompra.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Alumno::class), version = 1)
abstract class DBAlumno: RoomDatabase() {
    abstract fun registroDao():AlumnoDao
}