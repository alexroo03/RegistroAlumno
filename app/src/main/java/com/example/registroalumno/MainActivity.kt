package com.example.registroalumno

import android.os.Bundle
import com.example.listacompra.database.Alumno
import com.example.listacompra.database.AlumnosApp
import com.example.registroalumno.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bAnadir.setOnClickListener{
            val nombre = binding.nombre.text.toString()
            val apellidos = binding.apellido.text.toString()
            val curso = binding.curso.text.toString()

            insert(Alumno(nombre = nombre,
                apellidos = apellidos,
                curso = curso))
        }
    }

    fun insert(alumno: Alumno){
        CoroutineScope(Dispatchers.IO).launch{
            AlumnosApp.database.registroDao().insert(alumno)


        }
    }
}