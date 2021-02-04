package io.tkey.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appBar = findViewById<Toolbar>(R.id.app_bar)
        appBar.setOnMenuItemClickListener { menu ->
            when (menu.itemId) {
                R.id.base_service_provider -> navigateToBaseServiceProvider()
                else -> throw Exception("Invalid menu item.")
            }
            true
        }
    }

    private fun navigateToBaseServiceProvider() {
        Toast.makeText(this, "Navigating to Base service Provider", Toast.LENGTH_SHORT).show()
    }
}