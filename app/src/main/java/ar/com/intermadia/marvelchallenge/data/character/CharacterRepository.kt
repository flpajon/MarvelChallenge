package ar.com.intermadia.marvelchallenge.data.character

import ar.com.intermadia.marvelchallenge.data.model.Character
import ar.com.intermadia.marvelchallenge.data.model.toCharacterList
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val dataSourceCharacter: CharacterDataSource){

    suspend fun fetchCharacterList(offset: Int): List<Character> = dataSourceCharacter.getCharacters(offset).toCharacterList()
}