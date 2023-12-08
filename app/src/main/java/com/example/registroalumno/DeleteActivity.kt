package com.example.registroalumno

import android.os.Bundle
import com.example.registroalumno.databinding.ActivityDeleteBinding
import com.example.resgistroalumno.database.Alumno
import com.example.resgistroalumno.database.AlumnosApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteActivity : ActivityWithMenus(){
    lateinit var binding: ActivityDeleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityDeleteBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.bDelete.setOnClickListener{
                delete(Alumno(
                    nombre = binding.eNombre.text.toString(),
                    ))
            }
    }


        fun delete(alumno: Alumno){
            CoroutineScope(Dispatchers.IO).launch {
                val n = alumno.nombre
                val recoveryalumno = AlumnosApp.database.registroDao().getElementoId(n)
                AlumnosApp.database.registroDao().delete(recoveryalumno)
            }
        }
    }
