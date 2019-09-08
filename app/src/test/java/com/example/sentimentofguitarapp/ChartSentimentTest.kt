package com.example.sentimentofguitarapp

import com.example.sentimentofguitarapp.sentiments.chart.ChartSentimentsCal
import org.junit.Assert.assertEquals
import org.junit.Test


class ChartSentimentTest {
//
    @Test
    fun testWidthOfCountSentimentToBarChartWidthSize100() {
        val datasMock = mutableListOf<Int>(100, 0, 0)
        val chartSentimentsCal = ChartSentimentsCal(datasMock)
        val size = 1000
        assertEquals(mutableListOf(1000, 0, 0), chartSentimentsCal.countWidthBarUi(size))
    }

    @Test
    fun testWidthOfCountSentimenttotal200Whenfindwidthwillbe500and500and0() {
        val datasMock = mutableListOf<Int>(100, 100, 0)
        val chartSentimentsCal = ChartSentimentsCal(datasMock)
        val size = 1000
        assertEquals(mutableListOf(500, 500, 0), chartSentimentsCal.countWidthBarUi(size))
    }

    @Test
    fun testIsWantoPersentOfEachOfData() {
        val datasMock = mutableListOf<Int>(10, 100, 5)
        val chartSentimentsCal = ChartSentimentsCal(datasMock)
        assertEquals(mutableListOf(8, 86, 4), chartSentimentsCal.persentEachData())
    }
}