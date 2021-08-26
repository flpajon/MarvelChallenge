package ar.com.intermadia.marvelchallenge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelChallengeApp : Application() {
    companion object {
        const val TAG = "MarvelChallengeApp/"
    }
}