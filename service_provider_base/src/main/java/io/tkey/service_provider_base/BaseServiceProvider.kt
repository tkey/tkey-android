package io.tkey.service_provider_base

import io.tkey.types.EncryptedMessage
import io.tkey.types.IServiceProvider
import io.tkey.utils.decodeBase64
import io.tkey.utils.encodeBase64String
import org.bouncycastle.jce.interfaces.ECPrivateKey
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.jce.spec.ECPublicKeySpec
import java.math.BigInteger
import java.security.*
import java.security.spec.ECGenParameterSpec
import java.security.spec.ECParameterSpec
import java.security.spec.ECPrivateKeySpec
import javax.crypto.Cipher

class BaseServiceProvider(postboxKey: String) :
    IServiceProvider {
    companion object {
        init {
            if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) != null)
                Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME)

            Security.insertProviderAt(BouncyCastleProvider(), 1)
        }

        fun getPublicKey(privateKey: PrivateKey): PublicKey {
            val ecPrivateKey = privateKey as ECPrivateKey

            val q = ecPrivateKey.parameters.g.multiply(ecPrivateKey.d)
            val ecPublicKeySpec = ECPublicKeySpec(q, ecPrivateKey.parameters)
           
            val keyFactory = KeyFactory.getInstance("EC")
            return keyFactory.generatePublic(ecPublicKeySpec)
        }
    }

    val keyPair: KeyPair

    init {
        val algorithm = AlgorithmParameters.getInstance("EC")
        algorithm.init(ECGenParameterSpec("secp256k1"))

        val ecSpec = algorithm.getParameterSpec(ECParameterSpec::class.java)
        val privateKeySpec = ECPrivateKeySpec(postboxKey.toBigInteger(16), ecSpec)

        val keyFactory = KeyFactory.getInstance("EC")
        val privateKey = keyFactory.generatePrivate(privateKeySpec)
        val publicKey = getPublicKey(privateKey)
        keyPair = KeyPair(publicKey, privateKey)
    }

    private fun getCipherInstance(): Cipher = Cipher.getInstance("ECIES")

    override fun encrypt(msg: ByteArray): EncryptedMessage {
        val cipher = getCipherInstance()
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.public)

        val encryptedMsg = cipher.doFinal(msg)
        return EncryptedMessage(encryptedMsg.encodeBase64String(), "", "", "")
    }

    override fun decrypt(msg: EncryptedMessage): ByteArray {
        val cipher = getCipherInstance()
        cipher.init(Cipher.DECRYPT_MODE, keyPair.private)

        val decryptedMsg = cipher.doFinal(msg.ciphertext.decodeBase64())
        return decryptedMsg
    }

    override fun sign(msg: BigInteger): String {
        TODO("Not yet implemented")
    }

    override fun sign(msg: String): String {
        TODO("Not yet implemented")
    }
}