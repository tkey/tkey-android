package io.tkey.types

import org.bouncycastle.util.encoders.Hex.toHexString

fun ByteArray.toHexString(): String = toHexString(this)