package com.sven.dream.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期处理工具。
 * 
 * @author yingchao.zyc
 */ 
public class DateUtil{ 
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
    /**
     * 格式化制定的date
     * 
     * @param date
     * @return
     */
    public static String formateDate(Date date) {
        if (date == null) {
            return "";
        }

        return DATE_FORMAT.format(date);
    }

    /**
     * 格式化制定的datetime
     * 
     * @param date
     * @return
     */
    public static String formateDatetime(Date date) {
        if (date == null) {
            return "";
        }

        return DATETIME_FORMAT.format(date);
    }
 
}
