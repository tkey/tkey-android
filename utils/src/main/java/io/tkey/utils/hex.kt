package io.tkey.utils

import org.bouncycastle.util.encoders.Hex

fun ByteArray.toHexString(): String = Hex.toHexString(this)
