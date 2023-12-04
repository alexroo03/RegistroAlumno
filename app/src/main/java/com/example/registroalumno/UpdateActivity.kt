package com.example.registroalumno

import android.os.Bundle
import com.example.listacompra.database.Alumno
import com.example.listacompra.database.AlumnosApp
import com.example.registroalumno.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : ActivityWithMenus(){
    lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bAAdir.setOnClickListener{
            update(Alumno(
                nombre = binding.nAlumno.text.toString(),
                curso = binding.nCurso.text.toString(),

            ))
        }
    }

    fun update(alumno: Alumno){
        CoroutineScope(Dispatchers.IO).launch {
            val n = alumno.nombre
            val recoveryalumno = AlumnosApp.database.registroDao().getElementoId(n)
            recoveryalumno.curso = binding.nCurso.text.toString()
            AlumnosApp.database.registroDao().update(recoveryalumno)
        }
    }
}