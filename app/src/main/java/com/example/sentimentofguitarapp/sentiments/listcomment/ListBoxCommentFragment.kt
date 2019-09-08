package com.example.sentimentofguitarapp.sentiments.listcomment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sentimentofguitarapp.R
import com.example.sentimentofguitarapp.listdetail.ListDetailActivity
import com.example.sentimentofguitarapp.sentiments.SentimentViewModel
import com.example.sentimentofguitarapp.sentiments.SentimentsActivity
import kotlinx.android.synthetic.main.fragment_chart.*
import kotlinx.android.synthetic.main.fragment_list_box.*


class ListBoxCommentFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setBtnOnClick()
    }

    private fun setBtnOnClick() {
        btnGood.setOnClickListener {
            // pass to good list
            val intent = Intent(activity, ListDetailActivity::class.java)
            intent.putExtra("TYPEOFDATA" , "1" )
            activity!!.startActivity(intent)
        }
        btnNeg.setOnClickListener {
            val intent = Intent(activity, ListDetailActivity::class.java)
            intent.putExtra("TYPEOFDATA" , "-1" )
            activity!!.startActivity(intent)
        }
        btnNeu.setOnClickListener {
            val intent = Intent(activity, ListDetailActivity::class.java)
            intent.putExtra("TYPEOFDATA" , "0" )
            activity!!.startActivity(intent)
        }
    }

    private fun initViewModel() {
        ViewModelProviders.of(activity!!).get(SentimentViewModel::class.java).obserDataFromDataBase().observe(viewLifecycleOwner , Observer {
            sentiment ->
            btnGood.text = "good comment \nsize : ${sentiment.good}"
            btnNeg.text = "neg comment \nsize : ${sentiment.neg}"
            btnNeu.text = "recommend comment \nsize : ${sentiment.neutral}"
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_box  , container , false)
    }



}