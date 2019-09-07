package com.example.sentimentofguitarapp.sentiments.chart

class ChartSentimentsCal(var chartSentimentsData: MutableList<Int>) {
    fun totalSizeComment() = chartSentimentsData.reduce { sumVal, result -> sumVal + result }
    fun persentEachData(): MutableList<Int> {
        val dataToDouble: List<Double> = chartSentimentsData.map { d -> d.toDouble() }
        val dataDoubleToInt: List<Int> = dataToDouble.map { sentimentCount ->
            ((sentimentCount / totalSizeComment()) * 100).toInt()
        }
        return dataDoubleToInt as MutableList<Int>
    }

    fun countWidthBarUi(sizeUi: Int): List<Int> = chartSentimentsData.map { d ->
        val findPersentOfwidth  : Double = d.toDouble() / totalSizeComment().toDouble() * 100.0 // first find % of total data
        val findWidthEachThisPersent = sizeUi / 100.0 * findPersentOfwidth // get % find width
        findWidthEachThisPersent.toInt()
    }

}