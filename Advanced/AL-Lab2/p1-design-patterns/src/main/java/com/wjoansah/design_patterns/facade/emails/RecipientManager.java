package com.wjoansah.design_patterns.facade.emails;

import java.util.ArrayList;
import java.util.List;

public class RecipientManager {
    private final List<String> toRecipients = new ArrayList<>();
    private final List<String> ccRecipients = new ArrayList<>();
    private final List<String> bccRecipients = new ArrayList<>();

    public void addToRecipient(String email) {
        toRecipients.add(email);
        System.out.println("Added TO recipient: " + email);
    }

    public void addCcRecipient(String email) {
        ccRecipients.add(email);
        System.out.println("Added CC recipient: " + email);
    }

    public void addBccRecipient(String email) {
        bccRecipients.add(email);
        System.out.println("Added BCC recipient: " + email);
    }

    public List<String> getToRecipients() {
        return toRecipients;
    }

    public List<String> getCcRecipients() {
        return ccRecipients;
    }

    public List<String> getBccRecipients() {
        return bccRecipients;
    }
}
