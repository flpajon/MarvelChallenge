package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist

data class CharactersDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemDTO>,
    val returned: String
)