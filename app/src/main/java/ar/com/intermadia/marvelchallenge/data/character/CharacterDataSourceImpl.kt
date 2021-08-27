package ar.com.intermadia.marvelchallenge.data.character

import ar.com.intermadia.marvelchallenge.application.AppConstants
import ar.com.intermadia.marvelchallenge.framework.retrofit.CharacterService
import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist.CharacterDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject

class CharacterDataSourceImpl @Inject constructor(private val service: CharacterService) :
    CharacterDataSource {

    override suspend fun getCharacters(offset: Int): List<CharacterDTO> = withContext(Dispatchers.IO) {
        service.getCharacters(AppConstants.TS, AppConstants.API_KEY, AppConstants.HASH, AppConstants.LIMIT_CHARACTERS, offset).await().data.results
    }
}