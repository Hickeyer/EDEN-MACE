package com.stylefeng.guns.core.util;


import org.apache.tomcat.util.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @author 作者 zj:
 * @version 创建时间：2019年5月27日 下午4:51:46
 *
 * DES加密介绍
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现。
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 *
 */
public class DESUtil {

    private final static String DES = "DES";
    private final static String KEY = "zj.des.test";

    public DESUtil() {
    }

    public static String encrypt(String pliantext) throws Exception {
        return encodeBase64(encryptDES(pliantext,KEY));
    }

    public static String encrypt(String pliantext,String key) throws Exception {
        return encodeBase64(encryptDES(pliantext,key));
    }

    public  static String decrypt(String ciphertext) throws Exception{
        return decryptDES(decodeBase64(ciphertext.getBytes()),KEY);
    }
    public static String decrypt(String ciphertext, String key) throws Exception {
    	//log.debug("DESUtil: decrypt:"+ciphertext);
        return decryptDES(decodeBase64(ciphertext.getBytes()), key);
    }

    /**
     *  base64编码
     * @param binaryData
     * @return
     * @throws Exception
     */
    private static String encodeBase64(byte[] binaryData)throws Exception{
        try{
            return Base64.encodeBase64String(binaryData);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("BASE64编码失败!");
        }
    }

    /**
     * Base64解码
     * @param binaryData
     * @return
     */
    private static byte[] decodeBase64(byte[] binaryData){
        try {
            return Base64.decodeBase64(binaryData);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("BASE64解码失败！");
        }
    }

    public static byte[] encryptDES(String data, String key){

        try {
            // 生成一个可信任的随机数源 ,  SHA1PRNG: 仅指定算法名称
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec deskey = new DESKeySpec(key.getBytes("UTF-8"));

            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secretKey = keyFactory.generateSecret(deskey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(DES);
            //用密匙初始化Cipher对象,
            cipher.init(Cipher.ENCRYPT_MODE,secretKey,random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(data.getBytes("UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDES(byte[] data ,String key){

        try {
            // 算法要求有一个可信任的随机数源,  SHA1PRNG: 仅指定算法名称
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            // 创建一个DESKeySpec对象
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(DES);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE,secretKey,random);
            // 真正开始解密操作
            return new String(cipher.doFinal(data),"UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String enString = encrypt("{\"pageEntity\":{\"pageSize\":\"20\",\"pageIndex\":\"0\"},\"instance\":{\"status\":\"7\"}}");
        System.out.println("加密后的字串是：" + enString);

        String deString = "PDeZXeKrQuzroGjUgCVYfVjxYh12HI+UD/gAtaC4Hic/R8HeQfhh0taF+r0Yx9TwoK5gjYDFVH9USl1hz6MKKVzWUwKkEMmC60HwTHeP7LMnUcUU0ZGyTgomRMFSrAiCIU9qj8dewtHDaa4S7ZxdP+GCrYVeo+s4XUT/f3+NQtMI7mgP6aNa6YjQbk5BgDpCOFNZ8/o5hh0fyGNUkPUJwMYWshUp3N8p59jhUnk2EPY6VRSeCuX+aBXenuYQSPgTrwXWCWJ1d6vYd/XH4MUeNaXfgfkXB2MyqhVG4k9c6tnw5avW2HO6LHJUvyOBffgVuJjPMUXFxvY6VRSeCuX+aFod3in0QnQTQr/yJW2j4/sTsIkcQz0FIXzQrxmwKXAMunhFh9zM1SkssOh012q66C1Bi/J7NyRvn52LkSq9MNyCw3104RSLwROwiRxDPQUhzUGRNWU7bPhk6VC9Mz+mC8pgyI44QMH5wdaSXLCpOu53qMa49i0605THxK2Myov/H8hjVJD1CcBFbd8LbS07vLBGbLGT+O9kU7pGMAmpVQxCgwh2sdYndv8CiWdikZ/RX6Sz6MsIsPpk2QDk9dt5mLi/TEKCEE2SHDZWu9c9iPwvE0XY6k9UYri/TEKCEE2S5hm0qJ2fLnBHo/kWKmKkUHqSXj9yqlqIGpONhO4wNsTAss6dqlvxAIUHw10lev2I";
        System.out.println("解密后的字串是：" + decrypt(deString));

    }


}