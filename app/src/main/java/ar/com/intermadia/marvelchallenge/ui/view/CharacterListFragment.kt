package ar.com.intermadia.marvelchallenge.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ar.com.intermadia.marvelchallenge.MarvelChallengeApp
import ar.com.intermadia.marvelchallenge.R
import ar.com.intermadia.marvelchallenge.application.AppConstants
import ar.com.intermadia.marvelchallenge.core.Result
import ar.com.intermadia.marvelchallenge.core.hide
import ar.com.intermadia.marvelchallenge.core.show
import ar.com.intermadia.marvelchallenge.data.model.Character
import ar.com.intermadia.marvelchallenge.databinding.FragmentCharacterListBinding
import ar.com.intermadia.marvelchallenge.ui.adapter.CharacterListAdapter
import ar.com.intermadia.marvelchallenge.ui.viewmodel.CharacterListViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterListFragment : Fragment(R.layout.fragment_character_list),
    CharacterListAdapter.OnCharacterClickListener {

    private val TAG: String = "${MarvelChallengeApp.TAG}${this.javaClass.name}"

    @Inject
    lateinit var gson: Gson

    private val viewModel by viewModels<CharacterListViewModel>()

    private lateinit var binding: FragmentCharacterListBinding

    private lateinit var rvAdapter: CharacterListAdapter

    private val characterList = mutableListOf<Character>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterListBinding.bind(view)

        rvAdapter = CharacterListAdapter(characterList, this)
        binding.rvCharacterList.adapter = rvAdapter

        loadCharacterList()
        onScrollEnd()
    }

    private fun onScrollEnd() {
        binding.rvCharacterList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    binding.pbCharacterList.show()
                    viewModel.fetchCharacterList()
                }
            }
        })
    }

    private fun loadCharacterList() {
        viewModel.fetchCharacterList()
        viewModel.getCharacterList().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {
                    binding.rvCharacterList.hide()
                    binding.pbCharacterList.show()
                }
                is Result.Success -> {
                    binding.pbCharacterList.hide()
                    characterList.addAll(result.data)
                    rvAdapter.notifyDataSetChanged()
                    binding.rvCharacterList.show()
                }
                is Result.Failure -> {
                    binding.pbCharacterList.hide()
                    Toast.makeText(
                        requireContext(),
                        "Ocurrio un problema",
                        Toast.LENGTH_SHORT
                    ).show()
                    FirebaseCrashlytics.getInstance().recordException(result.exception)
                    Log.e(TAG, result.exception.toString())
                }
            }

        }


    }

    override fun onCharacterClick(character: Character) {
        val jsonCharacter = getJSONCharacter(character)
        findNavController().navigate(
            R.id.action_characterListFragment_to_characterDetailsFragment,
            bundleOf(AppConstants.CHARACTER_DETAILS to jsonCharacter)
        )
        Log.d(TAG, "onCharacterClick: $character")
    }

    fun getJSONCharacter(character: Character): String {
        return gson.toJson(character)
    }
}