package ar.com.intermadia.marvelchallenge.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.intermadia.marvelchallenge.core.Result
import ar.com.intermadia.marvelchallenge.data.model.Event
import ar.com.intermadia.marvelchallenge.domain.FetchEventListUseCase
import kotlinx.coroutines.launch

class EventListViewModel @ViewModelInject constructor(private val useCaseFetchEventList: FetchEventListUseCase) :
    ViewModel() {

    private val eventList = MutableLiveData<Result<List<Event>>>(Result.Loading())

    fun getEventList(): LiveData<Result<List<Event>>> = eventList

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