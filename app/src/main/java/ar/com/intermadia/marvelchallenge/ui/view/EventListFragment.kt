package ar.com.intermadia.marvelchallenge.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ar.com.intermadia.marvelchallenge.MarvelChallengeApp
import ar.com.intermadia.marvelchallenge.R
import ar.com.intermadia.marvelchallenge.core.Result
import ar.com.intermadia.marvelchallenge.core.hide
import ar.com.intermadia.marvelchallenge.core.show
import ar.com.intermadia.marvelchallenge.data.model.Event
import ar.com.intermadia.marvelchallenge.databinding.EventItemViewBinding
import ar.com.intermadia.marvelchallenge.databinding.FragmentEventsListBinding
import ar.com.intermadia.marvelchallenge.ui.adapter.EventListAdapter
import ar.com.intermadia.marvelchallenge.ui.viewmodel.EventListViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventListFragment : Fragment(R.layout.fragment_events_list),
    EventListAdapter.OnEventClickListener {

    private val TAG: String = "${MarvelChallengeApp.TAG}${this.javaClass.name}"

    private val viewModel by viewModels<EventListViewModel>()

    private lateinit var binding: FragmentEventsListBinding

    private lateinit var rvAdapter: EventListAdapter

    private val eventList = mutableListOf<Event>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventsListBinding.bind(view)

        rvAdapter = EventListAdapter(eventList, this)
        binding.rvEventList.adapter = rvAdapter

        loadEventList()
    }

    private fun loadEventList() {
        viewModel.fetchEventList()
        viewModel.getEventList().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {
                    binding.rvEventList.hide()
                    binding.pbEventList.show()
                }
                is Result.Success -> {
                    binding.pbEventList.hide()
                    eventList.clear()
                    eventList.addAll(result.data)
                    rvAdapter.notifyDataSetChanged()
                    binding.rvEventList.show()
                }
                is Result.Failure -> {
                    binding.pbEventList.hide()
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

    override fun onEventClick(eventItemViewBinding: EventItemViewBinding) {
        if (eventItemViewBinding.llComicsList.visibility == View.GONE) {
            eventItemViewBinding.ivExpandColapseArrow.setImageDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_collapse_arrow
                )
            )
            eventItemViewBinding.llComicsList.show()
            eventItemViewBinding.tvComicsToDiscuss.show()
        } else {
            eventItemViewBinding.ivExpandColapseArrow.setImageDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_expand_arrow
                )
            )
            eventItemViewBinding.llComicsList.hide()
            eventItemViewBinding.tvComicsToDiscuss.hide()
        }
    }
}