package ar.com.intermadia.marvelchallenge.framework.retrofit.dto

data class CharacterListResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)