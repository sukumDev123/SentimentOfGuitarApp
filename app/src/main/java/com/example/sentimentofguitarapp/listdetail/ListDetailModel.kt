package com.example.sentimentofguitarapp.listdetail


data class CommentSentiment(var predictVal: String = "" , var userName: String = "", var text : String = "")

data class ListDetailModel(var neutralComment: List<CommentSentiment> , var goodComment: List<CommentSentiment> , var negComment: List<CommentSentiment>)