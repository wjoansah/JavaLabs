package com.wjoansah.template;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AESEncryption extends DataEncryptionTemplate {
    @Override
    protected Key generateSecretKey(String key) throws Exception {
        return new SecretKeySpec(key.getBytes(), "AES");
    }

    @Override
    protected String encrypt(Object data, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.toString().getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    @Override
    protected Object decrypt(String data, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(data));
        return new String(decryptedData);
    }
}
