package main.java;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Converter  {

           public BigInteger convertToBiginteger(String s) throws UnsupportedEncodingException {
               String identifier = s;
               BigInteger identifierBI = new BigInteger(identifier.getBytes("us-ascii"));
               System.out.println("Identifier: " + identifier + " converted to Big Integer: " + identifierBI);
               return  identifierBI;
           }

            public String  BigIntegerToString(BigInteger identifierBI) {
                String verifyIdentifier = new String(identifierBI.toByteArray());
                System.out.println("Big Integer converted back to string val: " + verifyIdentifier);
                return verifyIdentifier;
            }

}

