package com.example.gecco.param;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class ExportParam {
    private String address;
    private String phonebookId;
    private long offset;
    private int count;
    private int beginPage;
    private int endPage;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonebookId() {
        return phonebookId;
    }

    public void setPhonebookId(String phonebookId) {
        this.phonebookId = phonebookId;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public static void main(String[] args) {
        int day=2;
        Date date0 = new Date();
        Date date = DateUtils.addDays(new Date(), -day);
        System.out.println(new Date().getTime());
        System.out.println(DateUtils.addDays(new Date(), -day).getTime());
    }
}
