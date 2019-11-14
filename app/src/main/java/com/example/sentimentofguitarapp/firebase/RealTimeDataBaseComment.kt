package com.example.sentimentofguitarapp.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sentimentofguitarapp.listdetail.CommentSentiment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RealTimeDataBaseComment(refDb: FirebaseDatabase) : LiveData<List<CommentSentiment>>() {
    private val dbRef = refDb.getReference("comment_predicted")

    private val listenEvent = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            val dataZip: List<CommentSentiment> = dataSnapshot.children.map { d -> d.getValue(CommentSentiment::class.java)!! }
            Log.w("FIREBASE DATA:", "$dataZip")
            value = dataZip
        }

        override fun onCancelled(databaseError: DatabaseError) {
            Log.e("ERROR", "loadPost:onCancelled", databaseError.toException())
        }
    }

    override fun onActive() {
        super.onActive()
        dbRef.addValueEventListener(listenEvent)
    }

    override fun onInactive() {
        super.onInactive()
        dbRef.removeEventListener(listenEvent)
    }
}