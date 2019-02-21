package com.sjs.mental.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;


/**
 * 加密工具
 */
public class SecurityUtil {

    public static final String AES_IV = "0102030405060708";
    private static final String HEX_NUMS_STR="0123456789ABCDEF";

    //SHA加密算法不可逆,类似MD5,比MD5更可靠
    public static String encAsSHA(String input) throws Exception {
        try{
            MessageDigest sha = MessageDigest.getInstance("SHA");
            byte[] byteArray = input.getBytes("UTF-8");
            byte[] shaBytes = sha.digest(byteArray);
            return  byte2HexStr(shaBytes);
        }catch (Exception e){
            throw e;
        }
    }

    public static String encAsMD5(String password) throws Exception{
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] byteArray = password.getBytes(Charset.forName("UTF-8"));
            byte[] bytes1 = md5.digest(byteArray);
            return byte2HexStr(bytes1);
        }catch (Exception e){
            throw e;
        }
    }

    public static String encAsMD5Salt(String password) throws Exception{
        try{
            String salt =String.valueOf(10000000 + new Random().nextInt(89999999)) +String.valueOf(10000000 + new Random().nextInt(89999999));
            String passwordAndSalt = password+salt;
            password  = encAsMD5(passwordAndSalt);
            char[] cs = new char[48];
            for (int i = 0; i < 48; i += 3) {
                cs[i] = password.charAt(i / 3 * 2);
                char c = salt.charAt(i / 3);
                cs[i + 1] = c;
                cs[i + 2] = password.charAt(i / 3 * 2 + 1);
            }
            return new String(cs);
        }catch (Exception e){
            throw e;
        }
    }

    private static String byte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] hexStr2Byte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4
                    | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
        }
        return result;
    }

    public static boolean verifyMD5Salt(String originPassword, String md5SaltPassword) throws Exception{
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5SaltPassword.charAt(i);
            cs1[i / 3 * 2 + 1] = md5SaltPassword.charAt(i + 2);
            cs2[i / 3] = md5SaltPassword.charAt(i + 1);
        }
        String salt = new String(cs2);
        return encAsMD5(originPassword + salt).equals(new String(cs1));
    }

    public static void main(String[] args) throws Exception{
        String plaintext = "admin";
        System.out.println("原始：" + plaintext);
        System.out.println("普通MD5后：" + encAsMD5(plaintext));
        String ciphertext = encAsMD5Salt(plaintext);
        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("是否是同一字符串:" + verifyMD5Salt(plaintext, ciphertext));
    }

}
