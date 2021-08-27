package ar.com.intermadia.marvelchallenge.data.model

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist.ItemDTO

data class Comics(
    val name: String
)

fun ItemDTO.toComics(): Comics = Comics(
    this.name
)

fun List<ItemDTO>.toComicsList(): List<Comics>{
    val comicsList: MutableList<Comics> = mutableListOf()
    forEach { itemDTO ->
        comicsList.add(itemDTO.toComics())
    }
    return comicsList
}