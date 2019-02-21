package com.sjs.mental.common.util;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class RequestUtil {

    public static Map<String,Object> transRequestMapFull(Map<String,String[]> requestMap){
        Map<String,Object> resultMap = new HashMap<>();
        for(Object keyObject : requestMap.keySet()){
            String key = (String)keyObject;
            String[] values = requestMap.get(key);
            if( values.length< 1){
                resultMap.put(key,"");
            }else if(values.length == 1) {
                resultMap.put(key,values[0]);
            }else{
                resultMap.put(key,values);
            }
        }
        return resultMap;
    }

    public static Map<String,String> transRequestMap(Map<String,String[]> requestMap){
        Map<String,String> resultMap = new HashMap<>();
        for(Object keyObject : requestMap.keySet()){
            String key = (String)keyObject;
            String[] values = requestMap.get(key);
            if( values.length< 1){
                resultMap.put(key,"");
            }else if(values.length >= 1) {
                resultMap.put(key,values[0]);
            }
        }
        return resultMap;
    }

    public static String getFullPath(ServletRequest request){
        String contextPath = request.getServletContext().getContextPath();
        return  request.getScheme() + "://" +request.getServerName() +":"+request.getServerPort() + contextPath;
    }


}
