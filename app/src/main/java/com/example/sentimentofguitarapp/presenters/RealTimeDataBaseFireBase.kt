package com.example.sentimentofguitarapp.presenters

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sentimentofguitarapp.models.SentimentsModel
import com.google.firebase.database.*


class RealTimeDataBaseFireBase(val database: FirebaseDatabase , val myRef : DatabaseReference , val nameReference : String):
    LiveData<SentimentsModel>() {
    private val TAG = "FIREBASE LOG:"
    private val dbRef = database.getReference(nameReference)

    private val postListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // Get Post object and use the values to update the UI
            val sentiments = dataSnapshot.getValue(SentimentsModel::class.java)
            value = sentiments
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
            Log.w(TAG , "loadPost:onCancelled", databaseError.toException())
        }
    }
}