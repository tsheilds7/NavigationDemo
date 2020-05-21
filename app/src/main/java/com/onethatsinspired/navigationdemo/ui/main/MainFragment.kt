package com.onethatsinspired.navigationdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.onethatsinspired.navigationdemo.R

class MainFragment : Fragment() {

    private var mViewModel: MainViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        val button = view!!.findViewById<Button>(R.id.button)

        //button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mainToSecond,null));
        button.setOnClickListener { v ->
            val userText = view!!.findViewById<EditText>(R.id.userText)
            val action = MainFragmentDirections.mainToSecond()
            action.message = userText.text.toString()
            Navigation.findNavController(v).navigate(action)
        }
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}