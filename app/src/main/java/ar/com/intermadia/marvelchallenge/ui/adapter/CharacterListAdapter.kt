package ar.com.intermadia.marvelchallenge.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.intermadia.marvelchallenge.core.BaseViewHolder
import ar.com.intermadia.marvelchallenge.data.model.Character
import ar.com.intermadia.marvelchallenge.databinding.CharacterItemViewBinding
import com.bumptech.glide.Glide
import java.util.*

class CharacterListAdapter(private val characterList: List<Character>, private val itemClickListener: OnCharacterClickListener) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCharacterClickListener{
        fun onCharacterClick(character: Character)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            CharacterItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = CharacterListViewHolder(itemBinding, parent.context)
        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onCharacterClick(characterList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CharacterListViewHolder -> holder.bind(characterList[position])
        }
    }

    override fun getItemCount(): Int = characterList.size

    private inner class CharacterListViewHolder(
        val binding: CharacterItemViewBinding,
        val context: Context
    ) : BaseViewHolder<Character>(binding.root) {
        override fun bind(item: Character) {
            binding.tvCharacterName.text = item.name.toUpperCase(Locale.ROOT)
            binding.tvCharacterDescription.text = item.description
            Glide.with(context).load(item.thumbnail).centerCrop().into(binding.ivCharacterImage)
        }
    }
}