package ar.com.intermadia.marvelchallenge.data.event

import javax.inject.Inject

class EventRepository @Inject constructor(private val dataSourceEvent: EventDataSource) {
}