package com.example.instagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagram.databinding.ItemSearchFeedBinding

class SearchFeedRVAdapter(private val imageSearchList: ArrayList<ImageSearch>):RecyclerView.Adapter<SearchFeedRVAdapter.ImageSearchViewHolder>() {

    // 클릭 인터페이스
    interface MyItemClickListener {
        fun onClickItem(imageSearch: ImageSearch, position: Int)
    }

    // 리스너 객체를 전달받는 함수와 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }

    inner class ImageSearchViewHolder(val binding: ItemSearchFeedBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageSearch: ImageSearch) {
            Glide.with(itemView).load(imageSearch.image_url).into(binding.itemSearchFeedIv)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchFeedRVAdapter.ImageSearchViewHolder {
        val binding = ItemSearchFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchFeedRVAdapter.ImageSearchViewHolder, position: Int) {
        holder.bind(imageSearchList[position])
        holder.binding.itemSearchFeedIv.setOnClickListener {
            mItemClickListener.onClickItem(imageSearchList[position], position)
        }

    }

    override fun getItemCount(): Int {
        return imageSearchList.size
    }


}