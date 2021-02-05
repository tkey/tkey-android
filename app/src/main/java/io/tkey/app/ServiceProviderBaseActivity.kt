package io.tkey.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import io.tkey.service_provider_base.BaseServiceProvider
import io.tkey.types.EncryptedMessage
import io.tkey.utils.toHexString

class ServiceProviderBaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider_base)

        initServices()
        setEventHandlers()
    }

    private lateinit var serviceProvider: BaseServiceProvider
    private var encryptedMessage: EncryptedMessage? = null

    private fun initServices() {
        serviceProvider = BaseServiceProvider()
    }

    private fun setEventHandlers() {
        val getPublicKey = findViewById<Button>(R.id.get_public_key)
        getPublicKey.setOnClickListener { onGetPublicKey() }

        val encrypt = findViewById<Button>(R.id.encrypt)
        encrypt.setOnClickListener { onEncrypt() }

        val decrypt = findViewById<Button>(R.id.decrypt)
        decrypt.setOnClickListener { onDecrypt() }
    }

    private fun onGetPublicKey() {
        consoleLog(serviceProvider.keyPair.public.encoded.toHexString())
    }

    private fun onEncrypt() {
        val input = findViewById<TextInputEditText>(R.id.input)
        val encrypted = serviceProvider.encrypt(input.text.toString().toByteArray(Charsets.UTF_8))
        encryptedMessage = encrypted
        consoleLog(encrypted.ciphertext)
    }

    private fun onDecrypt() {
        val msg = encryptedMessage ?: return
        val decrypted = serviceProvider.decrypt(msg)
        consoleLog(decrypted.toString(Charsets.UTF_8))
    }

    private fun consoleLog(text: String) {
        val console = findViewById<TextView>(R.id.console_output)
        console.text = text
    }
}