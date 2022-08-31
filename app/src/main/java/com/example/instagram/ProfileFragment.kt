package com.example.instagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.instagram.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    private var nickname: String = ""
    private var name: String = ""
    private var profileImg: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        nickname = getUserNickname(requireContext())
        name = getUserName(requireContext())
        profileImg = getUserProfileImg(requireContext())

        binding.profileNicknameTv.text = nickname
        binding.profileNameTv.text = name
        context?.let { Glide.with(it).load(profileImg).into(binding.profileCircleImgIv) }

        return binding.root
    }
}