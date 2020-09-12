package com.example.gecco.enums;

import org.springframework.util.StringUtils;

public enum SourceEnum {
    COMPANY1("ou9xfvridhug","顶级投行政府关系政企合作"),
    COMPANY2("e94502cab5f3","德真企业家高端人脉文化战略发展联盟"),
    COMPANY3("888e140e0686","万名董事长实名联谊（金融界）"),
    COMPANY4("294c322dad4f","双创服务联盟"),
    COMPANY5("9d7d76a1ad00","一带一路推进联盟"),
    COMPANY6("72921ba716b8","天下于氏通讯录"),
    COMPANY7("fd5fa867d762","天使投资【咸叔通讯录】"),
    COMPANY8("b9934e9a472e","商协会联盟邀请您免费开通手机微官网"),
    COMPANY9("c7q4jdt1e8av","中国风水国学文化交流中心"),
    COMPANY10("edc8e27efa6e","京津冀一体化推动联盟"),
    COMPANY11("d0c3ba24313b","天使人俱乐部"),
    COMPANY12("09cfefb85e20","【中国金融资本精英人脉俱乐部】"),
    COMPANY13("4al4vir8yg7m","上市公司业务平台"),
    COMPANY14("3c8190d6522b","中国阳光私募基金投资俱乐部（免费加入）"),
    COMPANY15("7dc1e9959f60","一带一路@生态论坛"),
    COMPANY16("a4ddae9a2368","投资人企业家俱乐部"),
    COMPANY17("723561066b08","中国董事长总经理通讯录"),
    COMPANY18("f9f5871c699c","《中国CEO骑士俱乐部》实名通讯录>道统>儒雅>佛性<企业家"),
    COMPANY19("09bb2e652d65","10万投资人企业家共享社区"),
    COMPANY20("ze0mtiunw041","中国雄安.工程朋友圈"),
    COMPANY21("77c71a84e5d1","高端制造产业联盟"),
    COMPANY22("rp1lm9fw5z39","中国政府招商引资联盟"),
    COMPANY23("e5b8ccee48c9","房地产资源互助行业交流"),
    COMPANY24("6889f5110ca9","添宇控股 项目融资对接群"),
    COMPANY25("04d261f00641","顶层大投行·菁英汇•[泛金融本部]"),
    COMPANY26("fa160fd00be9","三长论坛(20年政银企跨界平台)"),
    COMPANY27("41a6d6367b02","政府工作者之家"),
    COMPANY28("4eacf5aeb1c7","金融实业通讯录（实名制）"),
    COMPANY29("4cc07f22461f","全球资产配置Linkedln银行非银行金融机构大资管基金平台"),
    COMPANY30("49494e705582","中国金融俱乐部"),
    COMPANY31("d8d82346de11","大中华区房地产及上市公司百强名企融资Linkedln论坛"),
    COMPANY32("6f73183220b3","中国12万人顶级投行群"),
    COMPANY33("4e310198610d","地方政府、国资央企国有企业、组织部宣传部、党建工作"),
    COMPANY34("qqdrn6i1u5nn","欢迎加入实名制通讯录~交流平台"),
    COMPANY35("a9b351d62261","中华人民共和国商务部【中国国际贸易学会】"),
    COMPANY36("fa3bwk3o5qef","熔喷布.口罩万人防疫物资采购联盟"),
    COMPANY37("9d0c9f6bb9fa","中国(商策联会)品牌通讯录"),
    COMPANY38("0251a3c86533","中国金融投行通讯录(银行+券商+信托＋租赁＋基金＋投资）"),
    COMPANY39("hrrlie08yahb","政企融合平台"),
    COMPANY40("18dd5c97625e","中华全球企业家俱乐部"),
    COMPANY41("df324ea87f77","商业银行业务交流圈"),
    ;
    private String phonebookid;
    private String name;
    SourceEnum(String phonebookid,String name){
        this.phonebookid=phonebookid;
        this.name=name;
    }

    public String getPhonebookid() {
        return phonebookid;
    }

    public String getName() {
        return name;
    }
    public static String getNameById(String phonebookid){
        if (StringUtils.isEmpty(phonebookid)){
            return "";
        }
        for (SourceEnum sourceEnum : SourceEnum.values()) {
            if (sourceEnum.getPhonebookid().equals(phonebookid)){
                return sourceEnum.getName();
            }
        }
        return "";
    }
}
