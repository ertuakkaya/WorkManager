package com.example.workmanager

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonYap.setOnClickListener {

//            // internet var ise calisma kosulu yarat
//            val calismaKosulu = Constraints.Builder().setRequiredNetworkType((NetworkType.CONNECTED))
//                .build()
//
//
//            val istek = OneTimeWorkRequestBuilder<MyWorker>()
//                .setInitialDelay(3,TimeUnit.SECONDS) // 3 saniye sonra çalıştır
//                .setConstraints(calismaKosulu) // yazilan kosulu sagla
//                .build()
//
//
//            WorkManager.getInstance(this).enqueue(istek)
//
//            WorkManager.getInstance(this).getWorkInfoByIdLiveData(istek.id).observe(this){
//                val durum = it.state.name
//                Log.e("Arkapalan islem durumu",durum)
//            }

            // min 15 dk oldugu icin 15 verilir
            val istek = PeriodicWorkRequestBuilder<MyWorkerBildirim>(15,TimeUnit.MINUTES)
                .setInitialDelay(5,TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(this).enqueue(istek)
        }









    }
}