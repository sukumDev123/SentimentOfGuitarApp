package com.example.sentimentofguitarapp

import com.example.sentimentofguitarapp.presenters.ChartSentimentsCal
import org.junit.Assert.assertEquals
import org.junit.Test


class ChartSentimentTest {

    @Test fun findPerSentOfTotal600() {
        val chartData: MutableList<Double> = mutableListOf(100.0 , 200.0 , 300.0)
        val chartSentiment : ChartSentimentsCal = ChartSentimentsCal(chartData)
        assertEquals(listOf(16 , 33 , 50) , chartSentiment.findPerSent())
    }


    @Test fun chartFindMixOfData() {
        val chartData: MutableList<Double> = mutableListOf(100.0 , 200.0 , 300.0)

        val chartSentiment : ChartSentimentsCal = ChartSentimentsCal(chartData)
        assertEquals(300.0 , chartSentiment.findMaxVal())
    }

    @Test fun chartFindMixOfData2() {
        val chartData: MutableList<Double> = mutableListOf(100.0 , 400.0 , 200.0 , 300.0)

        val chartSentiment : ChartSentimentsCal = ChartSentimentsCal(chartData)
        assertEquals(400.0 , chartSentiment.findMaxVal())
    }

    @Test
    fun chartIsMeanOfData() {
        val chartData: MutableList<Double> = mutableListOf(100.0 , 200.0 , 300.0)

        val chartSentiment : ChartSentimentsCal = ChartSentimentsCal(chartData)

        assertEquals(200.0 , chartSentiment.meanOfSizeData())

    }

    @Test
    fun chartIs3SizeOfData(){
        val chartData: MutableList<Double> = mutableListOf(100.0 , 200.0 , 300.0)

        val chartSentiment : ChartSentimentsCal = ChartSentimentsCal(chartData)
        assertEquals(3 , chartSentiment.sizeOfSentimentType())
    }

    @Test
    fun chartIs10SizeOfData(){
        val chartData: MutableList<Double> = mutableListOf(100.0 , 200.0 , 300.0 , 100.0 , 200.0 , 300.0 , 1.0 , 3.0 , 5.0 , 50.0)

        val chartSentiment : ChartSentimentsCal = ChartSentimentsCal(chartData)
        assertEquals(10 , chartSentiment.sizeOfSentimentType())
    }
}