package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class CreatorsDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXDTO>,
    val returned: String
)