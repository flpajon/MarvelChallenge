package ar.com.intermadia.marvelchallenge.data.character

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.CharacterDTO

interface CharacterDataSource {
    suspend fun getCharacters(offset: Int): List<CharacterDTO>
}