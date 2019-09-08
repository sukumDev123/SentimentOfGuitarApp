package com.example.sentimentofguitarapp.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sentimentofguitarapp.listdetail.CommentSentiment
import com.example.sentimentofguitarapp.listdetail.ListDetailModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RealTimeDataBaseComment(refDb: FirebaseDatabase) : LiveData<ListDetailModel>() {
    private val dbRef = refDb.getReference("commect_predicted")

    private val listenEvent = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
//            val sentiments = dataSnapshot
            val dataZip: ListDetailModel = ListDetailModel(listOf(), listOf(), listOf())
            dataZip.goodComment = dataSnapshot.child("goodComment").children.map { d ->
//                Log.w("FIREBASE : " , "${d.value}")
                d.getValue(CommentSentiment::class.java)!!
            }
            dataZip.negComment =
                dataSnapshot.child("negComment").children.map { d -> d.getValue(CommentSentiment::class.java)!! }

            dataZip.neutralComment = dataSnapshot.child("neutralComment").children.map {
                d -> d.getValue(CommentSentiment::class.java)!!
            }

            Log.w("FIREBASE DATA:", "$dataZip")
            value = dataZip
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
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