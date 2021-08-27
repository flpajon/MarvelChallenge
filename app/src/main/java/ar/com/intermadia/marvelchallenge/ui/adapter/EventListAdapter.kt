package ar.com.intermadia.marvelchallenge.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.intermadia.marvelchallenge.core.BaseViewHolder
import ar.com.intermadia.marvelchallenge.data.model.Event
import ar.com.intermadia.marvelchallenge.databinding.EventItemViewBinding
import com.bumptech.glide.Glide
import java.util.*

class EventListAdapter(
    private val eventList: List<Event>,
    private val itemClickListener: OnEventClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnEventClickListener {
        fun onEventClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            EventItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = EventListViewHolder(itemBinding, parent.context)
        return holder
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
            binding.ivExpandColapseArrow.setOnClickListener {
                itemClickListener.onEventClick()
            }
            binding.tvEventName.text = item.name.toUpperCase(Locale.ROOT)
            binding.tvEventDescription.text = item.description
            Glide.with(context).load(item.thumbnail).centerCrop().into(binding.ivEventImage)
        }
    }
}