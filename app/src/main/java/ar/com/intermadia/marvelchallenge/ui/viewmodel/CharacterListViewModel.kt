package ar.com.intermadia.marvelchallenge.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.intermadia.marvelchallenge.core.Result
import ar.com.intermadia.marvelchallenge.domain.FetchCharacterListUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn


class CharacterListViewModel @ViewModelInject constructor(private val useCaseFetchCharacterList: FetchCharacterListUseCase) :
    ViewModel() {

    val characterList = flow {
        kotlin.runCatching {
            useCaseFetchCharacterList.fetchCharacterList()
        }.onSuccess { characterList ->
            emit(Result.Success(characterList))
        }.onFailure { throwable ->
            emit(Result.Failure(Exception(throwable)))
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = Result.Loading()
    )

}