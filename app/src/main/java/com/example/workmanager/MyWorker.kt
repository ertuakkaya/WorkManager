package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext : Context , workerParams: WorkerParameters) : Worker(appContext, workerParams) {
    // arkaplanda yapılacak işlemler buraya yazılır
    override fun doWork(): Result {
        val toplam = 10 + 20
        Log.e("Arkaplan islem sonucu", toplam.toString())
        return Result.success()
    }
}