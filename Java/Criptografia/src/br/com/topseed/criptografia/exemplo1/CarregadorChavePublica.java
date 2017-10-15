package br.com.topseed.criptografia.exemplo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PublicKey;

public class CarregadorChavePublica {
    public PublicKey carregaChavePublica (File fPub) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream (new FileInputStream (fPub));
        PublicKey ret = (PublicKey) ois.readObject();
        ois.close();
        return ret;
    }
}
