package com.example.piedrapapeltijera

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class UsuarioFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var listener: FragmentListener? = null
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
        return inflater.inflate(R.layout.fragment_usuario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnPiedra = view.findViewById<ImageButton>(R.id.btnPiedra)
        val btnPapel = view.findViewById<ImageButton>(R.id.btnPapel)
        val btnTijeras = view.findViewById<ImageButton>(R.id.btnTijeras)
        val btnLagarto = view.findViewById<ImageButton>(R.id.btnLagarto)
        val btnSpok = view.findViewById<ImageButton>(R.id.btnSpok)
        btnPiedra.setOnClickListener { listener?.ClickFragmentBtnPiedra() }
        btnPapel.setOnClickListener { listener?.ClickFragmentBtnPapel() }
        btnTijeras.setOnClickListener { listener?.ClickFragmentBtnTijeras() }
        btnLagarto.setOnClickListener { listener?.ClickFragmentBtnLagarto() }
        btnSpok.setOnClickListener { listener?.ClickFragmentBtnSpok() }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UsuarioFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UsuarioFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            listener = context
        }
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}