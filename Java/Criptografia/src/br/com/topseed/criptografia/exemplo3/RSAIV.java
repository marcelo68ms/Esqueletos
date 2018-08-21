package br.com.topseed.criptografia.exemplo3;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.util.encoders.Base64;



public class RSAIV {

	public static String Decrypt(String encodedString) throws IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException
	{
	    byte[] modulusBytes = Base64.decode("2rRVVVFJRbH/wAPDtnwZwu+nxU+AZ6uXxh/sW+AMCBogg7vndZsnRiHoLttYYPqOyOhfgaBOQogrIfrKL4lipK4m52SBzw/FfcM9DsKs/rYR83tBLiIAfgdnVjF27tZID+HJMFTiI30mALjr7+tfp+2lIACXA1RIKTk7S9pDmX8=");
	    byte[] exponentBytes = Base64.decode("AQAB");
	    BigInteger modulus = new BigInteger(1, modulusBytes );
	    BigInteger exponent = new BigInteger(1, exponentBytes);

	    RSAPrivateKeySpec rsaPrivKey = new RSAPrivateKeySpec(modulus, exponent);
		KeyFactory fact = KeyFactory.getInstance("RSA");
	    PrivateKey privKey = fact.generatePrivate(rsaPrivKey);

	    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    cipher.init(Cipher.DECRYPT_MODE, privKey);

		byte[] base64String = Base64.decode(encodedString);
	    byte[] plainBytes = new String(base64String).getBytes("UTF-8");
	    byte[] cipherData = cipher.doFinal(plainBytes);

	    System.out.println(cipherData);
	    return cipherData.toString();
	}
	
}
