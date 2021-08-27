package ar.com.intermadia.marvelchallenge.domain

import ar.com.intermadia.marvelchallenge.data.event.EventRepository
import ar.com.intermadia.marvelchallenge.data.model.Event
import javax.inject.Inject

class FetchEventListUseCase @Inject constructor(private val repositoryEvent: EventRepository) {
    suspend fun fetchEventList(): List<Event> = repositoryEvent.fetchEventList()
}