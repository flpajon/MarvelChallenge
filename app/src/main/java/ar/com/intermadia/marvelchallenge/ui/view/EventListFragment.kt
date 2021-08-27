package ar.com.intermadia.marvelchallenge.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ar.com.intermadia.marvelchallenge.MarvelChallengeApp
import ar.com.intermadia.marvelchallenge.R
import ar.com.intermadia.marvelchallenge.databinding.FragmentEventsListBinding
import ar.com.intermadia.marvelchallenge.ui.viewmodel.EventListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventListFragment : Fragment(R.layout.fragment_events_list) {

    private val TAG: String = "${MarvelChallengeApp.TAG}${this.javaClass.name}"

    private val viewModel by viewModels<EventListViewModel>()

    private lateinit var binding: FragmentEventsListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventsListBinding.bind(view)


    }
}