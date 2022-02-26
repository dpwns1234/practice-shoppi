package com.shoppi.app.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.shoppi.app.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleText = view.findViewById<TextView>(R.id.title_text)
        val titleIcon = view.findViewById<ImageView>(R.id.title_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)


        viewModel.
        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")
        Log.d("homeData", homeJsonString ?:"")

        if(!homeJsonString.isNullOrEmpty()){
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)


            viewModel.title.observe(viewLifecycleOwner) { title ->
                titleText.text = title.text
                GlideApp.with(this)
                    .load(title.iconUrl)
                    .into(titleIcon)
            }
            
            viewpager.adapter = HomeBannerAdapter().apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }

            }
        }

        val status: Int? = null
        fun checkNullLet() {
            status?.let {
                println("score = ${it}")
            }
            val str = status?.let { status.toString() }
        }
    }



}