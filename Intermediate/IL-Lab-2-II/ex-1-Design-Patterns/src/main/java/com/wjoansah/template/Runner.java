package com.wjoansah.template;

public class Runner {
    public static void main(String[] args) {
//        var encryption = new AESEncryption();
        DataEncryptionTemplate encryption = new XOREncryption();
//        var secret = "9a5ab7f2e8583597d0be7b23ff41b054";
        var secret = "very-secret";

        var plainText = "the quick brown fox jumps over the lazy dog";
        System.out.println("plain text: " + plainText);
        try {
            var encryptedText = encryption.encryptData(plainText, secret);
            System.out.println("encrypted text: " + encryptedText);
            var decryptedText = encryption.decryptData(encryptedText, secret);
            System.out.println("decrypted text: " + decryptedText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
