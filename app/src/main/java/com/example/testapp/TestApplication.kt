package com.example.testapp

import android.app.Application
import com.example.testapp.di.ApplicationComponent
import com.example.testapp.di.DaggerApplicationComponent

class TestApplication : Application() {

    val appComponent: ApplicationComponent by lazy { DaggerApplicationComponent.create() }
}
