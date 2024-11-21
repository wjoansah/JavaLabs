package com.wjoansah.design_patterns.facade.emails;

public class EmailComposer {
    private String subject;
    private String body;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void composeEmail(String subject, String body) {
        setSubject(subject);
        setBody(body);
        System.out.println("Email composed with subject: " + subject);
    }
}