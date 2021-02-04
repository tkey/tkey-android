package io.tkey.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import io.tkey.service_provider_base.BaseServiceProvider
import io.tkey.types.IServiceProvider

class ServiceProviderBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider_base)
        setEventHandlers()
    }

    private val serviceProvider: IServiceProvider =
        BaseServiceProvider("f1f02ee186749cfe1ef8f957fc3d7a5b7128f979bacc10ab3b2a811d4f990852")

    private fun setEventHandlers() {
        val input = findViewById<TextInputEditText>(R.id.input)
        val encrypt = findViewById<Button>(R.id.encrypt)
        encrypt.setOnClickListener { onEncrypt(input.text.toString()) }
    }

    private fun onEncrypt(input: String) {
        consoleLog(serviceProvider.postboxKey.toString(16))
    }

    private fun consoleLog(text: String) {
        val console = findViewById<TextView>(R.id.console_output)
        console.text = text
    }
}