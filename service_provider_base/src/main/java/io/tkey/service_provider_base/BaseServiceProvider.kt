package io.tkey.service_provider_base

import io.tkey.types.EncryptedMessage
import io.tkey.types.IServiceProvider
import org.bouncycastle.jce.ECNamedCurveTable
import org.bouncycastle.jce.spec.ECParameterSpec
import java.math.BigInteger
import java.util.concurrent.CompletableFuture

class BaseServiceProvider(postboxKey: String) :
    IServiceProvider {

    private val ec: ECParameterSpec = ECNamedCurveTable.getParameterSpec("secp256k1")
    private val postboxKey: BigInteger = BigInteger(postboxKey, 16)

    val publicKey: ByteArray
        get() {
            val q = ec.g.multiply(BigInteger(1, postboxKey.toByteArray()))
            return q.getEncoded(false)
        }

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