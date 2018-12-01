package br.com.topseed.criptografia.exemplo2;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAIII {

	public void EncryptaDecrypta() {
		
        Element modulusElem = root.getChild("Modulus");
        Element exponentElem = root.getChild("Exponent");

        byte[] expBytes = decoder.decodeBuffer(exponentElem.getText().trim());
        byte[] modBytes = decoder.decodeBuffer(modulusElem.getText().trim());

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(1, modBytes), new BigInteger(1, expBytes));
        KeyFactory fact = KeyFactory.getInstance("RSA");
        //PublicKey pubKey = fact.generatePublic(keySpec);
        
        
        byte[] expBytes = Base64.decodeBase64(exponentElem.getText().trim()));
        byte[] modBytes = Base64.decodeBase64(modulusElem.getText().trim());
        byte[] dBytes = Base64.decodeBase64(dElem.getText().trim());

        BigInteger modules = new BigInteger(1, modBytes);
        BigInteger exponent = new BigInteger(1, expBytes);
        BigInteger d = new BigInteger(1, dBytes);

        KeyFactory factory = KeyFactory.getInstance("RSA");
        Cipher cipher = Cipher.getInstance("RSA");
        String input = "test";

        RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(modules, exponent);
        PublicKey pubKey = factory.generatePublic(pubSpec);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] encrypted = cipher.doFinal(input.getBytes("UTF-8"));
        System.out.println("encrypted: " + new String(encrypted));

        RSAPrivateKeySpec privSpec = new RSAPrivateKeySpec(modules, d);
        PrivateKey privKey = factory.generatePrivate(privSpec);
        cipher.init(Cipher.DECRYPT_MODE, privKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("decrypted: " + new String(decrypted));
        
        
        
//        RSAPrivateKeySpec privSpec = new RSAPrivateCrtKeySpec(iModulus,iExponentBytes,iDBytes,iPBytes,iQBytes,iDPBytes,iDQBytes,iInverseQBytes)
	}
}
