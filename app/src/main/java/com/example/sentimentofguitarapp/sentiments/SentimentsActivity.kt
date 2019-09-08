package com.example.sentimentofguitarapp.sentiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sentimentofguitarapp.R
import com.example.sentimentofguitarapp.sentiments.chart.ChartFragment
import com.example.sentimentofguitarapp.sentiments.listcomment.ListBoxCommentFragment


class SentimentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentiments_parent)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction().add(R.id.frameSentimentParants1, ChartFragment()).add(R.id.frameSentimentParants2 , ListBoxCommentFragment()).commit()
    }


}