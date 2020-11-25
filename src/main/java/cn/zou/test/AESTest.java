package main.java.cn.zou.test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class AESTest {

    public static void main(String[] args) throws Exception {
        System.out.println(encrypt2Str("test123", "test"));
    }

    private static byte[] encrypt(String content, String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(byteContent);
        return result;
    }

    public static String encrypt2Str(String content, String password) throws Exception {
        byte[] encryptResult = encrypt(content, password);
        System.out.println(Arrays.toString(encryptResult));
        System.out.println(com.sun.org.apache.xml.internal.security.utils.Base64.encode(encryptResult));
        //System.out.println(com.sun.xml.internal.messaging.saaj.util.Base64.encode(encryptResult)); error
        System.out.println(com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(encryptResult));
        return com.sun.org.apache.xml.internal.security.utils.Base64.encode(encryptResult);
    }
}
