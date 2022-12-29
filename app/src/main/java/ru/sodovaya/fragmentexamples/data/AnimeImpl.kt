package ru.sodovaya.fragmentexamples.data

import io.ktor.client.call.*
import io.ktor.client.request.*
import ru.sodovaya.fragmentexamples.MainApp
import ru.sodovaya.fragmentexamples.model.AnimeModel

object AnimeImpl : AnimeInterface {
    private val httpClient = MainApp.longlive.httpClient

    override suspend fun getAnime(): AnimeModel {
        return httpClient.get {
            url(AnimeEnv.CONTENT_URL)
        }.body()
    }
}

