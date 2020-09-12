package com.example.gecco.entity;

public class JoinPhoneInfoDO {
    private String phonebook_id;
    private String title;
    private String content;
    private String logo;
    private String last_active;
    private String user_id;
    private int audit_status;

    public String getPhonebook_id() {
        return phonebook_id;
    }

    public void setPhonebook_id(String phonebook_id) {
        this.phonebook_id = phonebook_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLast_active() {
        return last_active;
    }

    public void setLast_active(String last_active) {
        this.last_active = last_active;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(int audit_status) {
        this.audit_status = audit_status;
    }
}
