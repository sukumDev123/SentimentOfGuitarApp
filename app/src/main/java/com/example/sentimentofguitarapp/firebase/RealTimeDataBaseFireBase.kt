package com.example.sentimentofguitarapp.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sentimentofguitarapp.sentiments.SentimentsModel
import com.google.firebase.database.*


class RealTimeDataBaseFireBase(
    database: FirebaseDatabase,
    nameReference: String
) : LiveData<SentimentsModel>() {

    private val TAG = "REALTIMEDATABASE LOG:"
    private val dbRef = database.getReference(nameReference)

    private val valueEventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            val sentiments = dataSnapshot.getValue(SentimentsModel::class.java)
            value = sentiments
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
            Log.e(TAG, "loadPost:onCancelled", databaseError.toException())
        }
    }

    override fun onActive() {
        super.onActive()
        dbRef.addValueEventListener(valueEventListener)
    }

    override fun onInactive() {
        super.onInactive()

        dbRef.removeEventListener(valueEventListener)
    }
}