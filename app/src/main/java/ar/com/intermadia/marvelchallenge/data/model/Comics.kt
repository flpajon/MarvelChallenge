package ar.com.intermadia.marvelchallenge.data.model

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist.ItemDTO
import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist.ItemXDTO

data class Comics(
    val name: String
)

fun ItemDTO.toComics(): Comics = Comics(
    this.name
)

fun List<ItemDTO>.toComicsListFromItemDTO(): List<Comics>{
    val comicsList: MutableList<Comics> = mutableListOf()
    forEach { itemDTO ->
        comicsList.add(itemDTO.toComics())
    }
    return comicsList
}

fun ItemXDTO.toComics(): Comics = Comics(
    this.name
)

@JvmName("toComicsListItemXDTO")
fun List<ItemXDTO>.toComicsListFromItemXDTO(): List<Comics>{
    val comicsList: MutableList<Comics> = mutableListOf()
    forEach { itemxDTO ->
        comicsList.add(itemxDTO.toComics())
    }
    return comicsList
}