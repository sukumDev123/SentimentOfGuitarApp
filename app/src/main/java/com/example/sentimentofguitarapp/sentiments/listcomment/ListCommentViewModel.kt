package com.example.sentimentofguitarapp.sentiments.listcomment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sentimentofguitarapp.firebase.RealTimeDataBaseComment
import com.example.sentimentofguitarapp.listdetail.ListDetailModel
import com.google.firebase.database.FirebaseDatabase

class ListCommentViewModel : ViewModel() {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val realtimeDb: RealTimeDataBaseComment = RealTimeDataBaseComment(database)
    fun obserDataFromDataBase() : LiveData<ListDetailModel>  {
        return realtimeDb
    }
}