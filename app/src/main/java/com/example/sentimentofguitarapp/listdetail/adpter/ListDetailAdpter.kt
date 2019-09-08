package com.example.sentimentofguitarapp.listdetail.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sentimentofguitarapp.R
import com.example.sentimentofguitarapp.listdetail.CommentSentiment

class ListDetailAdpter:  RecyclerView.Adapter<ListDetailHolder>() {
    private var listComment : List<CommentSentiment>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDetailHolder  = ListDetailHolder(LayoutInflater.from(parent.context).inflate(R.layout.chard_each_list, parent, false))

    override fun getItemCount(): Int = listComment?.size ?: 0

    override fun onBindViewHolder(holder: ListDetailHolder, position: Int) {
        val comment =  this.listComment?.get(position)
        comment?.let {
            holder.setUserName(comment.userName)
            holder.setCommentText(comment.text)
        }
    }

    fun setAdpterList(list: List<CommentSentiment>) {
        this.listComment = list
    }

}