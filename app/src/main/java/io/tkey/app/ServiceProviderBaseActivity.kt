package io.tkey.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ServiceProviderBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider_base)
    }
}