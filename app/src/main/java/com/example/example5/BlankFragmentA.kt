package com.example.example5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank_a.*


class BlankFragmentA : Fragment() {

    lateinit var communicator: Communicator
    private var name = ""

    companion object {
        fun newInstance(string: String): BlankFragmentA {
            val fragment = BlankFragmentA()
            val bundle = Bundle()
            bundle.putString("name", string)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communicator = activity as Communicator

        name = arguments?.getString("name").toString()
        tvFragmentAName.text = getString(R.string.welcome_message, name)

        btFragmentASearch.setOnClickListener {
            communicator.passData(etFragmentASearch.text.toString())
        }

    }
}