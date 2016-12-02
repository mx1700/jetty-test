package me.mx1700.http.auth

import javax.xml.bind.DatatypeConverter.parseBase64Binary
import javax.xml.bind.DatatypeConverter


object BasicAuth {
    fun decode(_auth: String): Array<String>? {
        var auth = _auth
        //Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
        auth = auth.replaceFirst("[B|b]asic ".toRegex(), "")

        //Decode the Base64 into byte[]
        val decodedBytes = DatatypeConverter.parseBase64Binary(auth)

        //If the decode fails in any case
        if (decodedBytes == null || decodedBytes.isEmpty()) {
            return null
        }

        //Now we can convert the byte[] into a splitted array :
        //  - the first one is login,
        //  - the second one password
        return String(decodedBytes).split(":".toRegex(), 2).toTypedArray()
    }
}