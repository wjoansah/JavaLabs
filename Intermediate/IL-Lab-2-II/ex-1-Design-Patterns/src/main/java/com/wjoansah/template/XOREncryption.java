package com.wjoansah.template;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class XOREncryption extends DataEncryptionTemplate {
    @Override
    protected Key generateSecretKey(String key) throws Exception {
        return new SecretKeySpec(key.getBytes(), "XOR");
    }

    @Override
    protected String encrypt(Object data, Key key) throws Exception {
        char[] keyArr = new String(key.getEncoded()).toCharArray();
        char[] dataArr = data.toString().toCharArray();
        char[] result = new char[dataArr.length];

        for (int i = 0; i < dataArr.length; i++) {
            result[i] = (char) (dataArr[i] ^ keyArr[i % keyArr.length]);
        }
        return new String(result);
    }

    @Override
    protected Object decrypt(String data, Key key) throws Exception {
        // XOR is symmetric, so encryption and decryption are the same
        return encrypt(data, key);
    }
}
