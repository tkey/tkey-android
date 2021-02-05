package io.tkey.service_provider_base

import io.tkey.types.EncryptedMessage
import io.tkey.types.IServiceProvider
import io.tkey.utils.*
import java.math.BigInteger
import java.security.KeyPair
import javax.crypto.Cipher

class BaseServiceProvider(postboxKey: String) :
    IServiceProvider {
    companion object {
        init {
            setupECC()
        }
    }

    val keyPair: KeyPair = postboxKey.toECKeyPair("secp256k1")

    override fun encrypt(msg: ByteArray): EncryptedMessage {
        val cipher = keyPair.getECCipherInstance(Cipher.ENCRYPT_MODE)
        val encryptedMsg = cipher.doFinal(msg)
        return EncryptedMessage(encryptedMsg.encodeBase64String(), "", "", "")
    }

    override fun decrypt(msg: EncryptedMessage): ByteArray {
        val cipher = keyPair.getECCipherInstance(Cipher.DECRYPT_MODE)
        return cipher.doFinal(msg.ciphertext.decodeBase64())
    }

    override fun sign(msg: BigInteger): String {
        TODO("Not yet implemented")
    }

    override fun sign(msg: String): String {
        TODO("Not yet implemented")
    }
}