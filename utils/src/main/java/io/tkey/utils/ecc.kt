package io.tkey.utils

import org.bouncycastle.jce.interfaces.ECPrivateKey
import org.bouncycastle.jce.interfaces.ECPublicKey
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.jce.spec.ECPublicKeySpec
import java.security.AlgorithmParameters
import java.security.KeyFactory
import java.security.KeyPair
import java.security.Security
import java.security.spec.ECGenParameterSpec
import java.security.spec.ECParameterSpec
import java.security.spec.ECPrivateKeySpec
import javax.crypto.Cipher

fun setupECC() {
    if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) != null)
        Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME)

    Security.insertProviderAt(BouncyCastleProvider(), 1)
}

fun String.toECPrivateKey(stdName: String): ECPrivateKey {
    val algorithm = AlgorithmParameters.getInstance("EC")
    algorithm.init(ECGenParameterSpec(stdName))

    val ecSpec = algorithm.getParameterSpec(ECParameterSpec::class.java)
    val keySpec = ECPrivateKeySpec(toBigInteger(16), ecSpec)

    val factory = KeyFactory.getInstance("EC")
    return factory.generatePrivate(keySpec) as ECPrivateKey
}

fun ECPrivateKey.getPublicKey(): ECPublicKey {
    val q = parameters.g.multiply(d)
    val keySpec = ECPublicKeySpec(q, parameters)

    val factory = KeyFactory.getInstance("EC")
    return factory.generatePublic(keySpec) as ECPublicKey
}

fun String.toECKeyPair(stdName: String): KeyPair {
    val privateKey = toECPrivateKey(stdName)
    return KeyPair(privateKey.getPublicKey(), privateKey)
}

fun KeyPair.getECCipherInstance(mode: Int): Cipher {
    val cipher = Cipher.getInstance("ECIES")
    when (mode) {
        Cipher.ENCRYPT_MODE -> cipher.init(mode, public)
        Cipher.DECRYPT_MODE -> cipher.init(mode, private)
        else -> throw Exception("Unsupported cipher mode.")
    }
    return cipher
}