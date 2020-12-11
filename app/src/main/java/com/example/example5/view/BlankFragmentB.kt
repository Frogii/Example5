package com.example.example5.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.example5.R
import com.example.example5.util.Constants.Companion.SEARCH_STRING
import kotlinx.android.synthetic.main.fragment_blank_b.*


class BlankFragmentB : Fragment() {


    companion object {
        fun newInstance(string: String): BlankFragmentB {
            val fragment = BlankFragmentB()
            val bundle = Bundle()
            bundle.putString(SEARCH_STRING, string)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(SEARCH_STRING).let {
            tvFragmentB.text = it
        }
    }
}