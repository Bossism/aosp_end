package com.example.aosp_end.bean;

import java.util.Date;

public class Version {
    private Long id;
    private String commit_id;
    private String message;
    private String author;
    private String author_email;
    private Date commit_date;

    public Version(String message, Date commit_date) {
        this.message = message;
        this.commit_date = commit_date;
    }

    public Version(Long id, String commit_id, String message, String author, String author_email, Date commit_date) {
        this.id = id;
        this.commit_id = commit_id;
        this.message = message;
        this.author = author;
        this.author_email = author_email;
        this.commit_date = commit_date;
    }

    public Long getId() {
        return id;
    }

    public String getCommit_id() {
        return commit_id;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public Date getCommit_date() {
        return commit_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCommit_id(String commit_id) {
        this.commit_id = commit_id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public void setCommit_date(Date commit_date) {
        this.commit_date = commit_date;
    }

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", commit_id='" + commit_id + '\'' +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", author_email='" + author_email + '\'' +
                ", commit_date=" + commit_date +
                '}';
    }
}
