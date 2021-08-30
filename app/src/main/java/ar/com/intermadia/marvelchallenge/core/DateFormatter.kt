package ar.com.intermadia.marvelchallenge.core

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

object DateFormatter {
    fun dateFormatter(startDate: String?): String {
        var date = "Sin fecha inicio asignada."
        if (startDate != null) {
            val simpleFormat =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val convertedDate = LocalDate.parse(startDate, simpleFormat)
            val month = convertedDate.month.value
            date = "${convertedDate.dayOfMonth} de ${MONTHS[month - 1]} ${convertedDate.year}"
        }
        return date
    }

    var MONTHS = arrayOf(
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    )
}