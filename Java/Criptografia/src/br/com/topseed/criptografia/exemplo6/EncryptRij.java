package br.com.topseed.criptografia.exemplo6;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

public class EncryptRij {
	
    public static void main(String[] args) throws Exception {
    	String text = "teste";
    	final byte[] keyBytes = "12345678ABCDEFGHHGFEDCBA".getBytes();
    	byte[] codedtext = new EncryptRij().encrypt(text, keyBytes);
    	String decodedtext = new EncryptRij().decrypt(codedtext, keyBytes);
    	System.out.println(new BASE64Encoder().encode(codedtext)); // this is a byte array, you'll just see a reference to an array
    	System.out.println(decodedtext); // This correctly shows "kyle boon"
    }
    public byte[] encrypt(String message, byte[] chave) throws Exception {
    	//final MessageDigest md = MessageDigest.getInstance("md5"); //MD5, MD2, SHA, SHA-1, SHA-256, SHA-384 e SHA-512
    	//final byte[] digestOfPassword = md.digest("2012UNIMED24BOTUCATU0941".getBytes("utf-8"));
    	//final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    	/*for (int j = 0, k = 16; j < 8;) {
    		keyBytes[k++] = keyBytes[j++];
    	}*/
    	final SecretKey key = new SecretKeySpec(chave, "DESede");
    	//final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    	final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    	cipher.init(Cipher.ENCRYPT_MODE, key);
    	final byte[] plainTextBytes = message.getBytes("utf-8");
    	final byte[] cipherText = cipher.doFinal(plainTextBytes);
    	// final String encodedCipherText = new sun.misc.BASE64Encoder()
    	// .encode(cipherText);
    	return cipherText;
    }
    public String decrypt(byte[] message, byte[] chave) throws Exception {
    	//final MessageDigest md = MessageDigest.getInstance("md5");
    	/*final byte[] digestOfPassword = md.digest("2012UNIMED24BOTUCATU0941".getBytes("utf-8"));
    	final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    	for (int j = 0, k = 16; j < 8;) {
    		keyBytes[k++] = keyBytes[j++];
    	}*/
    	final SecretKey key = new SecretKeySpec(chave, "DESede");
    	//final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    	final Cipher decipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
    	decipher.init(Cipher.DECRYPT_MODE, key);
    	// final byte[] encData = new
    	// sun.misc.BASE64Decoder().decodeBuffer(message);
    	final byte[] plainText = decipher.doFinal(message);
    	return new String(plainText, "UTF-8");
    }
}