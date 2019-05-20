package main.java;

import main.java.KeyGenerator.KeyGenerator;
import main.java.RSA.RSA;
import main.java.euklideszi.*;
import main.java.kinai.Kinai;

import java.math.BigInteger;


public class Main {

    public static void main(String[] args) {

        RSA rsa = new RSA();
        KeyGenerator key = new KeyGenerator();
        BigInteger[] adatok = key.keyGenerator();
        BigInteger p = adatok[0];
        BigInteger q = adatok[1];
        BigInteger e = adatok[2];
        BigInteger d = adatok[3];

        BigInteger message = BigInteger.valueOf(123456789);
        BigInteger encrypted = rsa.EnCrypt(message, e, p, q);

        BigInteger decrypted=rsa.DeCrypt(p,q,encrypted,d);
        System.out.print("Encrypted:\n"+encrypted+"\nDecrypted:\n"+decrypted);


    }
}
