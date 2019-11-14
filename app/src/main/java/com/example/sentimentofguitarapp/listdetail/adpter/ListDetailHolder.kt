package com.example.sentimentofguitarapp.listdetail.adpter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.chard_each_list.*

class ListDetailHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {


    fun setCommentText(comentText: String) {
        commentCardText.text = comentText
    }


    private fun handleTypeText(type: String): String =
        when (type) {
            "1" -> "Good Comment"
            "0" -> "Recommend Comment"
            "-1" -> "Negative Comment"
            else -> "Null"
        }


    fun typeOfSentiement(type: String) {
        typeOfComment.text = handleTypeText(type)
    }

    fun freqSet(freq: Int) {
        textFreq.text = "Count of Problem Requires: $freq"
    }
}