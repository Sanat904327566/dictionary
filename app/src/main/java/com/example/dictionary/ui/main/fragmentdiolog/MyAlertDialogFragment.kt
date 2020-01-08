package com.example.dictionary.ui.main.fragmentdiolog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.DialogFragment

import com.example.dictionary.R
import com.example.dictionary.db.model.Translation

class MyAlertDialogFragment : DialogFragment() {

    private var textViewOne: TextView? = null
    private var textViewTwo: TextView? = null
    private var textViewThree: TextView? = null
    private var textViewFour: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.material_dialog, container, false)
        textViewOne = view.findViewById(R.id.tv_one)
        textViewTwo = view.findViewById(R.id.tv_two)
        textViewThree = view.findViewById(R.id.tv_three)
        textViewFour = view.findViewById(R.id.tv_four)

        textViewOne!!.text = args.getString("tvOne")
        textViewTwo!!.text = args.getString("tvTwo")
        textViewThree!!.text = args.getString("tvThree")
        textViewFour!!.text = args.getString("tvFour")

        return view
    }

    companion object {
        internal lateinit var args: Bundle

        fun newInstance(trans: Translation): MyAlertDialogFragment {
            val frag = MyAlertDialogFragment()
            args = Bundle()

            args.putString("tvOne", trans.wordsOne)
            args.putString("tvTwo", trans.wordTwo)
            args.putString("tvThree", trans.wordThree)
            args.putString("tvFour", trans.wordFour)

            frag.arguments = args
            return frag
        }
    }

}