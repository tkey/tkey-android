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
        setEventHandlers()
    }

    private val serviceProvider =
        BaseServiceProvider("f1f02ee186749cfe1ef8f957fc3d7a5b7128f979bacc10ab3b2a811d4f990852")

    private fun setEventHandlers() {
        val encrypt = findViewById<Button>(R.id.encrypt)
        encrypt.setOnClickListener { onEncrypt() }
    }

    private fun onEncrypt() {
        consoleLog(serviceProvider.publicKey.toHexString())
    }

    private fun consoleLog(text: String) {
        val console = findViewById<TextView>(R.id.console_output)
        console.text = text
    }
}