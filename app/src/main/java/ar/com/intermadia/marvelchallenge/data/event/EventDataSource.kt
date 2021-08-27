package ar.com.intermadia.marvelchallenge.data.event

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist.EventDTO

interface EventDataSource {
    suspend fun getEvents(): List<EventDTO>
}