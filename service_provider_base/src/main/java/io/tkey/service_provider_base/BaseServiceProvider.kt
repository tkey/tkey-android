package io.tkey.service_provider_base

import io.tkey.types.EncryptedMessage
import io.tkey.types.IServiceProvider
import java.math.BigInteger
import java.security.KeyPairGenerator
import java.util.concurrent.CompletableFuture

class BaseServiceProvider(postboxKey: String) :
    IServiceProvider {

    override val ec: KeyPairGenerator = KeyPairGenerator.getInstance("EC")
    override val postboxKey: BigInteger = BigInteger(postboxKey, 16)

    override fun encrypt(msg: ByteArray): CompletableFuture<EncryptedMessage> {
        TODO("Not yet implemented")
    }

    override fun decrypt(msg: EncryptedMessage): CompletableFuture<ByteArray> {
        TODO("Not yet implemented")
    }

    override fun sign(msg: BigInteger): String {
        TODO("Not yet implemented")
    }

    override fun sign(msg: String): String {
        TODO("Not yet implemented")
    }
}