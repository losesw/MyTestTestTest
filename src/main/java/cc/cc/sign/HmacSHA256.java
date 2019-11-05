package cc.cc.sign;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

/**
 * @Class HmacSHA256
 * @Description
 * @Author 张超超
 * @Date 2019/4/3 14:52
 */
public class HmacSHA256 {
    public static final String PRIVATE_KEY = "";


    public static void main(String[] args) {
        HmacSHA256 hmacSHA256 = new HmacSHA256();
        String message = "nonce=1554346119&id=1&size=10";

        //create encrypted id
//        message = "b639040f284bb888df194084145255a03ETH";
        message = "b639040f284bb888df194084145255a003ETH";
        String id = hmacSHA256.getSHA256(message);

//        message = "nonce=1554346119&id="+id+"&user_id=3&chain=ETH";
        message = "nonce=1554355906&id="+id+"user_id=3&chain=ETH&currency=ETH&txtype=0&to_address=0x85a89b95f9b388f5910aee586ac1125bc4cfa0d8&memo=test&amount=0.1";
//        message = "nonce=1554346119&size=10";
//        hmacSHA256.encryt1(message);
        hmacSHA256.encryt2(message);

        String a = "[{\"UsrCustId\":\"6000060315856776\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"03000322708\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"81020190408211907942971385\",\"TransAmt\":\"1000000.00\",\"PnrSeqId\":\"0022983249\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"BASEDT\"},{\"UsrCustId\":\"6000060315749777\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"333501000012013019026\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"81020190408211815445721679\",\"TransAmt\":\"1000000.00\",\"PnrSeqId\":\"0022983240\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"BASEDT\"},{\"UsrCustId\":\"6000060315749580\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"03002997958\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"81020190408211716876864843\",\"TransAmt\":\"1000000.00\",\"PnrSeqId\":\"0022983233\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"BASEDT\"},{\"UsrCustId\":\"6000060314053244\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060314053244\",\"CardId\":\"6217002190005557831\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"8022019040819555953913883\",\"TransAmt\":\"256.91\",\"PnrSeqId\":\"0022982953\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"MDT000001\"},{\"UsrCustId\":\"6000060313932056\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"6212261407001514427\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"80220190408190541511328339\",\"TransAmt\":\"30142.02\",\"PnrSeqId\":\"0022982758\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"MDT000001\"},{\"UsrCustId\":\"6000060314048019\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"6228480078163365873\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"80220190408181456986875800\",\"TransAmt\":\"40.00\",\"PnrSeqId\":\"0022982452\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"MDT000001\"},{\"UsrCustId\":\"6000060314007786\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060314007786\",\"CardId\":\"6225885712045335\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"80220190408173114239601080\",\"TransAmt\":\"50000.00\",\"PnrSeqId\":\"0022981987\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"MDT000001\"},{\"UsrCustId\":\"6000060313882984\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"6214991540016507\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"80220190408171824959673146\",\"TransAmt\":\"286.71\",\"PnrSeqId\":\"0022981912\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"MDT000001\"},{\"UsrCustId\":\"6000060313893883\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"6228480322970248512\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"80220190408170859364113634\",\"TransAmt\":\"597.00\",\"PnrSeqId\":\"0022981850\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"MDT000001\"},{\"UsrCustId\":\"6000060313954184\",\"MerCustId\":\"6000060313554632\",\"FeeCustId\":\"6000060313554632\",\"CardId\":\"6217580600002915584\",\"ServFee\":\"\",\"PnrDate\":\"20190408\",\"ServFeeAcctId\":\"\",\"OrdId\":\"80220190408170319059083131\",\"TransAmt\":\"40.00\",\"PnrSeqId\":\"0022981805\",\"FeeAmt\":\"2.00\",\"TransStat\":\"S\",\"FeeAcctId\":\"MDT000001\"}]";

        System.out.println(a);

    }

    public void encryt1(String message) {
        System.out.println("------------------------->");
        String secret;
        try {
//            secret = MD5Encrypt.getMessageDigest(PRIVATE_KEY);
            secret = "cead2ac4310ea867880d892ad8d2d73a5d7884cb5da0517e98b21dce591314d6";
            System.out.println(" secret : " + secret);
            String str = sha256_HMAC(message, secret);
            System.out.println(" getSignature : " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void encryt2(String message) {
        System.out.println("------------------------->");
        try {
            String secret = "cead2ac4310ea867880d892ad8d2d73a5d7884cb5da0517e98b21dce591314d6";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes()));
            System.out.println("hash --> " + hash);
//            String encrypted = byte2Hex(sha256_HMAC.doFinal(message.getBytes()));
//            System.out.println("encrypted --> " + encrypted);
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    /**
     * 利用java原生的类实现SHA256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256(String str){
        System.out.println("------------------------->");
        MessageDigest messageDigest;
        String encodestr = "";
        String hashstr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bytes = messageDigest.digest();
            encodestr = byte2Hex(bytes);
            System.out.println("sha256 --> " + encodestr);
//            hashstr = Base64.encodeBase64String(bytes);
//            System.out.println("sha256 base64 --> " + hashstr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    private static String byte2Hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

    /**
     * sha256_HMAC加密
     *
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    private static String sha256_HMAC(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byte2Hex(bytes);
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }
}
