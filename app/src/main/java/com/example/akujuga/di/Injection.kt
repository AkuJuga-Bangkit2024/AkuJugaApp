package com.example.akujuga.di

import android.content.Context
import com.example.akujuga.data.UserRepository
import com.google.firebase.auth.FirebaseAuth

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val auth = FirebaseAuth.getInstance()
//        val apiService = ApiConfig.getApiService()
//        return UserRepository.getInstance(auth, apiService)
        return UserRepository.getInstance(auth)
    }
}