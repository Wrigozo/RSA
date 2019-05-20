package main.java.KeyGenerator;

import java.math.BigInteger;
import java.util.Random;

import main.java.isPrime.*;
import main.java.euklideszi.*;

public class KeyGenerator {

    public BigInteger phiN;
    public BigInteger e;
    public BigInteger n;
    public BigInteger p;
    public BigInteger q;
    public BigInteger d;
    public BigInteger[] tmpd = new BigInteger[2];
    MillerRabin m = new MillerRabin();
    euklidesziAlgoritmus euk = new euklidesziAlgoritmus();


    public BigInteger[] keyGenerator() {
        BigInteger[] adatok = new BigInteger[4];
        p = new BigInteger(1024, 0, new java.util.Random());
        q = new BigInteger(1024, 0, new java.util.Random());

        MillerRabin m = new MillerRabin();

        while (m.MillerRabin(p) != true) {
            p = new BigInteger(1024, new java.util.Random());
        }
        while (m.MillerRabin(q) != true) {
            q = new BigInteger(1024, new java.util.Random());
        }
        n = p.multiply(q);

        System.out.println("A p: " + p + "\nA q: " + q);


        phiN = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        int max = phiN.bitCount();


        do {
            e = new BigInteger(max , new Random());
            System.out.println("legnagyobb ko: " +euk.LKO(phiN, e) );
        }
        while (!euk.LKO(phiN, e).equals(BigInteger.valueOf(1)) || e.equals(p) || e.equals(q));


        tmpd = euk.KiterjesztettEuklidesziAlgoritmus(phiN, e);
        d = tmpd[2];
        if (d.compareTo(BigInteger.ZERO) == -1) {
            d = d.add(phiN);
        }

        adatok[0] = p;
        adatok[1] = q;
        adatok[2] = e;
        adatok[3] = d;

        return adatok;


    }
}