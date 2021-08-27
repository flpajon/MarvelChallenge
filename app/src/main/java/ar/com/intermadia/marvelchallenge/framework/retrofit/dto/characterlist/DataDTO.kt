package ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist

data class DataDTO(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<CharacterDTO>,
    val total: String
)