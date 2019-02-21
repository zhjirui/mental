package com.sjs.mental.common;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class GlobalConst {

    public static final Integer PAGE_SIZE = 10;

    /*返回参数配置*/
    public static final String RESULT_MSG = "msg";
    public static final String RESULT_CODE = "code";
    public static final String RESULT_DATA = "data";
    public static final String RESULT_TOTAL = "total";

    public static final String SUCCESS_CODE = "1";
    public static final String SUCCESS_MSG = "SUCCESS";
    public static final String FAIL_CODE = "-1";
    public static final String FAIL_MSG = "ERROR";

    /*成功*/
    public static Map<String,Object> successMap(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put(RESULT_CODE,SUCCESS_CODE);
        resultMap.put(RESULT_MSG,SUCCESS_MSG);
        return resultMap;
    }

    public static Map<String,Object> successMap(Object obj){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put(RESULT_CODE,SUCCESS_CODE);
        resultMap.put(RESULT_MSG,SUCCESS_MSG);
        resultMap.put(RESULT_DATA,obj);
        return resultMap;
    }

    //分页查询
    public static Map<String,Object> successMap(Object obj,Integer total){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put(RESULT_CODE,SUCCESS_CODE);
        resultMap.put(RESULT_MSG,SUCCESS_MSG);
        resultMap.put(RESULT_DATA,obj);
        resultMap.put(RESULT_TOTAL,total);
        return resultMap;
    }


    /*失败*/
    public static Map<String,Object> failMap(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put(RESULT_CODE,FAIL_CODE);
        resultMap.put(RESULT_MSG,FAIL_MSG);
        return resultMap;
    }

    /*失败*/
    public static Map<String,Object> failMap(String message){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put(RESULT_CODE,FAIL_CODE);
        resultMap.put(RESULT_MSG,message);
        return resultMap;
    }

    /*通用*/
    public static Map<String,Object> resultMap(String code,String msg,Object object){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put(RESULT_CODE,code);
        resultMap.put(RESULT_MSG,msg);
        resultMap.put(RESULT_DATA,object);
        return resultMap;
    }

}
