package com.example.sentimentofguitarapp.sentiments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sentimentofguitarapp.firebase.RealTimeDataBaseFireBase
import com.example.sentimentofguitarapp.sentiments.chart.ChartSentimentsCal
import com.google.firebase.database.FirebaseDatabase

class SentimentViewModel : ViewModel() {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val realtimeDb: RealTimeDataBaseFireBase = RealTimeDataBaseFireBase(database , "sentiment")
    fun obserDataFromDataBase() : LiveData<SentimentsModel> {
        return realtimeDb
    }

}