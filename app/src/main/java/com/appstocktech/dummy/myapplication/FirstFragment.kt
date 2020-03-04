package com.appstocktech.dummy.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_first.*
import java.lang.IllegalStateException

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var clickListener : ClickListener? = null

    private val args : FirstFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            val bundle = bundleOf("username" to "amir")
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Amir"  , "email@gmail.com", User("amir" , 25) , arrayOf(User("a" , 12) , User("b" , 24)))
            findNavController().navigate(action)
            clickListener?.onClick("First Fragment")
        }

        textview_first.text = args.username
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ClickListener){
            clickListener = context
        }else{
            throw IllegalStateException("Parent Class Must implement ClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }
}
