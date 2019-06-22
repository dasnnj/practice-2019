package com.dasnnj.practice.readfile;

import com.alibaba.fastjson.JSONObject;
import com.dasnnj.practice.readfile.entity.ReqQuoteEntity;
import com.dasnnj.practice.readfile.vo.AnnoyMarketDataSnapshotFullRefreshEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description <P> DO : 读取日志文件，根据正则匹配获取特定格式的字符串 <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019 -06-04 16:13
 */
public class ReadLogAndGetRequired {
    private static ReadFile rf = new ReadFile();
    /**
     * The Count.
     */
    private int count;
    /**
     * The Regex.
     */
    private String regex = "(send message to Bond:) (.*\"type\":\"1\".*)";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ReadLogAndGetRequired rlar = new ReadLogAndGetRequired();
        long start = System.currentTimeMillis();
        ReadFile r = new ReadFile();
        //请求回复查询过滤
        String regexSpec = "(receive JSON data:)(.*\"queryType\" ?: ?\"47\".*\"quoteType\" ?: ?\"112\".*)";
        List<String> list = r.readLogFile("C:\\Users\\dasnnj\\Desktop\\ftpApplication-first.log");
        for (String s : list) {
            rlar.getRequired(rlar.regMatch(s, regexSpec));
        }

    }
    /**
     * Description <p> TODO: 根据quoteReqId查询所有的请求报价</p>
     * 这个查询不到部分成交的，因为不分成交不传回来quoteReqId
     * @return java.util.Set<com.dasnnj.practice.readfile.entity.ReqQuoteEntity>
     *
     * @author dasnnj
     * @date 2019-06-05 16:03
     */
    Map<String,ReqQuoteEntity> getLogWithQuoteId() {
        Map<String,ReqQuoteEntity> map = new LinkedHashMap<>();
        List<String> list = rf.readLogFile("C:\\Users\\dasnnj\\Desktop\\ftpApplication-second.log");
        String json;
        //请求报价过滤
//        String regexSpec = "(send message to Bond:) (.*\"quoteReqID\":.*\"quoteType\":\"112\".*)";//"type":"[^1^3-5^18-27]".*
        //请求回复过滤
        String regexSpec = "(send message to Bond:) (.*\"quoteType\":\"113\".*)";


        for (String line : list) {
            json = getRequired(regMatch(line, regexSpec));
            if(json!=null) {
                ReqQuoteEntity r = JSONObject.parseObject(json, ReqQuoteEntity.class);
                if(r!=null){
                    //请求恢复
                    map.put(r.getQuoteID(),r);
                    //请求报价
//                    map.put(r.getQuoteReqID(),r);
                }
            }
        }
        return map;
    }
    List<AnnoyMarketDataSnapshotFullRefreshEntity> getLogWithQuoteId2() {
        List<AnnoyMarketDataSnapshotFullRefreshEntity> lists = new ArrayList<>();
        List<String> list = rf.readLogFile("C:\\Users\\dasnnj\\Desktop\\14-15点集中匹配行情.txt");
        String json;//请求报价过滤
        //        String regexSpec = "(send message to Bond:) (.*\"quoteReqID\":.*\"quoteType\":\"112\".*\"type\":\"[^1^3-5^18-27]\")";
//        String regexSpec = "(send message to Bond:) (.*\"quoteReqID\":.*\"quoteType\":\"113\".*)";
        String regexSpec = "(send message to Bond:) (.*\"type\":\"54\".*)";

        for (String line : list) {
            json = getRequired(regMatch(line, regexSpec));
            AnnoyMarketDataSnapshotFullRefreshEntity r = JSONObject.parseObject(json, AnnoyMarketDataSnapshotFullRefreshEntity.class);
            lists.add(r);
        }
        return lists;
    }

    /**
     * Reg match.
     *
     * @param content the content
     *
     * @return the matcher
     */
    Matcher regMatch(String content) {
        return regMatch(content, regex);
    }

    Matcher regMatch(String content, String regexOpt) {
        Pattern p = Pattern.compile(regexOpt);
        return p.matcher(content);
    }

    /**
     * Gets required.
     *
     * @param m the m
     */
    String getRequired(Matcher m) {
        if (m.find()) {
            count++;
            System.out.println(m.group(2));
            return m.group(2);

        }
        return null;
        //        else {
        //            System.out.println("NO MATCH");
        //        }
    }


    /**
     * Gets regex.
     *
     * @return the regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * Sets regex.
     *
     * @param regex the regex
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

}
