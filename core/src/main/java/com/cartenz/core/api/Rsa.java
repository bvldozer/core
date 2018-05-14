package com.cartenz.core.api;

import android.content.Context;
import android.util.Base64;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;

public class Rsa {
    public static String encryptRSA(Context ctx, String data, int resource) {
        try {
            InputStream is = ctx.getResources().openRawResource(resource);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = br.readLine()) != null)
                lines.add(line);

            // removes the first and last lines of the file (comments)
            if (lines.size() > 1 && lines.get(0).startsWith("-----")
                    && lines.get(lines.size() - 1).startsWith("-----")) {
                lines.remove(0);
                lines.remove(lines.size() - 1);
            }

            // concats the remaining lines to a single String
            StringBuilder sb = new StringBuilder();
            for (String aLine : lines)
                sb.append(aLine);
            String keyString = sb.toString();

            // converts the String to a PublicKey instance
            byte[] keyBytes = Base64.decode(keyString.getBytes("utf-8"),
                    Base64.DEFAULT);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey key = keyFactory.generatePublic(spec);

            // decrypts the message
            byte[] encryptedText = null;
            Cipher cipher = Cipher
                    .getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encryptedText = cipher.doFinal(data.getBytes());
            return Base64.encodeToString(encryptedText, Base64.NO_WRAP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
