package com.sjs.mental.common.util;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.UUID;

/**
 * ID生成策略
 */
public class IDUtil {

    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);

    private static final NumberFormat numberFormat = new DecimalFormat("000");

    private static int seq = 0;

    private static int end = 999;

    public static synchronized String id() {
        StringBuffer timeStr = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        numberFormat.format(seq, timeStr, HELPER_POSITION);
        if (seq == end) {
            seq = 0;
        } else {
            seq++;
        }
        return timeStr.toString();
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
