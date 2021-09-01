package com.beefirst.zatsh.di

import com.beefirst.zatsh.utils.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    @Provides
    fun providerPref() : UserPreferences {
        return UserPreferences()
    }
}