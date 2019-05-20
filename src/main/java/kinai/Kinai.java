package main.java.kinai;

import main.java.euklideszi.*;
import main.java.gyorshatvanyozas.*;

import java.math.BigInteger;

public class Kinai {

    public BigInteger m;
    BigInteger x;
    BigInteger y;
    euklidesziAlgoritmus euk = new euklidesziAlgoritmus();
    Gyorshatvanyozas gy = new Gyorshatvanyozas();
    public BigInteger kinai(BigInteger p, BigInteger q, BigInteger c, BigInteger d) {


        BigInteger n = p.multiply(q);
        BigInteger dP = d.mod(p.subtract(BigInteger.ONE));
        BigInteger dQ = d.mod(q.subtract(BigInteger.ONE));

        BigInteger c1 = gy.gyorshatvanyozas(c, dP, p);
        BigInteger c2 = gy.gyorshatvanyozas(c, dQ, q);

        BigInteger M1 = n.divide(p);
        BigInteger M2 = n.divide(q);

        BigInteger[] ans2 = euk.KiterjesztettEuklidesziAlgoritmus(M1, M2);
        x = ans2[1];
        y = ans2[2];

        BigInteger y1;
        BigInteger y2;

        if (x.compareTo(BigInteger.valueOf(0)) == -1) {
            x = p.add(x);

            if (x.multiply(M1).mod(p).equals(BigInteger.valueOf(1))) {
                y1 = x;
                y2 = y;
            } else {
                x = x.add(q).subtract(p);

                y1 = y;
                y2 = x;
            }
        } else {
            y=y.add(p);
            if (y.multiply(M1).mod(p).equals(BigInteger.valueOf(1))) {
                y1 = y;
                y2 = x;
            }
            else {
                y=y.add(q).subtract(p);
                y1 = x;
                y2 = y;
            }
        }

        BigInteger tmp = (M1.multiply(c1).multiply(y1)).add(M2.multiply(c2).multiply(y2));

        m = tmp.mod(n);

        return m;
    }
}





