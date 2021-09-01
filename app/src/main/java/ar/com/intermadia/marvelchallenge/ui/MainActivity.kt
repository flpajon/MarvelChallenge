package ar.com.intermadia.marvelchallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ar.com.intermadia.marvelchallenge.R
import ar.com.intermadia.marvelchallenge.core.hide
import ar.com.intermadia.marvelchallenge.core.show
import ar.com.intermadia.marvelchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvMenu.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.characterListFragment -> {
                    binding.bnvMenu.show()
                }
                R.id.eventListFragment -> {
                    binding.bnvMenu.show()
                }
                else -> {
                    binding.bnvMenu.hide()
                }
            }
        }
    }

}