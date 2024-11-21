package com.wjoansah.design_patterns.facade.emails;

public class Application {
    public static void main(String[] args) {
        EmailFacade emailFacade = new EmailFacade();

        // Compose email
        emailFacade.composeEmail("Meeting Reminder", "This is a reminder for the team meeting tomorrow at 10 AM.");

        // Add recipients
        emailFacade.addRecipient("alice@example.com", "TO");
        emailFacade.addRecipient("bob@example.com", "CC");
        emailFacade.addRecipient("eve@example.com", "BCC");

        // Add attachments
        emailFacade.addAttachment("/path/to/agenda.pdf");
        emailFacade.addAttachment("/path/to/meeting_notes.docx");

        // Send email
        emailFacade.sendEmail();
    }
}