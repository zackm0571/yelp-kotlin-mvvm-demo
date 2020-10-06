package com.zackmatthews.yelpmvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yelp.fusion.client.models.Business
import com.zackmatthews.yelpmvvmkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TimelineViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()
    }

    private fun init() {
        val layoutManager = GridLayoutManager(this, 2)  //todo couple spanCount with orientation {portrait : 1, landscape : 2}
        val rvAdapter = TimelineRecyclerViewAdapter()
        binding.recyclverView.layoutManager = layoutManager
        binding.recyclverView.adapter = rvAdapter
        viewModel = ViewModelProvider(viewModelStore, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(TimelineViewModel::class.java)
        viewModel.data.observe(this, {
            rvAdapter.data = it as ArrayList<Business>
            rvAdapter.notifyDataSetChanged()
        })
    }
}