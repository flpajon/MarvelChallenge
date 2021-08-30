package ar.com.intermadia.marvelchallenge.data.event

import ar.com.intermadia.marvelchallenge.application.AppConstants
import ar.com.intermadia.marvelchallenge.framework.retrofit.EventService
import ar.com.intermadia.marvelchallenge.framework.retrofit.dto.eventlist.EventDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject

class EventDataSourceImpl @Inject constructor(private val service: EventService) : EventDataSource {
    override suspend fun getEvents(): List<EventDTO> = withContext(Dispatchers.IO) {
        service.getEvents(
            AppConstants.TS,
            AppConstants.API_KEY,
            AppConstants.HASH,
            AppConstants.LIMIT_EVENTS,
            AppConstants.ORDER_BY_EVENT
        ).await().data.results
    }
}