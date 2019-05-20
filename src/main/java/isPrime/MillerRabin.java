package main.java.isPrime;

import java.math.BigInteger;

import main.java.gyorshatvanyozas.*;

public class MillerRabin {
    public static final int[] aValues = {2, 3, 7, 112, 17, 29, 5, 18, 103, 49, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
            283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409};
    public int s = 0;
    public BigInteger d;
    Gyorshatvanyozas gy = new Gyorshatvanyozas();

    public boolean MillerRabin(BigInteger analyzedNumber) {
        d = analyzedNumber.subtract(BigInteger.ONE);

        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            s++;
            d = d.divide(BigInteger.valueOf(2));
        }
        for (int i = 0; i < aValues.length; i++) {
            BigInteger a = BigInteger.valueOf(aValues[i]);
            boolean r = test(analyzedNumber, a, s, d);
            if (r) {
                return true;
            }
        }
        return false;
    }

    public boolean test(BigInteger analyzedNumber, BigInteger alap, int s, BigInteger d) {
        if (gy.gyorshatvanyozas(alap, d, analyzedNumber).equals(BigInteger.valueOf(1))) {
            return true;
        }
        for (int r = 1; r < s; r++) {

            BigInteger exp = BigInteger.valueOf(2).pow(r);
            exp = d.multiply(exp);

            BigInteger result = gy.gyorshatvanyozas(alap, exp, analyzedNumber);

            if (result.equals(analyzedNumber.subtract(BigInteger.ONE)))
                return true;
        }
        return false;
    }


}

/*
    public static final int[] aValues = { 2, 3 ,7, 112, 17, 29, 5, 18, 103, 49};

    public static boolean testPr(BigInteger n, BigInteger a, int s, BigInteger d) {
        for (int i = 0; i < s; i++) {
            BigInteger exp = BigInteger.valueOf(2).pow(i);
            exp = exp.multiply(d);
            BigInteger res = Gyorshatvanyozas.gyorshatvanyozas(a, exp, n);
            if (res.equals(n.subtract(BigInteger.ONE)) || res.equals(BigInteger.ONE)) {
                return true;
            }
        }
        return false;
    }
    public static boolean millerRabin(BigInteger n, int numValues) {
        BigInteger d = n.subtract(BigInteger.ONE);
        int s = 0;
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            s++;
            d = d.divide(BigInteger.valueOf(2));
        }
        for (int i = 0; i < numValues; i++) {
            BigInteger a = BigInteger.valueOf(aValues[i]);
            boolean r = testPr(n, a, s, d);
            if (!r) {
                return false;
            }
        }
        return true;
    }*/

