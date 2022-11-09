package com.example.fragmentocolores

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class VerdeFragment : Fragment() {

    private var listener: Comunicador?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla la vista que hemos creado.
        return inflater.inflate(R.layout.fragment_verde, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Comunicador)
            listener=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnRestar).setOnClickListener { listener?.onClickVerdeResta() }
    }
}