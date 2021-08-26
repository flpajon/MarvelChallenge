package ar.com.intermadia.marvelchallenge.framework.retrofit.dto

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<CharacterDTO>,
    val total: String
)