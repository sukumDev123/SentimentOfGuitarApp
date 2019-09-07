package com.example.sentimentofguitarapp.sentiments.chart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.LayoutParams
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sentimentofguitarapp.R
import com.example.sentimentofguitarapp.sentiments.SentimentViewModel
import com.example.sentimentofguitarapp.sentiments.SentimentsModel
import kotlinx.android.synthetic.main.fragment_chart.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChartFragment : Fragment() {
    lateinit var sentimentViewModeL: SentimentViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }


    private fun initViewModel() {
        sentimentViewModeL = ViewModelProviders.of(activity!!).get(SentimentViewModel::class.java)
        sentimentViewModeL.obserDataFromDataBase().observe(viewLifecycleOwner, Observer { sentiment ->
            //            println("Android sentiment test get data from firebase : ${sentiment.good}")
            setGoodCommentAndBar(sentiment)
        })

    }

    private fun setTextToShowOnTextView(chartSentimentsCal: MutableList<Int>, totalCommentSizeVal: Int): Unit {
        chartText1.text = "good comment ${chartSentimentsCal[0]}%"
        chartText2.text = "recommend comment ${chartSentimentsCal[1]}%"
        chartText3.text = "neg comment ${chartSentimentsCal[2]}%"
        totalCommentSize.text = "comment size : $totalCommentSizeVal"

    }

    private fun setChartBar(chartSentimentsClass : ChartSentimentsCal) {
        val widthMain = totalCommentSize.width
        val chart = chartSentimentsClass.countWidthBarUi(widthMain)
        var params = LayoutParams(
            chart[0], // This will define text view width
            30// This will define text view height
        )
        barChart1.layoutParams = params
        val params2 = LayoutParams(chart[1] , 30)
        barChart2.layoutParams = params2
        val params3 = LayoutParams(chart[2] , 30)
        barChart3.layoutParams = params3
    }
    private fun setGoodCommentAndBar(sentimentNumber: SentimentsModel) {
        val chartSentimentsClass =
            ChartSentimentsCal(mutableListOf(sentimentNumber.good, sentimentNumber.neg, sentimentNumber.neutral))
        val chartSentimentsCal = chartSentimentsClass.persentEachData()
        setTextToShowOnTextView(chartSentimentsCal, chartSentimentsClass.totalSizeComment())
        setChartBar(chartSentimentsClass)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }


}
