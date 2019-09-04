package com.example.sentimentofguitarapp.presenters

class ChartSentimentsCal  {
    var chartSentimentsData: MutableList<Double>
    constructor(chartSentimentsData : MutableList<Double>){
        this.chartSentimentsData = chartSentimentsData
    }

    fun totalValOfSemtiments(): Double = this.chartSentimentsData.reduce{ sumVal , eachData -> sumVal + eachData }
    fun sizeOfSentimentType() : Int {
        return this.chartSentimentsData.size
    }
    fun meanOfSizeData(): Any {
        return  this.chartSentimentsData.reduce { sumVal, eachData -> sumVal + eachData } / this.sizeOfSentimentType()
    }

    fun findMaxVal(): Double?  {
        return   this.chartSentimentsData.max()!!
    }

    fun findPerSent(): List<Int> = this.chartSentimentsData.map {
        ((it / this.totalValOfSemtiments()) * 100).toInt()
    }
}