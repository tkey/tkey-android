package io.tkey.types

import org.bouncycastle.jce.spec.ECParameterSpec
import java.math.BigInteger
import java.util.concurrent.CompletableFuture

interface IServiceProvider {
    // TODO: ec and postboxKey may be removed, they're considered implementation details.
    val ec: ECParameterSpec
    val postboxKey: BigInteger

    fun encrypt(msg: ByteArray): CompletableFuture<EncryptedMessage>
    fun decrypt(msg: EncryptedMessage): CompletableFuture<ByteArray>
    fun sign(msg: BigInteger): String
    fun sign(msg: String): String
}