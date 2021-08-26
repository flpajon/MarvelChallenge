package ar.com.intermadia.marvelchallenge.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.intermadia.marvelchallenge.MarvelChallengeApp
import ar.com.intermadia.marvelchallenge.core.BaseViewHolder
import ar.com.intermadia.marvelchallenge.data.model.Character
import ar.com.intermadia.marvelchallenge.databinding.CharacterViewBinding
import com.bumptech.glide.Glide
import java.util.*

class CharacterListAdapter(private val characterList: List<Character>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            CharacterViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterListViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CharacterListViewHolder -> holder.bind(characterList[position])
        }
    }

    override fun getItemCount(): Int = characterList.size

    private inner class CharacterListViewHolder(
        val binding: CharacterViewBinding,
        val context: Context
    ) : BaseViewHolder<Character>(binding.root) {
        override fun bind(item: Character) {
            binding.tvCharacterName.text = item.name.toUpperCase(Locale.ROOT)
            binding.tvCharacterDescription.text = item.description
            Glide.with(context).load(item.thumbnail).centerCrop().into(binding.ivCharacterImage)
            binding.cvCharacter.setOnClickListener {
                Log.d(MarvelChallengeApp.TAG, "onClick: $item")
            }
        }
    }
}