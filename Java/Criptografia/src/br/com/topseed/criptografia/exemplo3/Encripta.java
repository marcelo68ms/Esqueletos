package br.com.topseed.criptografia.exemplo3;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encripta {
	public static void main(String[] args) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			byte[] mensagem = "minha mensagem original".getBytes();

			// Usando chave de 128-bits (16 bytes)
			byte[] chave = "chave de 16bytes".getBytes();
			System.out.println("Tamanho da chave: " + chave.length);

			// Encriptando...
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
			byte[] encrypted = cipher.doFinal(mensagem);

			// Decriptando...
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
			byte[] decrypted = cipher.doFinal(encrypted);

			System.out.println(new String(decrypted));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
