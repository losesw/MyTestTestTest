/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.sign;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @Class AESKeyGenerate
 * @Description
 * @Author 张超超
 * @Date 2018/4/10 18:48
 */
public class AESKeyGenerator {

    private static String KEY_ALGORITHM_AES = "AES";

    private static String AES_PADDING_SCHEME = "AES/ECB/PKCS7Padding";


    /**
     * 创建Key
     * @return
     */
    private String createKey() throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM_AES);
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();
        String keyStr = new BASE64Encoder().encode(keyBytes);
        System.out.println("----------------------------->");
        System.out.println(keyStr);
        System.out.println("<-----------------------------");
        return keyStr;
    }

    /**
     * 加密
     * @param text
     *          原始文本
     * @param key
     *          key
     * @return
     * @throws Exception
     */
    private String encrypt(String text, String key) throws Exception {
        byte[] keyBytes = new BASE64Decoder().decodeBuffer(key);
        Security.addProvider(new BouncyCastleProvider());
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, KEY_ALGORITHM_AES);

        Cipher cipher = Cipher.getInstance(AES_PADDING_SCHEME, BouncyCastleProvider.PROVIDER_NAME);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        String encryptData = new BASE64Encoder().encode(cipher.doFinal(text.getBytes("UTF-8")));
//        System.out.println(encryptData);
        return encryptData;
    }

    /**
     *
     * @param text
     *          加密后文本
     * @param key
     *          key
     * @return
     * @throws Exception
     */
    private String decrypt(String text, String key) throws Exception {
        byte[] keyBytes = new BASE64Decoder().decodeBuffer(key);
        Security.addProvider(new BouncyCastleProvider());
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, KEY_ALGORITHM_AES);

        Cipher cipher = Cipher.getInstance(AES_PADDING_SCHEME, BouncyCastleProvider.PROVIDER_NAME);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        String decryptData = new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(text)), "UTF-8");
        return decryptData;
    }


    public static void main(String[] args) throws Exception{
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        String key = aesKeyGenerator.createKey();



        String text = "测试数据";

        String encryptData = aesKeyGenerator.encrypt(text, key);

        String decryptData = aesKeyGenerator.decrypt(encryptData, key);


    }
}
