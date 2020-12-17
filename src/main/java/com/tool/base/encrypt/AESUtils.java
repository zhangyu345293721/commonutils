package com.tool.base.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;


/**
 * AES加解密
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AESUtils {
    private AESUtils() {
    }

    /**
     * 默认秘钥
     */
    protected static final String KEY = "NOPO3nzMD3dndwS0MccuMeXCHgVlGOoYyFwLdS24Im2e7YyhB0wrUsyYf0";

    /**
     * AES解密
     *
     * @param encryptValue 待解密内容
     * @param key          秘钥
     * @return 返回字符串
     * @throws Exception
     */
    protected static String decrypt(String encryptValue, String key) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptValue), key);
    }

    /**
     * AES加密
     *
     * @param value 待加密内容
     * @param key   秘钥
     * @return 返回字符串
     * @throws Exception
     */
    protected static String encrypt(String value, String key) throws Exception {
        return base64Encode(aesEncryptToBytes(value, key));
    }

    /**
     * 将比特数组变成64编码
     *
     * @param bytes 比特数组变成base64编码
     * @return 字符串
     */
    private static String base64Encode(byte[] bytes) {
        return Base64Utils.encrypt(bytes);
    }

    /**
     * 将base64解码
     *
     * @param base64Code
     * @return 比特数组
     * @throws Exception 异常处理
     */
    private static byte[] base64Decode(String base64Code) throws Exception {
        return base64Code == null ? null : Base64Utils.decrypt(base64Code);
    }

    /**
     * 将内容进行加密
     *
     * @param content    内容信息
     * @param encryptKey 加密关键字
     * @return 比特数组
     * @throws Exception 抛出异常
     */
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * 将加密内容进行解密
     *
     * @param encryptBytes 加密字节
     * @param decryptKey   解密关键字
     * @return 解密内容
     * @throws Exception 抛出异常
     */
    private static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

}
