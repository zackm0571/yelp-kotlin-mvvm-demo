package com.zackmatthews.yelpmvvmkotlin

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yelp.fusion.client.models.Business
import com.zackmatthews.yelpmvvmkotlin.databinding.TimelineItemBinding

class TimelineRecyclerViewAdapter :
    RecyclerView.Adapter<TimelineRecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: TimelineItemBinding) : RecyclerView.ViewHolder(binding.root)

    var data = ArrayList<Business>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(TimelineItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val business = data[position]
        val text = "${business.name} \n  ${business.text}"
        holder.binding.tvDetails.text = text
        Glide.with(holder.itemView.context).load(business.imageUrl).into(holder.binding.iv)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}