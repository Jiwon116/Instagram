package com.example.instagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    private val feedList = ArrayList<Feed>()
    private val feedRVAdapter = FeedRVAdapter(feedList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        feedItemInit()
        binding.homeFeedRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.homeFeedRv.adapter = feedRVAdapter

        feedRVAdapter.setMyItemClickListener(object : FeedRVAdapter.MyItemClickListener{

            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)

            override fun onClickItemMore(feed: Feed, position: Int) {
                dialog.setCancelable(true)
                dialog.setCanceledOnTouchOutside(true)
                dialog.setContentView(view)
                dialog.show()

                dialog.findViewById<TextView>(R.id.bottom_sheet_3_tv)?.setOnClickListener {
                    feedRVAdapter.removeItem(position)
                    dialog.dismiss()
                }
            }
        })

        return binding.root
    }

    private fun feedItemInit() {
        feedList.add(Feed(R.drawable.feed_image_1,"beautiful_flower",21, "이것은 feed의 내용입니다", arrayListOf("꽃", "하늘", "노을")))
        feedList.add(Feed(R.drawable.feed_image_2,"polite._.cat", 63, "예의바른 고양이", arrayListOf("고양이", "예의바른", "meme")))
        feedList.add(Feed(R.drawable.feed_image_3,"dogloverrr", 97, "꼬질꼬질 강아지", arrayListOf("꼬질꼬질", "고구마", "강아지", "훔쳐먹기")))
        feedList.add(Feed(R.drawable.feed_image_4,"frenchgoodimage", 55, "french good image", arrayListOf("french", "giverny", "지베르니", "모네의정원")))
        feedList.add(Feed(R.drawable.feed_image_5,"kermitthefrog", 37, "개발자 프사 같이 나옴", arrayListOf("kermit", "커밋", "개구리", "개구리짤")))
        feedList.add(Feed(R.drawable.feed_image_6,"programmer.humor", 10, "탈출하지 못하고 결국 돌이 된 개발자", arrayListOf("개발자", "programmer", "개발자의현실", "도망쳐")))
    }
}