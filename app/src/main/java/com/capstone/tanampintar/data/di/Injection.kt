package com.capstone.tanampintar.data.di

import android.content.Context
import com.capstone.tanampintar.data.local.pref.UserPreferences
import com.capstone.tanampintar.data.local.pref.dataStore
import com.capstone.tanampintar.data.local.room.HistoryDatabase
import com.capstone.tanampintar.data.network.retrofit.ApiConfig
import com.capstone.tanampintar.repository.AnalysisResultRepository
import com.capstone.tanampintar.repository.DetectionRepository
import com.capstone.tanampintar.repository.PlantRepository
import com.capstone.tanampintar.repository.SoilRepository
import com.capstone.tanampintar.repository.UserRepository

object Injection {
    fun getAuthRepository(context: Context): UserRepository {
        val pref = UserPreferences.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService, pref)
    }

    fun getSoilRepository(context: Context): SoilRepository {
        val apiService = ApiConfig.getApiService()
        return SoilRepository.getInstance(apiService)
    }

    fun getPlantRepository(context: Context): PlantRepository {
        val apiService = ApiConfig.getApiService()
        return PlantRepository.getInstance(apiService)
    }

    fun getDetectionRepository(context: Context): DetectionRepository {
        val apiService = ApiConfig.getApiService()
        return DetectionRepository.getInstance(apiService)
    }

    fun getAnalysisRepository(context: Context): AnalysisResultRepository {
        val database = HistoryDatabase.getDatabase(context)
        return AnalysisResultRepository.getInstance(database.analysisResultDao())
    }
}