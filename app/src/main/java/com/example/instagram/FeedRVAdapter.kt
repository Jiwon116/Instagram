package com.example.instagram

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagram.databinding.ItemFeedBinding

class FeedRVAdapter(var context: Context?, private val feedList: List<Feed>):RecyclerView.Adapter<FeedRVAdapter.FeedViewHolder>() {
    inner class FeedViewHolder(private val binding: ItemFeedBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(feed: Feed) {
            context?.let { Glide.with(it).load(feed.profileImg).into(binding.itemFeedProfileIv) }
            binding.itemFeedTopNicknameTv.text = feed.nickname
            binding.itemFeedBottomNicknameTv.text = feed.nickname
            if(feed.like!=null){
                binding.itemFeedLike2Tv.text = feed.like.toString()
            } else {
                binding.itemFeedLikeTextCl.visibility = View.GONE
            }
            binding.itemFeedContentTv.text = feed.content
            if(feed.tag!=null){
                binding.itemFeedTagTv.text = "#" + feed.tag
            } else {
                binding.itemFeedTagTv.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeedRVAdapter.FeedViewHolder {
        val binding = ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedRVAdapter.FeedViewHolder, position: Int) {
        holder.bind(feedList[position])
    }

    override fun getItemCount(): Int {
        return feedList.size
    }


}