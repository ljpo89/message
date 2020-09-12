package com.example.gecco.entity;

import java.util.List;

public class PhonebookInfoUser {
    private String user_id;
    private String card_id;
    private String realname;
    private String title;
    private String nickname;
    private String company;
    private String position;
    private int citycode;
    private int certified;
    private List permissions;
    private List user_permissions;
    private String phone;
    private String avatar;
    private int vip_member;
    private int connections;
    private int views;
    private int banned;
    private boolean active;
    private boolean is_friend;
    private boolean is_black;
    private boolean is_follow;
    private String cityname;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public int getCertified() {
        return certified;
    }

    public void setCertified(int certified) {
        this.certified = certified;
    }

    public List getPermissions() {
        return permissions;
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }

    public List getUser_permissions() {
        return user_permissions;
    }

    public void setUser_permissions(List user_permissions) {
        this.user_permissions = user_permissions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getVip_member() {
        return vip_member;
    }

    public void setVip_member(int vip_member) {
        this.vip_member = vip_member;
    }

    public int getConnections() {
        return connections;
    }

    public void setConnections(int connections) {
        this.connections = connections;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getBanned() {
        return banned;
    }

    public void setBanned(int banned) {
        this.banned = banned;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isIs_friend() {
        return is_friend;
    }

    public void setIs_friend(boolean is_friend) {
        this.is_friend = is_friend;
    }

    public boolean isIs_black() {
        return is_black;
    }

    public void setIs_black(boolean is_black) {
        this.is_black = is_black;
    }

    public boolean isIs_follow() {
        return is_follow;
    }

    public void setIs_follow(boolean is_follow) {
        this.is_follow = is_follow;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
