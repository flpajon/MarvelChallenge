package ar.com.intermadia.marvelchallenge.framework.retrofit.dto

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)