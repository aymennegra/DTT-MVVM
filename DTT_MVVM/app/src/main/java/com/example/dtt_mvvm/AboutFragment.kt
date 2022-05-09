package com.example.dtt_mvvm

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_about, container, false)
        val linkdtt : TextView = view.findViewById(R.id.linkdtt)
        val description : TextView = view.findViewById(R.id.textt)
        linkdtt.setMovementMethod(LinkMovementMethod.getInstance())
        description.setText("Lorem ipsum dolor sit amet , consecteur adipiscing elit" +
                ", sed do eiusmod tempor incididunt ut labore et dolore magna" +
                "aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris" +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in dolor in reprehenderit in" +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                "occaecat cupidatat non proident, sunt in culpa qui officia" +
                "deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet," +
                "consecteur adipiscing elit, sed do eiusmod tempor incididunt ut labore" +
                "et dolore magna aliqua. Ut enim ad minin veniam, quis nostrud exercitation" +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure" +
                "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla" +
                "pariatur. Exepteur sint occaecat cupidatat non priodent. ")
        return view

    }

}