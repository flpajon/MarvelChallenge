package ar.com.intermadia.marvelchallenge.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.intermadia.marvelchallenge.core.Result
import ar.com.intermadia.marvelchallenge.data.model.Character
import ar.com.intermadia.marvelchallenge.domain.FetchCharacterListUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class CharacterListViewModel @ViewModelInject constructor(private val useCaseFetchCharacterList: FetchCharacterListUseCase) :
    ViewModel() {

    private var offset: Int = 0

    private var characterList = MutableStateFlow<Result<List<Character>>>(Result.Loading())

    fun getCharacterList(): StateFlow<Result<List<Character>>> = characterList

    fun fetchCharacterList() = viewModelScope.launch {
        kotlin.runCatching {
            useCaseFetchCharacterList.fetchCharacterList(offset)
        }.onSuccess { characterList ->
            offset += characterList.size
            this@CharacterListViewModel.characterList.value = Result.Success(characterList)
        }.onFailure { throwable ->
            characterList.value = Result.Failure(Exception(throwable))
        }
    }

//    val characterList: StateFlow<Result<List<Character>>> = flow {
//        kotlin.runCatching {
//            useCaseFetchCharacterList.fetchCharacterList(0)
//        }.onSuccess { characterList ->
//            emit(Result.Success(characterList))
//        }.onFailure { throwable ->
//            emit(Result.Failure(Exception(throwable)))
//        }
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000),
//        initialValue = Result.Loading()
//    )

}