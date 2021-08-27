package ar.com.intermadia.marvelchallenge.data.event

import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist.EventsDTO

interface EventDataSource {
    suspend fun getEvents(): List<EventsDTO>
}