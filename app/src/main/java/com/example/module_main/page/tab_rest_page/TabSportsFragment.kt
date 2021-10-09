package com.example.module_main.page.tab_rest_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.module_main.R


class TabSportsFragment : Fragment() {

    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("DDD","Sports Tap Create")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("DDD","Sports Tap onCreateView")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_in_rest_sports, container, false)
    }

    override fun onStart() {
        super.onStart()

        Log.d("DDD","Sports Tap Start")
    }

    override fun onResume() {
        super.onResume()

        Log.d("DDD","Sports Tap Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DDD","Sports Tap Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DDD","Sports Tap Stop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("DDD","Sports Tap Destroy")
    }


}