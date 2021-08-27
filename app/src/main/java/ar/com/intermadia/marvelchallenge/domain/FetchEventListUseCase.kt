package ar.com.intermadia.marvelchallenge.domain

import ar.com.intermadia.marvelchallenge.data.event.EventRepository
import javax.inject.Inject

class FetchEventListUseCase @Inject constructor(private val repositoryEvent: EventRepository) {
}