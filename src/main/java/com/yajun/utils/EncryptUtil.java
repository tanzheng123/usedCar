package com.yajun.utils;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.yajun.config.Constants;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;

public class EncryptUtil {
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String HmacMD5 = "HmacMD5";
    public static final String HmacSHA1 = "HmacSHA1";
    public static final String DES = "DES";
    public static final String AES = "AES";

    /**编码格式；默认使用uft-8*/
    public String charset = "utf-8";
    /**DES*/
    public int keysizeDES = 0;
    /**AES*/
    public int keysizeAES = 128;

    public static EncryptUtil me;

    private EncryptUtil(){
        //单例
    }
    //双重锁
    public static EncryptUtil getInstance(){
        if (me==null) {
            synchronized (EncryptUtil.class) {
                if(me == null){
                    me = new EncryptUtil();
                }
            }
        }
        return me;
    }


    /**
     * 使用KeyGenerator进行单向/双向加密（可设密码）
     * @param res 被加密的原文
     * @param algorithm  加密使用的算法名称
     * @param key 加密使用的秘钥
     * @return
     */
    private String keyGeneratorMac(String res,String algorithm,String key){
        try {
            SecretKey sk = null;
            if (key==null) {
                KeyGenerator kg = KeyGenerator.getInstance(algorithm);
                sk = kg.generateKey();
            }else {
                byte[] keyBytes = charset==null?key.getBytes():key.getBytes(charset);
                sk = new SecretKeySpec(keyBytes, algorithm);
            }
            Mac mac = Mac.getInstance(algorithm);
            mac.init(sk);
            byte[] result = mac.doFinal(res.getBytes());
            return base64(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用KeyGenerator双向加密，DES/AES，注意这里转化为字符串的时候是将2进制转为16进制格式的字符串，不是直接转，因为会出错
     * @param res 加密的原文
     * @param algorithm 加密使用的算法名称
     * @param key  加密的秘钥
     * @param keysize
     * @param isEncode
     * @return
     */
    private String keyGeneratorES(String res,String algorithm,String key,int keysize,boolean isEncode){
        try {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            if (keysize == 0) {
                byte[] keyBytes = charset==null?key.getBytes():key.getBytes(charset);
                kg.init(new SecureRandom(keyBytes));
            }else if (key==null) {
                kg.init(keysize);
            }else {
                byte[] keyBytes = charset==null?key.getBytes():key.getBytes(charset);
                kg.init(keysize, new SecureRandom(keyBytes));
            }
            SecretKey sk = kg.generateKey();
            SecretKeySpec sks = new SecretKeySpec(sk.getEncoded(), algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            if (isEncode) {
                cipher.init(Cipher.ENCRYPT_MODE, sks);
                byte[] resBytes = charset==null?res.getBytes():res.getBytes(charset);
                return parseByte2HexStr(cipher.doFinal(resBytes));
            }else {
                cipher.init(Cipher.DECRYPT_MODE, sks);
                return new String(cipher.doFinal(parseHexStr2Byte(res)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String base64(byte[] res){
        return Base64.encode(res);
    }

    /**将二进制转换成16进制 */
    public static String parseByte2HexStr(byte buf[]) {
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
    /**将16进制转换为二进制*/
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 使用AES加密算法经行加密（可逆）
     * @param res 需要加密的密文
     * @param key 秘钥
     * @return
     */
    public String AESencode(String res, String key) {
        return keyGeneratorES(res, AES, key, keysizeAES, true);
    }

    /**
     * 对使用AES加密算法的密文进行解密
     * @param res 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String AESdecode(String res, String key) {
        return keyGeneratorES(res, AES, key, keysizeAES, false);
    }

    /**
     * 使用异或进行加密
     * @param res 需要加密的密文
     * @param key 秘钥
     * @return
     */
    public String XORencode(String res, String key) {
        byte[] bs = res.getBytes();
        for (int i = 0; i < bs.length; i++) {
            bs[i] = (byte) ((bs[i]) ^ key.hashCode());
        }
        return parseByte2HexStr(bs);
    }

    /**
     * 使用异或进行解密
     * @param res 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String XORdecode(String res, String key) {
        byte[] bs = parseHexStr2Byte(res);
        for (int i = 0; i < bs.length; i++) {
            bs[i] = (byte) ((bs[i]) ^ key.hashCode());
        }
        return new String(bs);
    }

    /**
     * 直接使用异或（第一调用加密，第二次调用解密）
     * @param res 密文
     * @param key 秘钥
     * @return
     */
    public int XOR(int res, String key) {
        return res ^ key.hashCode();
    }

    /**
     * 使用Base64进行加密
     * @param res 密文
     * @return
     */
    public String Base64Encode(String res) {
        return Base64.encode(res.getBytes());
    }

    /**
     * 使用Base64进行解密
     * @param res
     * @return
     */
    public String Base64Decode(String res) {
        return new String(Base64.decode(res));
    }

    /**
     * Id加密
     * @description
     *
     * @author Chenzhipeng
     * @createDate 2015年12月18日
     * @param id 需要加密的Id
     * @param action 加密action标识
     * @param encryptionKey 加密Key
     * @return
     */
    public static String addSign(long id, String action, String encryptionKey) {
        EncryptUtil instance = EncryptUtil.getInstance();
        String sign = instance.AESencode(id + "," + action, encryptionKey);
        return sign;
    }

    /**
     * Id解密
     * @description
     *
     * @author Chenzhipeng
     * @createDate 2015年12月18日
     * @param sign 密文
     * @param action 加密action标识
     * @param encryptionKey 加密Key
     * @return
     */
    public static Result decodeSign(String sign, String action, String encryptionKey) {

        /* 判断密文是否为空 */
        if(StringUtils.isBlank(sign)) {
            return Result.error(CodeMsg.REQUEST_INVALID);
        }
        EncryptUtil instance = EncryptUtil.getInstance();
        String value = instance.AESdecode(sign, encryptionKey);
        String[] decryArray = value.split(",");
        if(decryArray.length != 2) {
            return Result.error(CodeMsg.REQUEST_INVALID);
        }

        if(!decryArray[1].equals(action)) {
            return Result.error(CodeMsg.REQUEST_INVALID);
        }
        if(!isNumericInt(decryArray[0])) {
            return Result.error(CodeMsg.REQUEST_INVALID);
        }
        return Result.success(decryArray[0]);
    }

    /**
     * 是否整数(^[+-]?(([1-9]{1}\\d*)|([0]{1}))$)
     *
     * @param str
     * @return
     *
     * @author huangyunsong
     * @createDate 2015年12月8日
     */
    public static boolean isNumericInt(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("(^[+-]?([0-9]|([1-9][0-9]*))$)");
    }

    public static void main(String[] args) {
        String sign = EncryptUtil.addSign(1, Constants.CAR_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        System.out.println(sign);
        Result result = EncryptUtil.decodeSign(sign, Constants.CAR_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        System.out.println(result.getData());

    }
}
