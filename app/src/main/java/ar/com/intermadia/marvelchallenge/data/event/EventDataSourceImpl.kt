package ar.com.intermadia.marvelchallenge.data.event

import ar.com.intermadia.marvelchallenge.framework.retrofit.EventService
import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.characterlist.EventsDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventDataSourceImpl @Inject constructor(private val service: EventService): EventDataSource{
    override suspend fun getEvents(): List<EventsDTO> = withContext(Dispatchers.IO){
        listOf<EventsDTO>()
    }
}