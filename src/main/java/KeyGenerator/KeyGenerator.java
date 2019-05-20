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
    public BigInteger[] tmpd=new BigInteger[2];
    MillerRabin m = new MillerRabin();
    euklidesziAlgoritmus euk=new euklidesziAlgoritmus();
    int counterP = 0;
    int counterQ = 0;

    public BigInteger[] keyGenerator() {
        BigInteger[] adatok=new BigInteger[4];
        p = new BigInteger(1024, 0, new java.util.Random());
        q = new BigInteger(1024, 0, new java.util.Random());

        MillerRabin m = new MillerRabin();

        while(m.MillerRabin(p)!=true){
            p = new BigInteger(1024, new java.util.Random());
        }
        while(m.MillerRabin(q)!=true){
            q = new BigInteger(1024, new java.util.Random());
        }

        System.out.println("A p: "+ p + "\nA q: " + q );
        adatok[0]=p;
        adatok[1]=q;


        n = p.multiply(q);


        phiN = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        int max=phiN.bitCount();
        System.out.println("fiN:"+phiN);
        System.out.println(max);

        do
        {
            e = new BigInteger(max/10, new Random());
        }

        while(!euk.LKO(phiN, e).equals(BigInteger.valueOf(1)) || e.equals(p) || e.equals(q));
        System.out.println("e: "+e);

        adatok[2]=e;
        tmpd = euk.KiterjesztettEuklidesziAlgoritmus(phiN,e);
        d=tmpd[2];
        //System.out.println("A d itt: "+ d );
        if (d.compareTo(BigInteger.ZERO)==-1){
            d = d.add(phiN);
        }
        adatok[3]=d;
        System.out.println("Az e: "+ e + "\nA d: " + d );
        return adatok;


    }
}