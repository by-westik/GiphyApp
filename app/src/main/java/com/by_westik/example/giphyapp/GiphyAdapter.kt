package com.by_westik.example.giphyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.by_westik.example.giphyapp.data.model.Giphy
import com.by_westik.example.giphyapp.databinding.GiphyItemBinding

class GiphyViewHolger(binding: GiphyItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val imageItemView: ImageView = binding.image

    fun bind(imageUrl: String?) {
        Glide
            .with(itemView.context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageItemView)
    }
}

class GiphyDiffCallback : DiffUtil.ItemCallback<Giphy>() {
    override fun areItemsTheSame(oldItem: Giphy, newItem: Giphy): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Giphy, newItem: Giphy): Boolean {
        return oldItem == newItem
    }

}

class GiphyAdapter : RecyclerView.Adapter<GiphyViewHolger>() {

    val differ = AsyncListDiffer(this, GiphyDiffCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyViewHolger {
        return GiphyViewHolger(
            GiphyItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: GiphyViewHolger, position: Int) {
        val currentGiphy = differ.currentList[position]
        holder.bind(currentGiphy.images.preview_gif.url)

      /*  holder.itemView.setOnClickListener { view ->
            val direction = MainFragmentDirections.actionMainFragmentToGiphyFragment()
            view.findNavController().navigate(direction)
        }
*/
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}