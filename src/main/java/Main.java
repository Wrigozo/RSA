package main.java;

import main.java.KeyGenerator.KeyGenerator;
import main.java.RSA.RSA;
import main.java.euklideszi.*;
import main.java.kinai.Kinai;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;


public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Converter converter=new Converter();

        RSA rsa = new RSA();
        KeyGenerator key = new KeyGenerator();
        BigInteger[] adatok = key.keyGenerator();
        BigInteger p = adatok[0];
        BigInteger q = adatok[1];
        BigInteger e = adatok[2];
        BigInteger d = adatok[3];

        String s="almafa" ;
        BigInteger message = converter.convertToBiginteger(s);
        BigInteger encrypted = rsa.EnCrypt(message, e, p, q);
        BigInteger decrypted=rsa.DeCrypt(p,q,encrypted,d);
        String visszafejtett=converter.BigIntegerToString(decrypted);
        System.out.print("Encrypted:\n"+message+"\nDecrypted:\n"+visszafejtett);
        /*
        BigInteger message = BigInteger.valueOf(123456789);
        BigInteger encrypted = rsa.EnCrypt(message, e, p, q);

        BigInteger decrypted=rsa.DeCrypt(p,q,encrypted,d);
        System.out.print("Encrypted:\n"+encrypted+"\nDecrypted:\n"+decrypted);
        */



    }
}
