package ru.sodovaya.fragmentexamples.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.sodovaya.fragmentexamples.model.AnimeModel

class AnimeViewModel : ViewModel() {
    val anime = MutableLiveData<AnimeModel?>()
    var job: Job? = null

    init {
        getAnime()
    }

    fun getAnime() {
        if (job == null) {
            job = viewModelScope.launch(Dispatchers.IO) {
                val response = AnimeImpl.getAnime()
                Log.d("AnimeViewModel", "getAnime: $response")
                anime.postValue(response)
                job = null
            }
        }
    }
}