package ar.com.intermadia.marvelchallenge.data.event

import ar.com.intermadia.marvelchallenge.data.model.Event
import ar.com.intermadia.marvelchallenge.data.model.toEventList
import javax.inject.Inject

class EventRepository @Inject constructor(private val dataSourceEvent: EventDataSource) {
    suspend fun fetchEventList(): List<Event> = dataSourceEvent.getEvents().toEventList()
}