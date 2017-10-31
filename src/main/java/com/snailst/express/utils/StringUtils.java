package com.snailst.express.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuzhongpei
 * @date 2017/10/31 20:32
 * @description
 * @since 1.0
 */
public final class StringUtils extends org.apache.commons.lang.StringUtils{

    /**
     * 解析地址，划分出省/市县/区镇/街道
     * @param address
     * @return
     */
    public static String[] decodeAddress(String address){
        address = address.replaceAll("\\s+", "").replaceAll(",", "");
        // 缓存原地址
        String oldAddress = address;
        String[] addresses = new String[5];
        // 匹配省或自治区的正则表达式
        String provinceRegex = "(^.*?省)|^(内蒙古|新疆|广西|宁夏|西藏)";
        // 匹配市或直辖市的正则表达式
        String cityRegex = "^((北京市|北京)|(上海市|上海)|(天津市|天津)|(重庆市|重庆))|^(.*?(市|自治州))";
        // 匹配县的正则表达式
        String countyRegex = "^.*?县";
        // 匹配县级市正则表达式
        String countyCityRegex = "^.*?市";
        // 匹配区/镇/乡的正则表达式
        String townRegex = "^.*?(区|镇|乡)";
        // 省
        Matcher provinceMatcher = Pattern.compile(provinceRegex).matcher(address);
        while (provinceMatcher.find()){
            String province = provinceMatcher.group();
            addresses[0] = province;
        }
        address = address.replaceAll(provinceRegex, "");
        // 市
        Matcher cityMatcher = Pattern.compile(cityRegex).matcher(address);
        while (cityMatcher.find()){
            String city = cityMatcher.group();
            addresses[1] = city;
        }
        address = address.replaceAll(cityRegex, "");
        // 县
        Matcher countyMatcher = Pattern.compile(countyRegex).matcher(address);
        while (countyMatcher.find()){
            String county = countyMatcher.group();
            addresses[2] = county;
        }
        // 县级市
        Matcher countyCityMatcher = Pattern.compile(countyCityRegex).matcher(address);
        if(StringUtils.isBlank(addresses[2]) && countyCityMatcher.find()){
            String countyCity = countyCityMatcher.group();
            if(countyCity.length() < 5) addresses[2] = countyCity;
            if(StringUtils.isNotBlank(addresses[2])) address = address.replace(addresses[2], "");
        }
        address = address.replaceAll(countyRegex, "");
        // 区镇乡
        Matcher townMatcher = Pattern.compile(townRegex).matcher(address);
        while (townMatcher.find()){
            String town = townMatcher.group();
            if(town.length() < 6) addresses[3] = town;
            else addresses[3] = "";
        }
        address = address.replaceAll(townRegex, "");
        // 街道
        addresses[4] = address;

        return addresses;
    }

    public static void main(String[] args){
//        String address = "山东省单县龙王庙镇朱杨楼村127号";
//        String address = "天津河西区澧水道红霞菜市场小胖子烧鸡店";
//        String address = "上海市闵行区虹桥镇虹井路280号2楼虹桥晶座大厦三楼316室";
//        String address = "广西梧州市万秀区太和冲太和卫生室";
//        String address = "沈阳市和平区胜利南街馨丽康城小区1号楼";
//        String address = "福建省泉州南安市省新镇南金工业区倾醉天下";
//        String address = "浙江温州市苍南县宜山镇水门村朝南屋路48号";
//        String address = "内蒙古呼和浩特市土默特左旗铁帽乡双号村";
//        String address = "北京市朝阳区常营民族家园73号3单元302";
//        String address = "江西省抚州市东乡县孝岗镇解放街花园巷84号";
//        String address = "福建省,泉州市,晋江市,东石镇福建省晋江巿东石镇塔头刘西区38号";
//        String address = "山东省青岛市开发区衡山路十号第五城市3号楼1606";
//        String address = "广东省,梅州市,兴宁市,宁中镇竹一下新村,";
        String address = "广东省广州市增城区石滩镇三江市场对面农商银行宿舍楼";
        for(String a : decodeAddress(address)){
            System.out.println(a);
        }
//        System.out.println(getAreaCode(decodeAddress(address)));
    }
}
