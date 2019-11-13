package com.eightman.codelabs.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eightman.codelabs.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    /**
     * Inflate layout and setup click listeners and LiveData observers.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val rootLayout: ConstraintLayout = findViewById(R.id.rootLayout)

        val viewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        // When rootLayout is clicked call onMainViewClicked in ViewModel
        rootLayout.setOnClickListener {
            viewModel.onMainViewClicked()
        }

        // Show a snackbar whenever the [ViewModel.snackbar] is updated with a non-null value
        viewModel.snackbar.observe(this, Observer { text ->
            text?.let {
                Snackbar.make(rootLayout, text, Snackbar.LENGTH_SHORT).show()
                viewModel.onSnackbarShown()
            }

        })
    }
}
