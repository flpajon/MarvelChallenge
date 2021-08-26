package ar.com.intermadia.marvelchallenge.data.character

import ar.com.intermadia.marvelchallenge.application.AppConstants
import ar.com.intermadia.marvelchallenge.framework.retrofit.CharacterService
import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.CharacterDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject

class CharacterDataSourceImpl @Inject constructor(private val service: CharacterService) :
    CharacterDataSource {

    override suspend fun getCharacters(): List<CharacterDTO> = withContext(Dispatchers.IO) {
        service.getCharacters(AppConstants.TS, AppConstants.API_KEY, AppConstants.HASH).await().data.results
    }
}