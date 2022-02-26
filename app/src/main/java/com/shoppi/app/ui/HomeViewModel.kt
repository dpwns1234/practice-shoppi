package com.shoppi.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoppi.app.Banner
import com.shoppi.app.Title

class HomeViewModel : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    fun loadHomeData() {
        // TODO 아니, 여기서 데이터를 가져와야하는데
        //  저기 위에 Mutable() 메서드로 불러오는거 아님???
    }


}
