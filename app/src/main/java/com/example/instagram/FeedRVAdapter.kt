package com.example.instagram

import android.annotation.SuppressLint
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.databinding.ItemFeedBinding

class FeedRVAdapter(private val feedList: ArrayList<Feed>):RecyclerView.Adapter<FeedRVAdapter.FeedViewHolder>() {

    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onClickItemMore(feed: Feed, position: Int)
    }

    // 리스너 객체를 전달받는 함수와 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    fun removeItem(position: Int) {
        feedList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class FeedViewHolder(val binding: ItemFeedBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(feed: Feed) {
            // context?.let { Glide.with(it).load(feed.profileImg).into(binding.itemFeedProfileIv) }
            binding.itemFeedImgIv.setImageResource(feed.feedImg!!)
            binding.itemFeedTopNicknameTv.text = feed.nickname

            if(feed.like != null){
                binding.itemFeedLike2Tv.text = feed.like.toString()
            } else {
                binding.itemFeedLikeTextCl.visibility = View.GONE
            }

            val contents : String

            val nickname : String = feed.nickname
            val content : String = feed.content
            var tags : String = ""

            if(feed.tag!=null){
                for(i in 0 until feed.tag!!.size step (1)){
                    if (i == feed.tag!!.size) tags += "#" + feed.tag!![i]
                    else tags += "#" + feed.tag!![i] + " "
                }
            }

            contents = "<b>$nickname</b> $content <font color='#00315E'>$tags</font>"
            binding.itemFeedBottomContentTv.text = Html.fromHtml(contents)
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
        holder.binding.itemFeedMoreIv.setOnClickListener {
            mItemClickListener.onClickItemMore(feedList[position], position)
        }

    }

    override fun getItemCount(): Int {
        return feedList.size
    }


}