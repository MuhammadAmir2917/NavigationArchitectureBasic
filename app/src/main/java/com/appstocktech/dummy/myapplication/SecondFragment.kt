package com.appstocktech.dummy.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_second.*
import java.lang.IllegalStateException

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val args : SecondFragmentArgs by navArgs()
    private var clickListener : ClickListener? = null
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment("From Second Fragment")
            findNavController().navigate(action)
            clickListener?.onClick("second Fragemnt")
        }
        val username = args.username
        val email =args.email
        val user = args.user
        val users = args.users
        textview_second.text = "$username $email"
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
