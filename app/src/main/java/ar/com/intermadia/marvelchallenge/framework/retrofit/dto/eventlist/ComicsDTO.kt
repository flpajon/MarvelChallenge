package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class ComicsDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXDTO>,
    val returned: String
)