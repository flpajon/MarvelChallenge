package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist

data class ComicsDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemDTO>,
    val returned: String
)