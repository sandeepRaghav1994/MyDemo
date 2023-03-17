package com.example.sandeepdemo.ui.main

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.sandeepdemo.R
import com.example.sandeepdemo.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomSheetFragment : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style. AppBottomSheetDialogTheme)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        val btnCancel =view.findViewById<TextView>(R.id.btnCancel)
        val btnRecharge =view.findViewById<TextView>(R.id.btnRecharge)
        val button1 =view.findViewById<TextView>(R.id.button1)
        val button2 =view.findViewById<TextView>(R.id.button2)
        val button3 =view.findViewById<TextView>(R.id.button3)
        val etAmount =view.findViewById<EditText>(R.id.etAmount)
        btnCancel.setOnClickListener {
            Toast.makeText(requireContext(),"Cancel Clicked",Toast.LENGTH_LONG).show()
        }
       btnRecharge.setOnClickListener {
            if(TextUtils.isEmpty(etAmount.text.toString())){
                Toast.makeText(requireContext(),"Enter Amount",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            Toast.makeText(requireContext(),"Recharge Done",Toast.LENGTH_LONG).show()
        }
        button1.setOnClickListener {
            etAmount.setText("10000")
            button1.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.white))
            button2.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button3.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button1.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            button2.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button3.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button1.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_selected)
            button2.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_grey)
            button3.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_grey)
        }
        button2.setOnClickListener {
            etAmount.setText("20000")

            button1.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button2.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.white))
            button3.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button1.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button2.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            button3.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button1.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_grey)
            button2.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_selected)
            button3.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_grey)
        }
        button3.setOnClickListener {
            etAmount.setText("30000")

            button1.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button2.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button3.compoundDrawables[0].setTint(ContextCompat.getColor(requireContext(), R.color.white))
            button1.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button2.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
            button3.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            button1.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_grey)
            button2.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_grey)
            button3.background = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_selected)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomSheetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BottomSheetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}