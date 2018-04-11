/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.sign;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Class GenerateKey
 * @Description
 * @Author 张超超
 * @Date 2018/4/10 16:10
 */
@Slf4j
public class RSAKeyGenerator {

    public static String KEY_ALGORITHM = "RSA";

    public static String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

    public static int KEY_SIZE = 1024;

    public static String SIGN_ALGORITHM = "SHA256WithRSA";

    /**
     * 生成公钥
     * @param publicKeyStr
     * @return
     * @throws Exception
     */
    private PublicKey getPublicKey(String publicKeyStr) throws Exception {
        byte[] publicKeyBytes = new BASE64Decoder().decodeBuffer(publicKeyStr);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

    /**
     * 生成私钥
     * @param privateKeyStr
     * @return
     * @throws Exception
     */
    private PrivateKey getPrivateKey(String privateKeyStr) throws Exception {
        byte[] privateKeyBytes = new BASE64Decoder().decodeBuffer(privateKeyStr);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

    /**
     * 创建公钥/私钥对
     * @return 公钥、私钥的字符串集合
     * @throws Exception
     */
    private String[] generateKeyArray() throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);

        KeyPair keyPair = keyPairGenerator.genKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String publicKeyStr = new BASE64Encoder().encode(publicKey.getEncoded());
        String privateKeyStr = new BASE64Encoder().encode(privateKey.getEncoded());

        log.info("-------->");
        log.info("private key");
        System.out.println(publicKeyStr);
        log.info("<--------");
        log.info("-------->");
        log.info("public key");
        System.out.println(privateKeyStr);
        log.info("<--------");

        return new String[]{publicKeyStr, privateKeyStr};
    }

    /**
     * 加密
     * @param publicKey
     * @param str
     * @return
     * @throws Exception
     */
    private String encrypt(PublicKey publicKey, String str) throws Exception{
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptDataBytes = cipher.doFinal(str.getBytes("UTF-8"));
        String encryptData = new BASE64Encoder().encode(encryptDataBytes);
        return encryptData;
    }

    /**
     * 解密
     * @param privateKey
     * @param str
     * @return
     * @throws Exception
     */
    private String decrypt(PrivateKey privateKey, String str) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] strBytes = new BASE64Decoder().decodeBuffer(str);
        String decryptData = new String(cipher.doFinal(strBytes), "UTF-8");
        return decryptData;
    }


    /**
     * 签名
     * @param privateKey
     * @param text
     * @return
     * @throws Exception
     */
    private String sign(PrivateKey privateKey, String text) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(text.getBytes("UTF-8"));
        byte[] signBytes = signature.sign();
        return new BASE64Encoder().encode(signBytes);
    }


    /**
     * 验签
     * @param publicKey
     * @param text
     * @param signStr
     * @return
     * @throws Exception
     */
    private boolean verify(PublicKey publicKey, String text, String signStr) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(text.getBytes("UTF-8"));
        return signature.verify(new BASE64Decoder().decodeBuffer(signStr));
    }



    public static void main(String[] args) throws Exception{

        RSAKeyGenerator gk = new RSAKeyGenerator();

        String[] keyArray = gk.generateKeyArray();

        PublicKey publicKey = gk.getPublicKey(keyArray[0]);

        PrivateKey privateKey = gk.getPrivateKey(keyArray[1]);

        String text = "加密测试！";

//        String encryptData = gk.encrypt(publicKey, text);
//
//        String decryptData = gk.decrypt(privateKey, encryptData);
//
//        log.info(decryptData);

        String signStr = gk.sign(privateKey, text);
        boolean flag = gk.verify(publicKey, text, signStr);
        log.info(flag+"");
    }
}
