package com.test.TestEpoxy

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavedStateViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        private const val BUNDLE = "bundle"
    }

    fun restoreState() = state.get<Bundle>(BUNDLE)

    fun saveState(bundle: Bundle) {
        state[BUNDLE] = bundle
    }

}