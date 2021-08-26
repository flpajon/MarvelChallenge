package ar.com.intermadia.marvelchallenge.data.model

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.CharacterDTO


data class Character(
    val name: String,
    val description: String,
    val thumbnail: String
)

fun CharacterDTO.toCharacter(): Character = Character(
    this.name,
    this.description,
    this.thumbnail.path + "/standard_large." + this.thumbnail.extension
)

fun List<CharacterDTO>.toListCharacter(): List<Character> {
    val characterList: MutableList<Character> = mutableListOf()
    forEach { characterDTO ->
        characterList.add(characterDTO.toCharacter())
    }
    return characterList
}
