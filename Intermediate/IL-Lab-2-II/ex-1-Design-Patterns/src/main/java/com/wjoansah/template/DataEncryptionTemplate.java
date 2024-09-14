package com.wjoansah.template;

import java.security.Key;

public abstract class DataEncryptionTemplate {
    protected abstract Key generateSecretKey(String key) throws Exception;

    protected abstract String encrypt(Object data, Key key) throws Exception;

    protected abstract Object decrypt(String data, Key key) throws Exception;

    public final String encryptData(Object data, String secret) throws Exception {
        Key secretKey = generateSecretKey(secret);
        return encrypt(data, secretKey);
    }

    public final Object decryptData(String data, String secret) throws Exception {
        Key secretKey = generateSecretKey(secret);
        return decrypt(data, secretKey);
    }
}
