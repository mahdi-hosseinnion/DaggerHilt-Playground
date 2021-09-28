package com.example.daggerhilt_playground.presentation

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.daggerhilt_playground.R
import com.example.daggerhilt_playground.domain.models.Blog
import com.example.daggerhilt_playground.domain.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment
constructor(
    //just for example (unnecessary variable)
    private val blogName: String
) : Fragment(R.layout.fragment_main) {

    private val TAG = "MainFragment"

    private val viewModel: MainViewModel by viewModels()

    private var progressBar: ProgressBar? = null
    private var txt: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.text)
        progressBar = view.findViewById(R.id.progress_bar)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getBlogs().observe(viewLifecycleOwner) { ds ->
            ds?.let { dataState ->
                when (dataState) {
                    is DataState.Success -> {
                        handleSuccessCase(dataState.data)
                    }
                    is DataState.Error -> {
                        handleErrorCase(dataState.exception)
                    }
                    is DataState.Loading -> {
                        handleLoadingCase()
                    }
                }
            }
        }
    }


    private fun handleSuccessCase(list: List<Blog>) {
        progressBar?.visibility = View.GONE
        val blogsTitleList = list.map { "\n" + it.title }
        txt?.setTextColor(Color.BLACK)
        txt?.text = "Hello it's $blogName blog \nblog titles: \n ${blogsTitleList}"
    }

    private fun handleErrorCase(exception: Exception) {
        progressBar?.visibility = View.GONE
        Log.e(TAG, "handleErrorCase: message: ${exception.message}", exception)
        txt?.setTextColor(Color.RED)
        val message = exception.message.toString()
        txt?.text = if (message.isNotBlank()) message else "Unknown error"
    }

    private fun handleLoadingCase() {
        progressBar?.visibility = View.VISIBLE
    }
}