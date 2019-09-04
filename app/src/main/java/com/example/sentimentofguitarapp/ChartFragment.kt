package com.example.sentimentofguitarapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sentimentofguitarapp.presenters.ChartSentimentsCal


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ChartFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ChartFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val chartData: MutableList<Int> = mutableListOf(100 , 200 , 300)
//        val chartSentiment : ChartSentimentsCal = ChartSentimentsCal(chartData)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }




}
