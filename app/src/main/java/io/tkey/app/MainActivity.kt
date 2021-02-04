package io.tkey.app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.tkey.service_provider_base.BaseServiceProvider
import io.tkey.types.IServiceProvider

class MainActivity : AppCompatActivity() {
    private val serviceProvider: IServiceProvider =
        BaseServiceProvider("f1f02ee186749cfe1ef8f957fc3d7a5b7128f979bacc10ab3b2a811d4f990852")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        consoleLog(serviceProvider.postboxKey.toString(16))
    }

    private fun consoleLog(text: String) {
        val console = findViewById<TextView>(R.id.console_output)
        console.text = text;
    }
}