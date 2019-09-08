package com.example.sentimentofguitarapp.listdetail

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sentimentofguitarapp.R
import com.example.sentimentofguitarapp.listdetail.adpter.ListDetailAdpter
import com.example.sentimentofguitarapp.sentiments.listcomment.ListCommentViewModel
import kotlinx.android.synthetic.main.activity_list_details.*

class ListDetailActivity : AppCompatActivity() {
    private lateinit var adpter: ListDetailAdpter
    lateinit var viewModel: ListCommentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)
        val value: String = intent.extras?.getString("TYPEOFDATA") ?: "0"
        initViewModel(value)
        initRecyclerView()

    }

    private fun initViewModel(value: String) {
        viewModel = ViewModelProviders.of(this).get(ListCommentViewModel::class.java)
        viewModel.obserDataFromDataBase().observe(this, Observer { d ->
            setAdpter(value, d)
        })
    }

    private fun setAdpter(value: String, d: ListDetailModel) {
        if (value == "1") {
            listTextView1.text = "Good comment"
            adpter.setAdpterList(d.goodComment)
        }
        if (value == "0") {
            listTextView1.text = "Fix comment"

            adpter.setAdpterList(d.neutralComment)
        }
        if (value == "-1") {
            listTextView1.text = "Neg comment"

            adpter.setAdpterList(d.negComment)
        }
        adpter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        adpter = ListDetailAdpter()
        recyclerViewListDetail.layoutManager = LinearLayoutManager(this)
        recyclerViewListDetail.adapter = adpter


    }
}