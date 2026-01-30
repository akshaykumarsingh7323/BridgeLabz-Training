package com.csvdatahandling.encryptanddecryptcsvdata;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567890123456"; // 16 chars

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder()
                         .encodeToString(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Encryption error");
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(
                    Base64.getDecoder().decode(encryptedData)));
        } catch (Exception e) {
            throw new RuntimeException("Decryption error");
        }
    }
}
