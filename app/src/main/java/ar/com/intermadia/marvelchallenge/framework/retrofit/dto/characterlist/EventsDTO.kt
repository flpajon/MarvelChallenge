package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist

data class EventsDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXDTO>,
    val returned: String
)