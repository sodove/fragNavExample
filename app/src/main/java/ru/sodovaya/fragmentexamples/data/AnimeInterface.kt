package ru.sodovaya.fragmentexamples.data

import ru.sodovaya.fragmentexamples.model.AnimeModel

interface AnimeInterface {
    suspend fun getAnime(): AnimeModel
}