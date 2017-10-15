package br.com.topseed.criptografia.exemplo1;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Uso da Criptografia RSA e AES
 * 
 * @author marcelo
 *
 */
public class Criptografia {

	public static void main(String[] args) throws Exception {
        //-- Gera o par de chaves, em dois arquivos (chave.publica e chave.privada)
        GeradorParChaves gpc = new GeradorParChaves();
        gpc.geraParChaves (new File ("chave.publica"), new File ("chave.privada"));
        //-- Cifrando a mensagem "Hello, world!"
        byte[] textoClaro = "Hello, world!".getBytes("ISO-8859-1");
        CarregadorChavePublica ccp = new CarregadorChavePublica();
        PublicKey pub = ccp.carregaChavePublica (new File ("chave.publica"));
        Cifrador cf = new Cifrador();
        byte[][] cifrado = cf.cifra (pub, textoClaro);
        printHex (cifrado[0]);
        printHex (cifrado[1]);
        //-- Decifrando a mensagem 
        CarregadorChavePrivada ccpv = new CarregadorChavePrivada();
        PrivateKey pvk = ccpv.carregaChavePrivada (new File ("chave.privada"));
        Decifrador dcf = new Decifrador();
        byte[] decifrado = dcf.decifra (pvk, cifrado[0], cifrado[1]);
        System.out.println (new String (textoClaro, "ISO-8859-1"));
    }
	
	public static void printHex(byte[] b) {
		if (b == null) {
			System.out.println("(null)");
		} else {
			for (int i = 0; i < b.length; ++i) {
				if (i % 16 == 0) {
					System.out.print(Integer.toHexString((i & 0xFFFF) | 0x10000).substring(1, 5) + " - ");
				}
				System.out.print(Integer.toHexString((b[i] & 0xFF) | 0x100).substring(1, 3) + " ");
				if (i % 16 == 15 || i == b.length - 1) {
					int j;
					for (j = 16 - i % 16; j > 1; --j)
						System.out.print("   ");
					System.out.print(" - ");
					int start = (i / 16) * 16;
					int end = (b.length < i + 1) ? b.length : (i + 1);
					for (j = start; j < end; ++j)
						if (b[j] >= 32 && b[j] <= 126)
							System.out.print((char) b[j]);
						else
							System.out.print(".");
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}
