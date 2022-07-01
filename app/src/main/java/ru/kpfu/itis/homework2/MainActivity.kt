package ru.kpfu.itis.homework2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.kpfu.itis.homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var controller: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        controller =
            (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController
        binding.bottomView.setupWithNavController(controller)
    }

}