package kpfu.itis.valisheva.android_app_2.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

fun AppCompatActivity.findController(
    id : Int
) = (supportFragmentManager.findFragmentById(id) as NavHostFragment)
    .navController
