package ar.com.intermadia.marvelchallenge.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ar.com.intermadia.marvelchallenge.R
import ar.com.intermadia.marvelchallenge.application.AppConstants
import ar.com.intermadia.marvelchallenge.data.model.Character
import ar.com.intermadia.marvelchallenge.databinding.ComicsItemViewBinding
import ar.com.intermadia.marvelchallenge.databinding.FragmentCharacterDetailsBinding
import com.bumptech.glide.Glide
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    @Inject
    lateinit var gson: Gson

    private lateinit var binding: FragmentCharacterDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCharacterDetailsBinding.bind(view)

        arguments?.let { bundle ->
            val jsonCharacterDetails = bundle.getString(AppConstants.CHARACTER_DETAILS)
            val characterDetails =
                gson.fromJson<Character>(jsonCharacterDetails, Character::class.java)
            loadDetailsOnView(characterDetails)
        }

        closeView()
    }

    private fun closeView() {
        binding.ivCloseView.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun loadDetailsOnView(characterDetails: Character) {
        binding.tvCharacterName.text = characterDetails.name
        binding.tvCharacterDescription.text = characterDetails.description
        Glide.with(requireContext()).load(characterDetails.thumbnail).centerCrop()
            .into(binding.ivCharacterImage)
        val llComicsList = binding.llComicsList
        llComicsList.removeAllViews()
        if (characterDetails.comicsList.isNotEmpty()) {
            characterDetails.comicsList.forEach { comic ->
                val tempViewComics = ComicsItemViewBinding.inflate(
                    LayoutInflater.from(llComicsList.context),
                    llComicsList,
                    false
                )

                tempViewComics.tvComicsName.text = comic.name
                llComicsList.addView(tempViewComics.root)
            }
        } else {
            val tempViewComics = ComicsItemViewBinding.inflate(
                LayoutInflater.from(llComicsList.context),
                llComicsList,
                false
            )
            tempViewComics.tvComicsName.text = requireContext().getString(R.string.comics_list_empty)
            llComicsList.addView(tempViewComics.root)
        }

    }
}