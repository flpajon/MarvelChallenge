package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class EventListResponseDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val `data`: DataDTO,
    val etag: String,
    val status: String
)