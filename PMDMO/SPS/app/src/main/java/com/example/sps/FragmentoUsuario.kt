package com.example.sps

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import java.util.*

class FragmentoUsuario : Fragment() {


    private var listener: OnFragmentActionsListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragmento_usuario, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnPiedra = view.findViewById<ImageButton>(R.id.imgPiedra)
        val btnPapel = view.findViewById<ImageButton>(R.id.imgPapel)
        val btnTijeras = view.findViewById<ImageButton>(R.id.imgTijeras)

        btnPiedra.setOnClickListener { listener?.onClickFragmentButtonPiedra() }
        btnPapel.setOnClickListener { listener?.onClickFragmentButtonPapel() }
        btnTijeras.setOnClickListener{listener?.onClickFragmentButtonTijeras()}
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentActionsListener) {
            listener = context
        }
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}

