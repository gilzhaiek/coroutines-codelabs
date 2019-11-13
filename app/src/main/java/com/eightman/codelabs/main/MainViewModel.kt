package com.eightman.codelabs.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eightman.codelabs.util.BACKGROUND

class MainViewModel : ViewModel() {
    /**
     * Request a snackbar to display a string.
     *
     * This variable is private because we don't want to expose MutableLiveData
     *
     * MutableLiveData allows anyone to set a value, and MainViewModel is the only
     * class that should be setting values.
     */
    private val _snackBar = MutableLiveData<String>()

    /**
     * Request a snackbar to display a string.
     */
    val snackbar: LiveData<String>
        get() = _snackBar

    /**
     * Wait one second then display a snackbar.
     */
    fun onMainViewClicked() {
        // TODO: Replace with coroutine implementation
        BACKGROUND.submit {
            Thread.sleep(1_000)
            // use postValue since we're in a background thread
            _snackBar.postValue("Hello, from threads!")
        }
    }

    /**
     * Called immediately after the UI shows the snackbar.
     */
    fun onSnackbarShown() {
        _snackBar.value = null
    }
}
