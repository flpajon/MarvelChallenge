package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class DataDTO(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<EventDTO>,
    val total: String
)