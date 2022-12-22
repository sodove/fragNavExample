package ru.sodovaya.fragmentexamples

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.sodovaya.fragmentexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= 27)
            window.navigationBarColor = Color.TRANSPARENT

        val container = binding.mainLayout
        val paddingTop = container.paddingTop
        ViewCompat.setOnApplyWindowInsetsListener(container) { v, insets ->
            val systemBarInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(top = paddingTop + systemBarInsets.top)
            insets
        }

        val navView: BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragment_container_view)

        val appBarConfig = AppBarConfiguration(
            setOf(R.id.navigationFirst, R.id.navigationSecond)
        )

        setSupportActionBar(binding.topAppBar)

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}