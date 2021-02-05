package io.tkey.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.tkey.service_provider_base.BaseServiceProvider
import io.tkey.types.toHexString

class ServiceProviderBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider_base)

        initServices()
        setEventHandlers()
    }

    private lateinit var serviceProvider: BaseServiceProvider

    private fun initServices() {
        serviceProvider = BaseServiceProvider(getString(R.string.mock_key))
    }

    private fun setEventHandlers() {
        val getPublicKey = findViewById<Button>(R.id.get_public_key)
        getPublicKey.setOnClickListener { onGetPublicKey() }

        val encrypt = findViewById<Button>(R.id.encrypt)
        encrypt.setOnClickListener { onEncrypt() }
    }

    private fun onGetPublicKey() {
        consoleLog(serviceProvider.publicKey.toHexString())
    }

    private fun onEncrypt() {
    }

    private fun consoleLog(text: String) {
        val console = findViewById<TextView>(R.id.console_output)
        console.text = text
    }
}