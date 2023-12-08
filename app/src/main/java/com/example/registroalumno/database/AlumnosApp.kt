package com.example.resgistroalumno.database

import android.app.Application
import androidx.room.Room

class AlumnosApp: Application() {
    companion object{
        lateinit var database: DBAlumno
    }

    //Construimos la base de datos
    override fun onCreate() {
        super.onCreate()
        AlumnosApp.database = Room.databaseBuilder(this,DBAlumno::class.java,"DBAlumno").build()
    }
}