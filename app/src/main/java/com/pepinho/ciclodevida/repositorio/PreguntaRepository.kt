package com.pepinho.ciclodevida.repositorio

import com.pepinho.pmdm.cuestionarios.model.Opcion
import com.pepinho.pmdm.cuestionarios.model.Pregunta
import com.pepinho.pmdm.cuestionarios.model.PreguntaTest
import com.pepinho.pmdm.cuestionarios.model.PreguntaVerdaderoFalso
import java.util.Collections

/**
 * Clase que simula un repositorio de preguntas
 * La clase es un objeto singleton que contiene una lista mutable de preguntas.
 */
object PreguntaRepository {

    // Podría iniciarse en bloque init.

    private val preguntas: MutableList<Pregunta> = mutableListOf<Pregunta>()

    init {
        preguntas.add(PreguntaTest("Marca la respuesta correcta sobre la sintaxis de Kotlin", 1).apply {
            addOpcion(Opcion("Kotlin es un lenguaje de programación desarrollado por Google", false))
            addOpcion(Opcion("Las colecciones mutables en Kotlin son List, Set y Map", false))
            addOpcion(Opcion("La palabra reservada apply se utiliza para aplicar una función a un objeto", true))
            addOpcion(Opcion("El operador Elvis ?: se utiliza para operaciones aritméticas", false))
            puntos = 3.0
        })
        preguntas.add(PreguntaVerdaderoFalso("Los astronautas del Apolo 11 llegaron a la Luna en 1967", 2).apply {
            puntos = 1.0
            correcta = false
        })
        preguntas.add(PreguntaTest("¿Cuál de las siguientes afirmaciones sobre Kotlin es correcta?", 3).apply {
            addOpcion(Opcion("Kotlin es un lenguaje de programación desarrollado por Google", false))
            addOpcion(Opcion("Kotlin es un lenguaje de programación que se ejecuta sobre la JVM", true))
            addOpcion(Opcion("Kotlin es un lenguaje de programación que se ejecuta sobre la Máquina Virtual de Dart", false))
            addOpcion(Opcion("Kotlin es un lenguaje de programación que se ejecuta sobre la Máquina Virtual de JavaScript", false))
            puntos = 2.0
        })
        preguntas.add(PreguntaTest("¿Cuál es el libro más vendido de la historia?", 4).apply {
            addOpcion(Opcion("El Señor de los Anillos", false))
            addOpcion(Opcion("Don Quijote de la Mancha", true))
            addOpcion(Opcion("Historia de dos ciudades", false))
            addOpcion(Opcion("El Principito", false))
            puntos = 2.0
        })
        preguntas.add(PreguntaVerdaderoFalso("¿Es Kotlin el lenguaje de programación más usado en 2023?", 5).apply {
            puntos = 1.0
            correcta = false
        })
    }


    val size: Int
        get() = preguntas.size

    fun isEmpty() = preguntas.isEmpty()

    fun isNotEmpty() = preguntas.isNotEmpty()

    fun shuffle() = Collections.shuffle(preguntas)

    // Create
//    fun save(pregunta: Pregunta): Boolean = preguntas.add(pregunta)
    fun addPregunta(pregunta: Pregunta) = preguntas.add(pregunta)


    // Read
    fun getPreguntas() = preguntas.toList()
    fun getPreguntaByIndex(index: Int) = preguntas.getOrNull(index)
    fun isLastQuestionIndex(numero: Int) = preguntas.size - 1 == numero
    fun isFirstQuestionIndex(numero: Int) = numero == 0
    fun getPregunta(numero: Int) = preguntas.find { it.numero == numero }
    fun getPregunta(enunciado: String) = preguntas.find { it.enunciado == enunciado }

    // Update
    fun setPregunta(pregunta: Pregunta): Boolean {
        val index = preguntas.indexOfFirst { it.numero == pregunta.numero }
        return if (index != -1) {
            preguntas[index] = pregunta
            true
        } else {
            false
        }
    }

    fun setPreguntas(preguntas: List<Pregunta>) {
        this.preguntas.apply {
            clear()
            addAll(preguntas)
        }
    }

    // Delete
    fun delete(pregunta: Pregunta) = preguntas.remove(pregunta)
    fun delete(numero: Int) = preguntas.removeIf { it.numero == numero }
    fun deletePreguntas() = preguntas.clear()

}