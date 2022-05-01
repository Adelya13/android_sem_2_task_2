package kpfu.itis.valisheva.android_app_2.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import kpfu.itis.valisheva.android_app_2.R

import kpfu.itis.valisheva.android_app_2.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also{
            setContentView(it.root)
        }
        controller = findController(R.id.container)
    }
}
