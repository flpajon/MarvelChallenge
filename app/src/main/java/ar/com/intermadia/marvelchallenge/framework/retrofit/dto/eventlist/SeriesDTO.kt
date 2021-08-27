package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class SeriesDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXXDTO>,
    val returned: String
)