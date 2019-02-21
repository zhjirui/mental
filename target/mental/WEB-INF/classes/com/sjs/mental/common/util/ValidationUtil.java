package com.sjs.mental.common.util;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证
 */
public class ValidationUtil {

    private static Validator validator;

    private static Validator getValidator(){
        if(validator == null){
            validator =  Validation.buildDefaultValidatorFactory().getValidator();
        }
        return validator;
    }

    public static List<String> idsToList(String ids){
        List<String> rList = new ArrayList<>();
        if(!ValidationUtil.isEmptyOrNull(ids)){
            String[] idArr = ids.split(",");
            for(String id :idArr){
                rList.add(id);
            }
        }
        return rList;
    }


    public static boolean isEmptyOrNull(Object object){
        return object==null || "".equals(object);
    }

    public static boolean isIdentityNumber(String idNum) {
        if(idNum ==null || idNum.length() !=18){
            return false;
        }
        // 系数列表
        int[] ratioArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 校验码列表
        char[] checkCodeList = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        // 获取身份证号字符数组
        char[] cIds = idNum.toCharArray();
        // 获取最后一位（身份证校验码）
        char oCode = cIds[17];
        int[] iIds = new int[17];
        int idSum = 0;// 身份证号第1-17位与系数之积的和
        int residue = 0;// 余数(用加出来和除以11，看余数是多少？)
        for (int i = 0; i < 17; i++) {
            iIds[i] = cIds[i] - '0';
            idSum += iIds[i] * ratioArr[i];
        }
        residue = idSum % 11;// 取得余数
        return Character.toUpperCase(oCode) == checkCodeList[residue];
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18 0-9
     * 17+除9的任意数
     * 147
     */
    public static boolean isMobileNO(String mobile) {
        if(ValidationUtil.isEmptyOrNull(mobile)){
            return false;
        }
        String regExp = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    //验证对象
    public static <T> void validateEntity(T obj) throws Exception{
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<T>> set = getValidator().validate(obj,Default.class);
        if(!CollectionUtils.isEmpty(set)){
            result.setHasErrors(true);
            Map<String,String> errorMsg = new HashMap<String,String>();
            for(ConstraintViolation<T> cv : set){
                errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        if(result.isHasErrors()){
            throw new RuntimeException(result.toString());
        }
    }

    //验证字段
    public static <T> ValidationResult validateProperty(T obj,String propertyName){
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<T>> set = getValidator().validateProperty(obj, propertyName, Default.class);
        if(!CollectionUtils.isEmpty(set)){
            result.setHasErrors(true);
            Map<String,String> errorMsg = new HashMap<String,String>();
            for(ConstraintViolation<T> cv : set){
                errorMsg.put(propertyName, cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        return result;
    }

}
