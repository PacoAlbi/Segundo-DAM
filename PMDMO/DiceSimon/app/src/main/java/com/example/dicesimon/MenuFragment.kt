package com.example.dicesimon

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MenuFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var listener: SimonListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnFacil = view.findViewById<Button>(R.id.btnFacil)
        val btnMedio = view.findViewById<Button>(R.id.btnMedio)
        val btnDificil = view.findViewById<Button>(R.id.btnDificil)
        btnFacil.setOnClickListener { listener?.onClickFacil() }
        btnMedio.setOnClickListener { listener?.onClickMedio() }
        btnDificil.setOnClickListener { listener?.onClickDificil() }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SimonListener) {
            listener = context
        }
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}