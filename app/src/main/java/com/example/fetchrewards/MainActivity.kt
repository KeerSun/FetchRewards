package com.example.fetchrewards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchrewards.databinding.ActivityMainBinding
import com.example.fetchrewards.network.dataModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataAdapter: DataRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addData()
    }

    private fun addData() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val dataList = mutableListOf<dataModel>()
        viewModel.getPosts()
        viewModel.myResponseList.observe(this, {
            for (data in it) {
                if (data.name !== null  && data.name.isNotEmpty()){
                    dataList.add(data)
                }
            }
            val sortedData = dataList.sortedWith(compareBy(dataModel :: listId, dataModel :: name))
            dataAdapter.populate(sortedData)
        })
    }

    private fun initRecyclerView() {
        Log.d("making recycler adapter", recycler_view.toString())
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingItemDecoration(5)
            addItemDecoration(topSpacingDecoration)
            dataAdapter = DataRecyclerAdapter()
            adapter = dataAdapter
        }
    }
}