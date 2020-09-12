//package com.example.gecco.entity;
//
//import com.geccocrawler.gecco.annotation.Gecco;
//import com.geccocrawler.gecco.annotation.Html;
//import com.geccocrawler.gecco.annotation.HtmlField;
//import com.geccocrawler.gecco.spider.HtmlBean;
//
//@Gecco(pipelines="consolePipeline")
//public class ContactPersonInfo implements HtmlBean {
//    private static final long serialVersionUID = -435223769545094841L;
//    /**
//     * 姓名
//     */
//    @Html
//    @HtmlField(cssPath=".profile_meta_label")
//    private String name;
//    /**
//     * 公司
//     */
//    @Html
//    @HtmlField(cssPath=".profile_meta_label")
//    private String company;
//    /**
//     * 职务
//     */
//    @Html
//    @HtmlField(cssPath=".profile_meta_label")
//    private String position;
//    /**
//     * 位置
//     */
//    @Html
//    @HtmlField(cssPath=".profile_meta_label")
//    private String location;
//    /**
//     * 入职时间
//     */
//    @Html
//    @HtmlField(cssPath=".profile_meta_label")
//    private String entryTime;
//    /**
//     * 内容
//     */
//    @Html
//    @HtmlField(cssPath=".profile_meta_label")
//    private String content;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getEntryTime() {
//        return entryTime;
//    }
//
//    public void setEntryTime(String entryTime) {
//        this.entryTime = entryTime;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "ContactPersonInfo{" +
//                "name='" + name + '\'' +
//                ", company='" + company + '\'' +
//                ", position='" + position + '\'' +
//                ", location='" + location + '\'' +
//                ", entryTime='" + entryTime + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
//}
