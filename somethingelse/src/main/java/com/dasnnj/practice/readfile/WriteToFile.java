package com.dasnnj.practice.readfile;


import com.dasnnj.practice.readfile.entity.ReqQuoteEntity;
import com.dasnnj.practice.readfile.vo.AnnoyMarketDataSnapshotFullRefreshEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description <P> DO :  <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-05 16:23
 */
public class WriteToFile {
    /*public static void main(String[] args) {
        FileOutputStream fileOut = null;
        try {
            String exportFilePath = "/Users/Dreamer-1/Desktop/myBlog/java解析Excel/writeExample.xlsx";
            File exportFile = new File(exportFilePath);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            logger.warning("输出Excel时发生错误，错误原因：" + e.getMessage());
        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
                logger.warning("关闭输出流时发生错误，错误原因：" + e.getMessage());
            }
        }

    }*/

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        WriteToFile w = new WriteToFile();
        //        w.annoyWriteToFile();
        w.requestWriteFile();
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start) + "ms");
    }

    void requestWriteFile() {
        ReadLogAndGetRequired rlar = new ReadLogAndGetRequired();
        Map<String, ReqQuoteEntity> map1 = rlar.getLogWithQuoteId();
       /* Set<ReqQuoteEntity> sets = rlar.getRequest();
        Map<String,String> map = new HashMap<>();
        for (ReqQuoteEntity set : sets) {
            map.put(set.getQuoteReqID(),set.getClOrdID());
        }*/
        FileWriter fileWritter = null;
        try {
            File file = new File("请求回复-second.log");
            if (!file.exists()) {
                file.createNewFile();
            }

            //true = append file
            fileWritter = new FileWriter(file.getName(), true);
            StringBuffer sb = new StringBuffer();
            ReqQuoteEntity o;
            for (String s : map1.keySet()) {
                if ((o = map1.get(s)) == null) {
                    continue;
                }
                //请求回复
                sb = sb.append(o.getQuoteID()).append(",").append(o.getClOrdID() == null ? "" : o.getClOrdID()).append(",").append(o.getQuoteType()).append(",").append(o.getQuoteStatus()).append("\r\n");
                //请求报价
                //                sb = sb.append(o.getQuoteReqID()).append(",").append(o.getClOrdID()==null?"":o.getClOrdID()).append(",
                //                ").append(o.getQuoteType()).append(",")
                //                        .append(o.getQuoteStatus()).append("\r\n");
            }
            fileWritter.write(sb.toString());
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWritter != null) {
                try {
                    fileWritter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    void annoyWriteToFile() {
        ReadLogAndGetRequired rlar = new ReadLogAndGetRequired();
        List<AnnoyMarketDataSnapshotFullRefreshEntity> list = rlar.getLogWithQuoteId2();
       /* Set<ReqQuoteEntity> sets = rlar.getRequest();
        Map<String,String> map = new HashMap<>();
        for (ReqQuoteEntity set : sets) {
            map.put(set.getQuoteReqID(),set.getClOrdID());
        }*/
        FileWriter fileWritter = null;
        try {
            File file = new File("匿名点击-first.log");
            if (!file.exists()) {
                file.createNewFile();
            }

            //true = append file
            fileWritter = new FileWriter(file.getName(), true);
            StringBuffer sb = new StringBuffer();
            List<String> list1 = new ArrayList<>();
            for (AnnoyMarketDataSnapshotFullRefreshEntity o : list) {
                if (o == null) {continue;}
                sb = sb.append(o.getMdReqID()).append(",").append(o.getMdBookType() == null ? "" : o.getSecurityID()).append(",").append(o.getTransactTime()).append(",");

            }
            fileWritter.write(sb.toString());

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWritter != null) {
                try {
                    fileWritter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
