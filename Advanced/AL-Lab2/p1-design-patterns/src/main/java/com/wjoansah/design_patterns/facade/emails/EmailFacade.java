package com.wjoansah.design_patterns.facade.emails;

public class EmailFacade {
    private final EmailComposer composer;
    private final AttachmentManager attachmentManager;
    private final RecipientManager recipientManager;
    private final EmailSender sender;

    public EmailFacade() {
        this.composer = new EmailComposer();
        this.attachmentManager = new AttachmentManager();
        this.recipientManager = new RecipientManager();
        this.sender = new EmailSender();
    }

    public void composeEmail(String subject, String body) {
        composer.composeEmail(subject, body);
    }

    public void addRecipient(String email, String type) {
        switch (type.toUpperCase()) {
            case "TO":
                recipientManager.addToRecipient(email);
                break;
            case "CC":
                recipientManager.addCcRecipient(email);
                break;
            case "BCC":
                recipientManager.addBccRecipient(email);
                break;
            default:
                System.out.println("Invalid recipient type: " + type);
        }
    }

    public void addAttachment(String filePath) {
        attachmentManager.addAttachment(filePath);
    }

    public void sendEmail() {
        sender.sendEmail(
                composer.getSubject(),
                composer.getBody(),
                recipientManager.getToRecipients(),
                recipientManager.getCcRecipients(),
                recipientManager.getBccRecipients(),
                attachmentManager.getAttachments()
        );
    }
}
