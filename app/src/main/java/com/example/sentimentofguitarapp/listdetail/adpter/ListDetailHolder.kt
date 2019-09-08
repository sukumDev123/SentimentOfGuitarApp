package com.example.sentimentofguitarapp.listdetail.adpter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.chard_each_list.*

class ListDetailHolder( override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
    fun setUserName(userName : String? ) {
        if(userName == "") {
            userCardText.text = "Anonymost"

        } else {
            userCardText.text = userName
        }
    }
    fun setCommentText(comentText: String) {
        commentCardText.text = comentText
    }
}