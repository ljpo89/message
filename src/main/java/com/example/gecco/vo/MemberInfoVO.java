package com.example.gecco.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;

/**
 * https://v2.qun.hk/v1/phonebook/members?id=ou9xfvridhug&page=1
 */
@HeadRowHeight(value = 30)
@HeadStyle(fillForegroundColor = 57)
@ContentFontStyle(fontName="宋体",fontHeightInPoints=12)
@ContentStyle(wrapped = true)
public class MemberInfoVO {
    /**
     * 姓名
     */
    @ColumnWidth(value = 18)
    @ExcelProperty(value = "姓名",index = 0)
    private String name;
    /**
     * 号码
     */
    @ColumnWidth(value = 16)
    @ExcelProperty(value = "号码",index = 1)
    private String phone;
    /**
     * 公司
     */
    @ColumnWidth(value = 36)
    @ExcelProperty(value = "公司",index = 2)
    private String company;
    /**
     * 职位
     */
    @ColumnWidth(value = 20)
    @ExcelProperty(value = "职位",index = 3)
    private String position;
    /**
     * 来源
     */
    @ColumnWidth(value = 32)
    @ExcelProperty(value = "来源",index = 4)
    private String source;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
