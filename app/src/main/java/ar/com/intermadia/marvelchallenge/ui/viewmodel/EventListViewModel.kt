package ar.com.intermadia.marvelchallenge.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.intermadia.marvelchallenge.core.Result
import ar.com.intermadia.marvelchallenge.data.model.Event
import ar.com.intermadia.marvelchallenge.domain.FetchEventListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventListViewModel @ViewModelInject constructor(private val useCaseFetchEventList: FetchEventListUseCase) :
    ViewModel() {

    private val eventList = MutableStateFlow<Result<List<Event>>>(Result.Loading())

    fun getEventList(): StateFlow<Result<List<Event>>> = eventList

    fun fetchEventList() = viewModelScope.launch {
        kotlin.runCatching {
            useCaseFetchEventList.fetchEventList()
        }.onSuccess { characterList ->
            this@EventListViewModel.eventList.value = Result.Success(characterList)
        }.onFailure { throwable ->
            eventList.value = Result.Failure(Exception(throwable))
        }
    }
}