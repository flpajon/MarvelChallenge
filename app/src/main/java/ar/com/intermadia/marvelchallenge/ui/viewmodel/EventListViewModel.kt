package ar.com.intermadia.marvelchallenge.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import ar.com.intermadia.marvelchallenge.domain.FetchEventListUseCase

class EventListViewModel @ViewModelInject constructor(private val useCaseFetchEventList: FetchEventListUseCase): ViewModel() {
}