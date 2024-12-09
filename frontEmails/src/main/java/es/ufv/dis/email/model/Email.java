package es.ufv.dis.email.model;

import java.util.ArrayList;

public class Email {
    private String to;
    private String subject;
    private String text;
    private String html;

    private ArrayList<Attachment> attachments = new ArrayList<>();

    public Email() {
    }

    public Email(ArrayList<Attachment> attachments, String html, String text, String subject, String to) {
        this.attachments = attachments;
        this.html = html;
        this.text = text;
        this.subject = subject;
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", html='" + html + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
