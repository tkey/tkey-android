package io.tkey.types

data class EncryptedMessage(
    val ciphertext: String,
    val ephemPublicKey: String,
    val iv: String,
    val mac: String
)
