package main.java;

import main.java.KeyGenerator.KeyGenerator;
import main.java.RSA.RSA;
import main.java.euklideszi.*;
import main.java.gyorshatvanyozas.Gyorshatvanyozas;
import main.java.isPrime.MillerRabin;
import java.math.BigInteger;
import main.java.kinai.*;


public class Main {

    public static void main(String[] args) {
        //BigInteger ans = euklidesziAlgoritmus.LKO(BigInteger.valueOf(2340), BigInteger.valueOf(113));
        //System.out.println(ans);
        /*
        BigInteger[] ans2 = euklidesziAlgoritmus.KiterjesztettEuklidesziAlgoritmus(BigInteger.valueOf(7), BigInteger.valueOf(13));
        for (int i = 0; i < 3; i++) {
            System.out.println(ans2[i]);
        }
        //BigInteger a = Gyorshatvanyozas.gyorshatvanyozas(BigInteger.valueOf(7), BigInteger.valueOf(2401), BigInteger.valueOf(197));
        //System.out.println(a);
        Gyorshatvanyozas gy =new Gyorshatvanyozas();
        BigInteger p=gy.gyorshatvanyozas(BigInteger.valueOf(85),BigInteger.valueOf(5),BigInteger.valueOf(7));
        System.out.println("p: "+p);
        BigInteger q=gy.gyorshatvanyozas(BigInteger.valueOf(85),BigInteger.valueOf(11),BigInteger.valueOf(13));
        System.out.println("q: "+q);
        MillerRabin m=new MillerRabin();
        boolean osszett=m.MillerRabin(BigInteger.valueOf(7),BigInteger.valueOf(197));
        System.out.println(osszett);
        Kinai kinai1=new Kinai();
        BigInteger kinai=kinai1.kinai(BigInteger.valueOf(7), BigInteger.valueOf(13),BigInteger.valueOf(85),BigInteger.valueOf(47));
        System.out.println("kinai: "+kinai); */
        euklidesziAlgoritmus euk=new euklidesziAlgoritmus();
        BigInteger result=euk.LKO(BigInteger.valueOf(32), BigInteger.valueOf(12));
        System.out.println("legnagyobb ko: "+result);
        RSA rsa=new RSA();
        KeyGenerator key=new KeyGenerator();
        BigInteger[] adatok=key.keyGenerator();
        BigInteger p=adatok[0];
        BigInteger q=adatok[1];
        BigInteger e=adatok[2];
        BigInteger d=adatok[3];
        BigInteger message=BigInteger.valueOf(123456789);
        BigInteger encrypted=rsa.EnCrypt(message,e,p,q);
        for (int i=0; i<4;i++){
            System.out.println("Adatok["+i+"]: "+adatok[i]);
        }
        //BigInteger decrypted=rsa.DeCrypt(p,q,e,d);
        //System.out.print("Encrypted: "+encrypted+" and the decrypted: "+decrypted);



    }
}
