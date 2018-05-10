package com.incredibleandros.navigationsample

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class HomeActivity : AppCompatActivity() {
    lateinit var host: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

         host = supportFragmentManager
                .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return

        // Set up Action Bar
        val navController = host.navController

        //Create listener to display Toast when Navigation happens
        navController.addOnNavigatedListener { _, destination ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }

            Toast.makeText(this@HomeActivity, "Navigated to $dest",
                    Toast.LENGTH_SHORT).show()
            Log.d("NavigationActivity", "Navigated to $dest")
        }


    }





    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(findViewById(R.id.my_nav_host_fragment)).navigateUp()
    }

}
