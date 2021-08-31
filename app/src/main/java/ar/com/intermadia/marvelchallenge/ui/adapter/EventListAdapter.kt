package ar.com.intermadia.marvelchallenge.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.intermadia.marvelchallenge.R
import ar.com.intermadia.marvelchallenge.core.BaseViewHolder
import ar.com.intermadia.marvelchallenge.data.model.Event
import ar.com.intermadia.marvelchallenge.databinding.ComicsItemViewBinding
import ar.com.intermadia.marvelchallenge.databinding.EventItemViewBinding
import com.bumptech.glide.Glide

class EventListAdapter(
    private val eventList: List<Event>,
    private val itemClickListener: OnEventClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnEventClickListener {
        fun onEventClick(eventItemViewBinding: EventItemViewBinding)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            EventItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventListViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is EventListAdapter.EventListViewHolder -> holder.bind(eventList[position])
        }
    }

    override fun getItemCount(): Int = eventList.size

    private inner class EventListViewHolder(
        val binding: EventItemViewBinding,
        val context: Context
    ) : BaseViewHolder<Event>(binding.root) {
        override fun bind(item: Event) {
            binding.tvEventName.text = item.name
            binding.tvStartDate.text = item.startDate
            Glide.with(context).load(item.thumbnail).centerCrop().into(binding.ivEventImage)
            val llComicsList = binding.llComicsList
            llComicsList.removeAllViews()
            if (item.comicsList.isNotEmpty()) {
                item.comicsList.forEach { comic ->
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
                tempViewComics.tvComicsName.text = context.getString(R.string.comics_list_empty)
                llComicsList.addView(tempViewComics.root)
            }
            binding.ivExpandColapseArrow.setOnClickListener {
                itemClickListener.onEventClick(binding)
            }
        }
    }
}