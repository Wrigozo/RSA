package main.java.RSA;

import java.math.BigInteger;

import main.java.gyorshatvanyozas.*;
import main.java.kinai.Kinai;

public class RSA {
    public BigInteger enCrypted;

    Gyorshatvanyozas gy = new Gyorshatvanyozas();

    public BigInteger EnCrypt(BigInteger message, BigInteger e, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        enCrypted = gy.gyorshatvanyozas(message, e, n);
        System.out.println("A titkosítandó szöveg: " + message);
        return enCrypted;
    }

    public BigInteger DeCrypt(BigInteger p, BigInteger q, BigInteger enCrypted, BigInteger d) {
        Kinai kinai = new Kinai();
        return kinai.kinai(p, q, enCrypted, d);
    }

}
