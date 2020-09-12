package com.example.gecco.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;

@HeadRowHeight(value = 30)
@HeadStyle(fillForegroundColor = 57)
@ContentFontStyle(fontName="宋体",fontHeightInPoints=12)
@ContentStyle(wrapped = true)
public class PersonInfoVO {
    /**
     * 姓名
     */
    @ColumnWidth(value = 18)
    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    /**
     * 公司
     */
    @ColumnWidth(value = 26)
    @ExcelProperty(value = "公司",index = 1)
    private String company;
    /**
     * 职务
     */
    @ColumnWidth(value = 18)
    @ExcelProperty(value = "职务",index = 2)
    private String position;
    /**
     * 位置
     */
    @ColumnWidth(value = 8)
    @ExcelProperty(value = "位置",index = 3)
    private String location;
    /**
     * 活跃时间
     */
    @ColumnWidth(value = 12)
    @ExcelProperty(value = "活跃时间",index = 4)
    private String entryTime;
    /**
     * 内容
     */
    @ColumnWidth(value = 54)
    @ExcelProperty(value = "内容",index = 5)
    private String content;
    /**
     * 手机
     */
    @ColumnWidth(value = 12)
    @ExcelProperty(value = "手机",index = 6)
    private String phone;
    /**
     * 标题
     */
    @ColumnWidth(value = 36)
    @ExcelProperty(value = "标题",index = 7)
    private String title;
    /**
     * 昵称
     */
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "昵称",index = 8)
    private String nickname;
    /**
     * 来源
     */
    @ColumnWidth(value = 32)
    @ExcelProperty(value = "来源",index = 9)
    private String source;
    /**
     * 时间
     */
    @ColumnWidth(value = 12)
    @ExcelProperty(value = "时间",index = 10)
    private long createdAt;
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonInfoVO that = (PersonInfoVO) o;

        if (!name.equals(that.name)) return false;
        if (!company.equals(that.company)) return false;
        if (!position.equals(that.position)) return false;
        if (!entryTime.equals(that.entryTime)) return false;
        if (!phone.equals(that.phone)) return false;
        return source.equals(that.source);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + entryTime.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + source.hashCode();
        return result;
    }
}
