package ru.sodovaya.fragmentexamples.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.random.Random

class ExampleVM : ViewModel() {
    var int = 0
    var observable = MutableLiveData(0)
    var job: Job? = null

    init {
        if (job == null) {
            job = viewModelScope.launch(Dispatchers.IO) {
                while (true) {
                    delay(500)
                    int++
                    withContext(Dispatchers.Main) {
                        observable.value = int
                    }
                }
            }
        }
    }
}