package ar.com.intermadia.marvelchallenge.data.model

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist.CharacterDTO


data class Character(
    val name: String,
    val description: String,
    val thumbnail: String,
    val comicsList: List<Comics>
)

fun CharacterDTO.toCharacter(): Character = Character(
    this.name,
    if(this.description.isEmpty()) "Sin descripcion" else this.description,
    this.thumbnail.path + "/standard_fantastic." + this.thumbnail.extension,
    this.comics.items.toComicsListFromItemDTO()
)

fun List<CharacterDTO>.toCharacterList(): List<Character> {
    val characterList: MutableList<Character> = mutableListOf()
    forEach { characterDTO ->
        characterList.add(characterDTO.toCharacter())
    }
    return characterList
}
