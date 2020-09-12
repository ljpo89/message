package com.example.gecco.entity;

import java.util.List;

public class MemberInfoDO {
    private List<MemberInfo> list;
    private int next;

    public List<MemberInfo> getList() {
        return list;
    }

    public void setList(List<MemberInfo> list) {
        this.list = list;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
