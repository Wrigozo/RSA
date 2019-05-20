package main.java.gyorshatvanyozas;

import java.math.BigInteger;

public class Gyorshatvanyozas {

    public  BigInteger gyorshatvanyozas(BigInteger alap, BigInteger kitevo, BigInteger m) {
        BigInteger result = BigInteger.ONE;
        //ha az alap nagyobb, mint a modulo
        alap = alap.mod(m);

        //a kitevo primtenyezos felbontasa
        while (!(kitevo.equals(BigInteger.ZERO))) {
            //ha primtenyezos felbontas 1, akkor :
            if ((kitevo.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)) {

                result = (result.multiply(alap)).mod(m);

            }
            kitevo = kitevo.divide(BigInteger.valueOf(2));
            alap = (alap.multiply(alap)).mod(m);
        }
        return result;
    }


}
