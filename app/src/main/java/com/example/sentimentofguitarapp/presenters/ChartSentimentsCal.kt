package com.example.sentimentofguitarapp.presenters

class ChartSentimentsCal(var chartSentimentsData: MutableList<Double>) {

    fun totalValOfSemtiments(): Double = this.chartSentimentsData.reduce { sumVal, eachData -> sumVal + eachData }
    fun sizeOfSentimentType(): Int = this.chartSentimentsData.size

    fun meanOfSizeData(): Any =
        this.chartSentimentsData.reduce { sumVal, eachData -> sumVal + eachData } / this.sizeOfSentimentType()

    fun findMaxVal(): Double = this.chartSentimentsData.max()!!

    fun findPerSent(): List<Int> = this.chartSentimentsData.map {
        ((it / this.totalValOfSemtiments()) * 100).toInt()
    }
}