package com.example.gecco.entity;

public class MemberInfo {
    private String member_id;
    private String phonebook_id;
    private String user_id;
    private int join_at;
    private int is_admin;
    private int credit;
    private int hide;
    private int viewable;
    private int friendable;
    private String[] columns;
    private String card_id;
    private int share_count;
    private int invite_count;
    private CardInfo card;
    private String provide;
    private String service;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
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

    public int getJoin_at() {
        return join_at;
    }

    public void setJoin_at(int join_at) {
        this.join_at = join_at;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getViewable() {
        return viewable;
    }

    public void setViewable(int viewable) {
        this.viewable = viewable;
    }

    public int getFriendable() {
        return friendable;
    }

    public void setFriendable(int friendable) {
        this.friendable = friendable;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public int getInvite_count() {
        return invite_count;
    }

    public void setInvite_count(int invite_count) {
        this.invite_count = invite_count;
    }

    public CardInfo getCard() {
        return card;
    }

    public void setCard(CardInfo card) {
        this.card = card;
    }

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
