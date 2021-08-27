package ar.com.intermadia.marvelchallenge.framework.retrofit

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist.CharacterListResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EventService {
    @GET("events")
    fun getEvents(
        @Query("ts") ts: Int,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
    ): Call<CharacterListResponseDTO>
}