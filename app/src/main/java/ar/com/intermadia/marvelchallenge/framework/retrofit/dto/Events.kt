package ar.com.intermadia.marvelchallenge.framework.retrofit.dto

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: String
)