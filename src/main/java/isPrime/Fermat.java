package main.java.isPrime;

import main.java.gyorshatvanyozas.*;

import java.math.BigInteger;

public class Fermat {
    Gyorshatvanyozas gy = new Gyorshatvanyozas();

    public boolean fermatTest(BigInteger alap, BigInteger hatvany) {
        BigInteger egy = BigInteger.ONE;
        if ((gy.gyorshatvanyozas(alap, (hatvany.subtract(BigInteger.ONE)), hatvany)).equals(egy)) {
            return true;
        }
        return false;
    }
}
