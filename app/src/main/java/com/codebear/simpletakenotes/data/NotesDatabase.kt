package com.codebear.simpletakenotes.data

import com.codebear.simpletakenotes.domain.models.NoteModel
import java.util.Calendar
import java.util.Date

class NotesDatabase {

    private fun createDate(year: Int, month: Int, day: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, 0, 0, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    fun getFakeNotes(): List<NoteModel> {
        val notes = listOf(
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            ),
            NoteModel(
                id = 1,
                title = "Lista de compras",
                content = "Comprar leche, pan, huevos y frutas.",
                createdAt = createDate(2026, Calendar.APRIL, 20)
            ),
            NoteModel(
                id = 2,
                title = "Ideas de proyecto",
                content = "Crear una app de notas con sincronización en la nube.",
                createdAt = createDate(2026, Calendar.APRIL, 21)
            ),
            NoteModel(
                id = 3,
                title = "Recordatorio",
                content = "Llamar al médico para agendar cita.",
                createdAt = createDate(2026, Calendar.APRIL, 22)
            ),
            NoteModel(
                id = 4,
                title = "Tareas del día",
                content = "Terminar el informe, enviar correos y revisar pendientes.",
                createdAt = createDate(2026, Calendar.APRIL, 23)
            ),
            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza.",
                createdAt = createDate(2026, Calendar.APRIL, 24)
            )
        )
        return notes
    }
}