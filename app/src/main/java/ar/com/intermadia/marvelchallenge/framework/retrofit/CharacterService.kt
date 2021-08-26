package ar.com.intermadia.marvelchallenge.framework.retrofit

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.CharacterListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {
    @GET("characters")
    fun getCharacters(
        @Query("ts") ts: Int,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<CharacterListResponse>
}