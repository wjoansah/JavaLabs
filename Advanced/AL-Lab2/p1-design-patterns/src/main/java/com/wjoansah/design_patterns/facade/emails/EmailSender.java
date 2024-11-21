package com.wjoansah.design_patterns.facade.emails;

import java.util.List;

public class EmailSender {
    public void sendEmail(String subject, String body, List<String> toRecipients, List<String> ccRecipients,
                          List<String> bccRecipients, List<String> attachments) {
        System.out.println("Sending email...");
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("To: " + toRecipients);
        System.out.println("CC: " + ccRecipients);
        System.out.println("BCC: " + bccRecipients);
        System.out.println("Attachments: " + attachments);
        System.out.println("Email sent successfully!");
    }
}
