package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist

data class StoriesDTO(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXXDTO>,
    val returned: String
)