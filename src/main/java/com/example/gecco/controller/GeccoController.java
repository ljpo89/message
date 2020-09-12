package com.example.gecco.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.fastjson.JSON;
import com.example.gecco.entity.MemberInfo;
import com.example.gecco.entity.MemberInfoDO;
import com.example.gecco.entity.PhonebookInfoDO;
import com.example.gecco.enums.SourceEnum;
import com.example.gecco.param.ExportParam;
import com.example.gecco.vo.MemberInfoVO;
import com.example.gecco.vo.PersonInfoVO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Controller
public class GeccoController {
    @Value("${file_name}")
    private String name;
    @Value("${phonebook_list_url}")
    private String phonebookListUrl;
    @Value("${message_url}")
    private String messageUrl;

    @RequestMapping(value = "/gotoMessage")
    public String gotoMessage(@ModelAttribute ExportParam param){
        return "message";
    }
    @RequestMapping(value = "/gotoMember")
    public String gotoMember(@ModelAttribute ExportParam param){
        return "member";
    }
    @RequestMapping(value = "/gotoMessageList")
    public String gotoMessageList(@ModelAttribute ExportParam param){
        return "messageList";
    }
    /**
     * 导出
     */
    @RequestMapping(value = "/exportMessage")
    public void export(@ModelAttribute ExportParam param, HttpServletRequest request, HttpServletResponse response){
        System.out.println(">>>>>>>>>>>>>param>>>>>>>"+ JSON.toJSONString(param));
        String address = param.getAddress();
        long offset = param.getOffset();
        String phonebookId = param.getPhonebookId();
        int next=0;
        List<PersonInfoVO> personInfoVOList = new ArrayList();
        while (next==0){
            Map<String,Object> map = new HashMap();
            map.put("phonebook_id",phonebookId);
            map.put("offset",offset);
            RestTemplate restTemplate = new RestTemplate();
            Map object = restTemplate.getForObject(address+"?phonebook_id={phonebook_id}&page=1&offset={offset}", Map.class,map);
            List<PhonebookInfoDO> list = (List) object.get("list");

            long created_at;
            for (Object phonebookInfoDO : list) {
                PhonebookInfoDO phonebookInfo = JSON.parseObject(JSON.toJSONString(phonebookInfoDO), PhonebookInfoDO.class);
                PersonInfoVO personInfoVO = new PersonInfoVO();
                personInfoVO.setName(phonebookInfo.getUser().getRealname());
                personInfoVO.setNickname(phonebookInfo.getUser().getNickname());
                personInfoVO.setCompany(phonebookInfo.getUser().getCompany());
                personInfoVO.setPosition(phonebookInfo.getUser().getPosition());
                personInfoVO.setLocation(phonebookInfo.getUser().getCityname());
                personInfoVO.setPhone(phonebookInfo.getUser().getPhone());
                personInfoVO.setContent(phonebookInfo.getParams().getText());
                created_at = phonebookInfo.getCreated_at();
                personInfoVO.setCreatedAt(created_at);
                offset = created_at;
                personInfoVO.setEntryTime(DateFormatUtils.format(created_at*1000,"yyyy/MM/dd"));
                personInfoVO.setTitle(phonebookInfo.getUser().getTitle());
                personInfoVO.setSource(phonebookInfo.getPhonebook().getTitle());
                personInfoVOList.add(personInfoVO);
            }
            next = (int)object.get("next");
        }
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            String fileName = name+DateFormatUtils.format(new Date().getTime(), "yyyyMMddHHmmss");
//            response.setContentType("multipart/form-data");
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
            EasyExcelFactory.write(out, PersonInfoVO.class).sheet("联系人").doWrite(personInfoVOList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/exportMember")
    public void exportMember(@ModelAttribute ExportParam param, HttpServletRequest request, HttpServletResponse response){
        System.out.println(">>>>>>>>>>>>>param>>>>>>>"+ JSON.toJSONString(param));
        String address = param.getAddress();
        String phonebookId = param.getPhonebookId();
        String source = getNameByPhonebookId(phonebookId);
        int next=1;
        int beginPage = param.getBeginPage();
        int endPage = param.getEndPage();
        if (beginPage>0){
            next=beginPage;
        }
        List<MemberInfoVO> memberInfoVOList = new ArrayList();
        while (next>0){
            Map<String,Object> map = new HashMap();
            map.put("id",phonebookId);
            map.put("next",next);
            RestTemplate restTemplate = new RestTemplate();
            MemberInfoDO memberInfoDO = restTemplate.getForObject(address+"?id={id}&page={next}", MemberInfoDO.class,map);
            List<MemberInfo> list = memberInfoDO.getList();

            for (MemberInfo memberInfo : list) {
                MemberInfoVO memberInfoVO = new MemberInfoVO();
                memberInfoVO.setName(memberInfo.getCard().getRealname());
                memberInfoVO.setCompany(memberInfo.getCard().getCompany());
                memberInfoVO.setPosition(memberInfo.getCard().getPosition());
                memberInfoVO.setPhone(memberInfo.getCard().getPhone());
                memberInfoVO.setSource(source);
                memberInfoVOList.add(memberInfoVO);
            }
            next = memberInfoDO.getNext();
            if (endPage > 0 && endPage < next){
                next=-1;
                break;
            }
        }
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            String fileName = name+DateFormatUtils.format(new Date().getTime(), "yyyyMMddHHmmss");
//            response.setContentType("multipart/form-data");
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
            EasyExcelFactory.write(out, MemberInfoVO.class).sheet("联系人").doWrite(memberInfoVOList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getNameByPhonebookId(String phonebookId) {
        String source;
        switch (phonebookId){
            case "ou9xfvridhug":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "e94502cab5f3":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "888e140e0686":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "294c322dad4f":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "9d7d76a1ad00":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "72921ba716b8":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "fd5fa867d762":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "b9934e9a472e":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "c7q4jdt1e8av":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "edc8e27efa6e":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "d0c3ba24313b":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "09cfefb85e20":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "4al4vir8yg7m":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "3c8190d6522b":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "7dc1e9959f60":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "a4ddae9a2368":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "723561066b08":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "f9f5871c699c":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "09bb2e652d65":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "ze0mtiunw041":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "77c71a84e5d1":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "rp1lm9fw5z39":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "e5b8ccee48c9":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "6889f5110ca9":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "04d261f00641":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "fa160fd00be9":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "41a6d6367b02":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "4eacf5aeb1c7":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "4cc07f22461f":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "49494e705582":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "d8d82346de11":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "6f73183220b3":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "4e310198610d":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "qqdrn6i1u5nn":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "a9b351d62261":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "fa3bwk3o5qef":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "9d0c9f6bb9fa":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "0251a3c86533":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "hrrlie08yahb":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "18dd5c97625e":
                source = SourceEnum.getNameById(phonebookId);
                break;
            case "df324ea87f77":
                source = SourceEnum.getNameById(phonebookId);
                break;
            default:
                source="";
        }
        return source;
    }

    @RequestMapping(value = "/exportAllMessage")
    public void exportAllMessage(@ModelAttribute ExportParam param, HttpServletRequest request, HttpServletResponse response){
        System.out.println(">>>>>>>>>>>>>param>>>>>>>"+ JSON.toJSONString(param));
        String phonebookId = param.getPhonebookId();
        List<String> collect = new ArrayList<>();
        if (phonebookId.contains("#")){
            String[] split = phonebookId.split("#");
            collect.addAll(Arrays.asList(split));
        }else {
            collect.add(phonebookId);
        }
        String address = param.getAddress();
        if (StringUtils.isEmpty(address)){
            address = messageUrl;
        }
        int day = param.getCount();
        List<PersonInfoVO> personInfoVOList = new ArrayList();
        Set<PersonInfoVO> set = new LinkedHashSet();

        for (int i = 0; i < collect.size(); i++) {
            long offset = param.getOffset();
            int next=0;
            String phonebook = collect.get(i);
            while (next==0){
                Map<String,Object> map = new HashMap();
                map.put("phonebook_id",phonebook);
                map.put("offset",offset);
                System.out.println(">>>>>>>>>>>>>offset>>>>>>>"+offset);
                RestTemplate restTemplate = new RestTemplate();
                Map object = restTemplate.getForObject(address+"?phonebook_id={phonebook_id}&page=1&offset={offset}", Map.class,map);
                List<PhonebookInfoDO> list = (List) object.get("list");

                long created_at;
                for (int j = 0; j < list.size(); j++) {
                    PhonebookInfoDO phonebookInfo = JSON.parseObject(JSON.toJSONString(list.get(j)), PhonebookInfoDO.class);
                    PersonInfoVO personInfoVO = new PersonInfoVO();
                    personInfoVO.setName(phonebookInfo.getUser().getRealname());
                    personInfoVO.setNickname(phonebookInfo.getUser().getNickname());
                    personInfoVO.setCompany(phonebookInfo.getUser().getCompany());
                    personInfoVO.setPosition(phonebookInfo.getUser().getPosition());
                    personInfoVO.setLocation(phonebookInfo.getUser().getCityname());
                    personInfoVO.setPhone(phonebookInfo.getUser().getPhone());
                    personInfoVO.setContent(phonebookInfo.getParams().getText());

                    personInfoVO.setTitle(phonebookInfo.getUser().getTitle());
                    personInfoVO.setSource(phonebookInfo.getPhonebook().getTitle());
                    if (phonebookInfo.getIsTop()!=1){
                        created_at = phonebookInfo.getCreated_at();
                        personInfoVO.setCreatedAt(created_at);
                        offset = created_at;
                        personInfoVO.setEntryTime(DateFormatUtils.format((long) created_at*1000,"yyyy/MM/dd"));
                        if (org.apache.commons.lang3.time.DateUtils.addDays(new Date(), -day).getTime()/1000-created_at>0){
                            next=-1;
                            break;
                        }
                        set.add(personInfoVO);
                    }else {
                        created_at = phonebookInfo.getCreated_at();
                        if (j==9){
                            offset = created_at;
                        }
                        personInfoVO.setEntryTime(DateFormatUtils.format((long) created_at*1000,"yyyy/MM/dd"));
                        personInfoVO.setName(phonebookInfo.getUser().getRealname()+"（置顶）");
                        set.add(personInfoVO);
                    }
                }
                if (CollectionUtils.isEmpty(list)){
                    next=-1;
                }
            }
        }
        personInfoVOList.addAll(set);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            String fileName = name+DateFormatUtils.format(new Date().getTime(), "yyyyMMddHHmmss");
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
            EasyExcelFactory.write(out, PersonInfoVO.class).sheet("联系人").doWrite(personInfoVOList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
