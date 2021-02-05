package io.tkey.utils

import org.apache.commons.codec.binary.Base64

fun ByteArray.encodeBase64String(): String = Base64.encodeBase64String(this)

fun String.decodeBase64(): ByteArray = Base64.decodeBase64(this)
