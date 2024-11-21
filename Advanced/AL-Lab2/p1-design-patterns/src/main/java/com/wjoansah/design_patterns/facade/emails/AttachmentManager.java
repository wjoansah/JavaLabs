package com.wjoansah.design_patterns.facade.emails;

import java.util.ArrayList;
import java.util.List;

public class AttachmentManager {
    private final List<String> attachments = new ArrayList<>();

    public void addAttachment(String filePath) {
        attachments.add(filePath);
        System.out.println("Attachment added: " + filePath);
    }

    public List<String> getAttachments() {
        return attachments;
    }
}
