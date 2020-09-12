//package com.example.gecco.service;
//
//import com.alibaba.excel.EasyExcelFactory;
//import com.alibaba.fastjson.JSON;
//import com.example.gecco.constant.Constant;
//import com.example.gecco.entity.ContactPersonInfo;
//import com.example.gecco.vo.PersonInfoVO;
//import com.geccocrawler.gecco.pipeline.Pipeline;
//import com.geccocrawler.gecco.spider.SpiderBean;
//import com.google.common.collect.Lists;
//import org.apache.http.client.utils.DateUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.Instant;
//import java.util.Date;
//import java.util.List;
//
//@Service("consolePipeline")
//public class ConsolePipeline implements Pipeline<SpiderBean> {
//    @Value("${out_path}")
//    private String path;
//    @Override
//    public void process(SpiderBean spiderBean) {
//        System.out.println(">>>>>>>spiderBean>>>>>>>>>>>>"+ JSON.toJSONString(spiderBean));
//        export(JSON.toJSONString(spiderBean));
//    }
//    void export(String json){
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(path+ DateUtils.formatDate(new Date(), "yyyyMMddHHmmss")+ Constant.FILE_SUFFIX_XLSX);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            int a = 1 / 0;
//        }
//        ContactPersonInfo personInfo = JSON.parseObject(json, ContactPersonInfo.class);
//            String name = personInfo.getName();
//            String company = personInfo.getCompany();
//            String location = personInfo.getLocation();
//            String position = personInfo.getPosition();
//            String entryTime = personInfo.getEntryTime();
//            String content = personInfo.getContent();
//
//            String[] names = name.split("\\n");
//            String[] companys = company.split("\\n");
//            String[] locations = location.split("\\n");
//            String[] positions = position.split("\\n");
//            String[] entryTimes = entryTime.split("\\n");
//            String[] contents = content.split("\\n");
//
//            List<PersonInfoVO> list = Lists.newArrayList();
//            for (int i = 0; i < names.length; i++) {
//                PersonInfoVO personInfoVO = new PersonInfoVO();
//                personInfoVO.setName(names[i]);
//                personInfoVO.setCompany(companys[i]);
//                personInfoVO.setPosition(positions[i]);
//                personInfoVO.setEntryTime(entryTimes[i]);
//                personInfoVO.setLocation(locations[i]);
//                personInfoVO.setContent(contents[i]);
//                list.add(personInfoVO);
//            }
//            EasyExcelFactory.write(out, PersonInfoVO.class).sheet("联系人").doWrite(list);
//        try {
//            if (out!=null){
//                out.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            int a = 1 / 0;
//        }
//    }
//}
