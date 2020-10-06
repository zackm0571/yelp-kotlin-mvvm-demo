package com.zackmatthews.yelpmvvmkotlin

import androidx.lifecycle.MutableLiveData
import com.yelp.fusion.client.models.Business
import com.zackmatthews.yelpmvvmkotlin.yelp.YelpService

/**
 * This repo provides the timeline items for an activity to render. As of now,
 * this repo exclusively uses the YelpAPI, but future iterations will implement
 * serving up cached items from Room.
 */
class TimelineRepo {
    val yelpService = YelpService()
    val yelpApi = yelpService.createApi()
    var data: MutableLiveData<List<Business>> = MutableLiveData<List<Business>>()

    fun search(): MutableLiveData<List<Business>> {
        data = yelpApi.search() as MutableLiveData<List<Business>>
        return data
    }
}