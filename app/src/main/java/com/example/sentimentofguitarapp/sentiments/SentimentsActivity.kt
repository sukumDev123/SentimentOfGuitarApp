package com.example.sentimentofguitarapp.sentiments

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import com.example.sentimentofguitarapp.R
import com.example.sentimentofguitarapp.sentiments.chart.ChartFragment
import com.example.sentimentofguitarapp.sentiments.chart.ChartSentimentsCal


class SentimentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentiments_parent)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction().add(R.id.frameSentimentParants1, ChartFragment()).commit()
    }


}