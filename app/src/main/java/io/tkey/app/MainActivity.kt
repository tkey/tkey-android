package io.tkey.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appBar = findViewById<Toolbar>(R.id.app_bar)
        appBar.setOnMenuItemClickListener { menu ->
            when (menu.itemId) {
                R.id.item_service_provider_base -> navigateTo(ServiceProviderBaseActivity::class)
                else -> throw Exception("Invalid menu item.")
            }
            true
        }
    }

    private fun <T : Activity> navigateTo(cls: KClass<T>) {
        startActivity(Intent(this, cls.java))
    }
}