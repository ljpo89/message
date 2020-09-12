package com.example.gecco.entity;

import java.util.List;

public class PhonebookInfoDO {
    private String topic_id;
    private String phonebook_id;
    private String user_id;
    private long created_at;
    private int event;
    private int isTop;
    private int sort;
    private PhonebookInfoParam params;
    private int hits;
    private List<PhonebookInfoPraises> praises;
    private List<PhonebookInfoComments> comments;
    private List<PhonebookInfoAppraisals> appraisals;
    private PhonebookInfoUser user;
    private Phonebook phonebook;
    private boolean isEssence;

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getPhonebook_id() {
        return phonebook_id;
    }

    public void setPhonebook_id(String phonebook_id) {
        this.phonebook_id = phonebook_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public PhonebookInfoParam getParams() {
        return params;
    }

    public void setParams(PhonebookInfoParam params) {
        this.params = params;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public List<PhonebookInfoPraises> getPraises() {
        return praises;
    }

    public void setPraises(List<PhonebookInfoPraises> praises) {
        this.praises = praises;
    }

    public List<PhonebookInfoComments> getComments() {
        return comments;
    }

    public void setComments(List<PhonebookInfoComments> comments) {
        this.comments = comments;
    }

    public List<PhonebookInfoAppraisals> getAppraisals() {
        return appraisals;
    }

    public void setAppraisals(List<PhonebookInfoAppraisals> appraisals) {
        this.appraisals = appraisals;
    }

    public PhonebookInfoUser getUser() {
        return user;
    }

    public void setUser(PhonebookInfoUser user) {
        this.user = user;
    }

    public Phonebook getPhonebook() {
        return phonebook;
    }

    public void setPhonebook(Phonebook phonebook) {
        this.phonebook = phonebook;
    }

    public boolean isEssence() {
        return isEssence;
    }

    public void setEssence(boolean essence) {
        isEssence = essence;
    }
}
