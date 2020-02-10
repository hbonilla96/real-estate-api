package com.real.estate.model;

public class Email {

    private String recipient;
    private String subject;
    private String email;

    public Email(String recipient, String subject, String email) {
        this.recipient = recipient;
        this.subject = subject;
        this.email = email;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

}
