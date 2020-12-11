package com.example.example5.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.example5.util.Communicator
import com.example.example5.R
import com.example.example5.util.Constants.Companion.LOGIN_STRING
import kotlinx.android.synthetic.main.fragment_blank_a.*


class BlankFragmentA : Fragment() {

    lateinit var communicator: Communicator

    companion object {
        fun newInstance(string: String): BlankFragmentA {
            val fragment = BlankFragmentA()
            val bundle = Bundle()
            bundle.putString(LOGIN_STRING, string)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        communicator = activity as Communicator
        arguments?.getString(LOGIN_STRING)?.let {
            tvFragmentAName.text = getString(R.string.welcome_message, it)
        }

        btFragmentASearch.setOnClickListener {
            if (etFragmentASearch.text.isNotEmpty()) {
                communicator.passData(etFragmentASearch.text.toString())
            } else Toast.makeText(view.context, "Search field is empty!", Toast.LENGTH_SHORT).show()
        }
    }
}