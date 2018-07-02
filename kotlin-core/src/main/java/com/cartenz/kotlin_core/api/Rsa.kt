package com.cartenz.kotlin_core.api

import android.content.Context
import android.util.Base64
import java.io.BufferedReader
import java.io.InputStreamReader
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

public class Rsa() {
    companion object {
        fun encryptRSA(ctx: Context, data: String, resource: Int): String? {
            try {
                val `is` = ctx.resources.openRawResource(resource)
                val br = BufferedReader(InputStreamReader(`is`))
                val lines = ArrayList<String>()
                var line: String? = null
                while (line === br.readLine())
                    lines.add(line!!)

                // removes the first and last lines of the file (comments)
                if (lines.size > 1 && lines[0].startsWith("-----")
                        && lines[lines.size - 1].startsWith("-----")) {
                    lines.removeAt(0)
                    lines.removeAt(lines.size - 1)
                }

                // concats the remaining lines to a single String
                val sb = StringBuilder()
                for (aLine in lines)
                    sb.append(aLine)
                val keyString = sb.toString()

                // converts the String to a PublicKey instance
                val keyBytes = Base64.decode(keyString.toByteArray(charset("utf-8")),
                        Base64.DEFAULT)
                val spec = X509EncodedKeySpec(keyBytes)
                val keyFactory = KeyFactory.getInstance("RSA")
                val key = keyFactory.generatePublic(spec)

                // decrypts the message
                var encryptedText: ByteArray? = null
                val cipher = Cipher
                        .getInstance("RSA/ECB/PKCS1Padding")
                cipher.init(Cipher.ENCRYPT_MODE, key)
                encryptedText = cipher.doFinal(data.toByteArray())
                return Base64.encodeToString(encryptedText, Base64.NO_WRAP)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }

    }
}