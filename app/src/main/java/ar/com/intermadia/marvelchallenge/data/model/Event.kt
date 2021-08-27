package ar.com.intermadia.marvelchallenge.data.model

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist.EventDTO

data class Event(
    val name: String,
    val description: String,
    val thumbnail: String,
    val comicsList: List<Comics>
)

fun EventDTO.toEvent(): Event = Event(
    this.title,
    this.description,
    this.thumbnail.path + "/standard_large." + this.thumbnail.extension,
    this.comics.items.toComicsListFromItemXDTO()
)

fun List<EventDTO>.toEventList(): List<Event> {
    val eventList = mutableListOf<Event>()
    forEach { eventDTO ->
        eventList.add(eventDTO.toEvent())
    }
    return eventList
}