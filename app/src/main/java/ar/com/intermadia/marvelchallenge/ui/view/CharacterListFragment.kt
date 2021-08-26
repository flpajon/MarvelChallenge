package ar.com.intermadia.marvelchallenge.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import ar.com.intermadia.marvelchallenge.MarvelChallengeApp
import ar.com.intermadia.marvelchallenge.R
import ar.com.intermadia.marvelchallenge.core.Result
import ar.com.intermadia.marvelchallenge.core.hide
import ar.com.intermadia.marvelchallenge.core.show
import ar.com.intermadia.marvelchallenge.databinding.FragmentCharacterListBinding
import ar.com.intermadia.marvelchallenge.ui.adapter.CharacterListAdapter
import ar.com.intermadia.marvelchallenge.ui.viewmodel.CharacterListViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterListFragment : Fragment(R.layout.fragment_character_list) {

    private val TAG: String = "${MarvelChallengeApp.TAG}CharacterListFragment"
    private val viewModel by viewModels<CharacterListViewModel>()

    private lateinit var binding: FragmentCharacterListBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterListBinding.bind(view)

        loadCharacterList()
    }

    private fun loadCharacterList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.characterList.collect { result ->
                    when (result) {
                        is Result.Loading ->{
                            binding.rvCharacterList.hide()
                            binding.pbCharacterList.show()
                        }
                        is Result.Success -> {
                            binding.pbCharacterList.hide()
                            binding.rvCharacterList.adapter = CharacterListAdapter(result.data)
                            binding.rvCharacterList.show()
                        }
                        is Result.Failure -> {
                            binding.pbCharacterList.hide()
                            Toast.makeText(requireContext(),"Ocurrio un problema", Toast.LENGTH_SHORT).show()
                            FirebaseCrashlytics.getInstance().recordException(result.exception)
                            Log.e(TAG, result.exception.toString())
                        }
                    }

                }
            }
        }
    }
}