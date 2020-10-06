package com.zackmatthews.yelpmvvmkotlin

import androidx.lifecycle.ViewModel

class TimelineViewModel : ViewModel() {
    private val repo = TimelineRepo()
    val data = repo.search()
}