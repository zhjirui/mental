package com.sjs.mental.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

/**
 */
public class JSONUtil {

    public static  <T> T jsonToObject(String json,Class<T> c){
        try{
            if(json == null || "".equals(json)){
                throw  new RuntimeException("json string can't be null or empty");
            }else{
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return mapper.readValue(json, c);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param json
     * @param typeReference  new TypeReference<List<Map<String,Test>>>(){}, new TypeReference<Map<String,Test>>(){}
     * @param <T>
     * @return  带泛型的转换
     * @throws Exception
     */
    public static  <T> T jsonToObject(String json,TypeReference typeReference) throws Exception {
        if(json == null || "".equals(json)){
            throw  new RuntimeException("json string can't be null or empty");
        }else{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(json, typeReference);
        }
    }

    /**
     * 一个对象转为另一个对象 比如 Map ->Bean
     * 示例:typeReference = new TypeReference<List<Map<String,Test>>>(){}
     */
    public static Object ObjectToObject(Object origin,TypeReference typeReference) throws Exception{
        String json = objectToJson(origin);
        return  jsonToObject(json,typeReference);
    }

    public static String objectToJson(Object obj){
        if(obj ==null){
            return null;
        }
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            String s =  mapper.writeValueAsString(obj);
            return s;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public static String fileToJson(File file) throws Exception{
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            JsonNode rootNode = mapper.readTree(file);
            return rootNode.toString();
        }catch (Exception e){
            throw e;
        }
    }

}
