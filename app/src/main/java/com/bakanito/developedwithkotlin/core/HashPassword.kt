package com.bakanito.developedwithkotlin.core

import java.security.MessageDigest

object HashPassword {
    fun String.toSHA256(): String {
        val HEX_CHARS = "0123456789ABCDEF"
        val digest = MessageDigest.getInstance("SHA-256").digest(this.toByteArray())

        return digest.joinToString(
            separator = "",
            transform = {
                String(
                    charArrayOf(
                        HEX_CHARS[it.toInt() shr 4 and 0x0f],
                        HEX_CHARS[it.toInt() and 0x0f]
                    )
                )
            }
        )
    }
}