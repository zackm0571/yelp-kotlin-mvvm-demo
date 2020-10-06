package com.zackmatthews.yelpmvvmkotlin.yelp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yelp.fusion.client.connection.YelpFusionApiFactory
import com.yelp.fusion.client.models.Business
import com.yelp.fusion.client.models.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class YelpApi {
    //todo: use android arch components to store this key in a safer way.
    val api =
        YelpFusionApiFactory().createAPI("")

    fun search(): LiveData<List<Business>> {
        val data = MutableLiveData<List<Business>>()
        api.getBusinessSearch(getParams()).enqueue(
            object : Callback<SearchResponse> {
                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
                ) {
                    response.body().let {
                        Timber.d("Search response %s", response.body())
                        data.value = it?.businesses
                    }
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Timber.d("Search failed,  localizedMessage(): %s", t.localizedMessage)
                }
            }
        )
        return data
    }

    //todo: create request builder (see: https://github.com/zackm0571/wandering-local-app/blob/master/app/src/main/java/life/wanderinglocal/YelpApi.java#L35)
    private fun getParams(): Map<String, String> {
        val paramMap = HashMap<String, String>()
        paramMap.put("location", "San Francisco")
        paramMap.put("term", "Coffee")
        return paramMap
    }
}