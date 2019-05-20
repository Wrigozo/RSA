package main.java.euklideszi;

import java.math.BigInteger;

public class euklidesziAlgoritmus {
    public  BigInteger counter = BigInteger.ZERO;
    public  BigInteger x = BigInteger.ZERO;
    public  BigInteger y = BigInteger.ONE;
    public  BigInteger previousX = BigInteger.ONE;
    public  BigInteger previousY = BigInteger.ZERO;
    public  BigInteger newX;
    public  BigInteger newY;
    public  BigInteger maradek = BigInteger.ONE;
    public  BigInteger q = BigInteger.ONE;


    public BigInteger LKO(BigInteger firstNumber, BigInteger secondNumber) {
        BigInteger tmp = BigInteger.valueOf(0);
        if (secondNumber.compareTo(firstNumber) == 1) {
            tmp = secondNumber;
            secondNumber = firstNumber;
            firstNumber = tmp;
        }
        tmp = BigInteger.valueOf(0);
        BigInteger osztja = BigInteger.valueOf(0);
        while (!secondNumber.equals(BigInteger.ZERO)) {
            tmp = secondNumber;
            osztja = firstNumber.divide(secondNumber);
            secondNumber = firstNumber.mod(secondNumber);
            firstNumber = tmp;
        }
        return firstNumber;
    }

    public BigInteger[]/*(BigInteger lnko, BigInteger X, BigInteger Y)*/ KiterjesztettEuklidesziAlgoritmus(BigInteger a, BigInteger b) {

        //ha a második szám nagyobb cserélje meg őket
        if (b.compareTo(a) == 1) {
            BigInteger tmp = a;
            a = b;
            b = tmp;
        }

        while (!b.equals(BigInteger.ZERO)) {
            maradek = a.mod(b);
            System.out.println("maradek: "+maradek);
            q = a.divide(b);
            a = b;
            b = maradek;
            newX = q.multiply(x).add(previousX);
            newY = q.multiply(y).add(previousY);

            previousX = x;
            previousY = y;

            x = newX;
            y = newY;

            counter = counter.add(BigInteger.ONE);

        }
        BigInteger[] result = new BigInteger[3];
        result[0] = q;
        System.out.println("counter: "+counter);
        if (!counter.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            result[1] = BigInteger.ZERO.subtract(previousX);
            result[2] = previousY;
        } else {
            result[1] = previousX;
            result[2] = BigInteger.ZERO.subtract(previousY);
        }

        return result;
    }
}


