package ar.com.intermadia.marvelchallenge.domain

import ar.com.intermadia.marvelchallenge.data.character.CharacterRepository
import ar.com.intermadia.marvelchallenge.data.model.Character
import javax.inject.Inject

class FetchCharacterListUseCase @Inject constructor(private val repositoryCharacter: CharacterRepository){

    suspend fun fetchCharacterList(): List<Character> = repositoryCharacter.fetchCharacterList()
}