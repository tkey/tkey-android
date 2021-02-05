package io.tkey.types

import java.math.BigInteger

interface IServiceProvider {
    fun encrypt(msg: ByteArray): EncryptedMessage
    fun decrypt(msg: EncryptedMessage): ByteArray
    fun sign(msg: BigInteger): String
    fun sign(msg: String): String
}