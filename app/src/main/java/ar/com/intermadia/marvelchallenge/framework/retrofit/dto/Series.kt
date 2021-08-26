package ar.com.intermadia.marvelchallenge.framework.retrofit.dto

data class Series(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: String
)