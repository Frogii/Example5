package com.example.example5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank_b.*


class BlankFragmentB : Fragment() {

    var search = ""

    companion object{
        fun newInstance(string: String): BlankFragmentB{
            val fragment = BlankFragmentB()
            val bundle = Bundle()
            bundle.putString("search", string)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search = arguments?.getString("search").toString()
        tvFragmentB.text = search
    }
}