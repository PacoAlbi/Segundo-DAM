package com.example.fragmentocolores

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class RojoFragment : Fragment() {

    //private var btnSumar = null
    //private var azulFragmentInstance: AzulFragment?=null
    private var listener: Comunicador?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla la vista que hemos creado.
        return inflater.inflate(R.layout.fragment_rojo, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Comunicador)
            listener=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnSumar).setOnClickListener { listener?.onClickRojoSuma() }
    }


}
/*
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_rojo, container, false)
        val senDataButton:  Button = view.findViewById(R.id.fragmentoRojo)
        senDataButton.setOnClickListener {
            senDataButton.setOnClickListener {
                azulFragmentInstance?.setData(btnSumar)
            }
        }
        // Infla la vista
        return inflater.inflate(R.layout.fragment_rojo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private var sharedViewModelInstance: SharedViewModel? = null

    private var editTextFromFragment1: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_1, container, false)

        val sendDataButton: Button = view.findViewById(R.id.send_button_fragment_1)
        editTextFromFragment1 = view.findViewById(R.id.edit_text_from_fragment_1)

        // as soon as the button is clicked
        // send the data to ViewModel
        // and the Live data will take care of
        // updating the data inside another Fragment
        sendDataButton.setOnClickListener {
            sharedViewModelInstance?.setData(editTextFromFragment1!!.text)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // create instances of the shared view model
        // when the activity is created
        sharedViewModelInstance = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)

        // observe the data inside the view model that
        // is mutable live of type CharSequence and
        // set the data for edit text
        sharedViewModelInstance!!.getData().observe(viewLifecycleOwner, Observer {
            editTextFromFragment1!!.text = it as Editable?
        })
    }
}*/