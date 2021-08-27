package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class StoriesDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXXXDTO>,
    val returned: String
)