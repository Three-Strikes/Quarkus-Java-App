package com.services;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.HashMap;

@ApplicationScoped
public class LabSeqService {

    // HashMap for fast lookups.
    // n ,l(n) (index number, result)
    private final HashMap<Integer, BigInteger> cache = new HashMap<>();

    public LabSeqService() {
        //Initialize cache with known values as soon as service is instantiated.
        cache.put(0,new BigInteger("0"));
        cache.put(1,new BigInteger("1"));
        cache.put(2,new BigInteger("0"));
        cache.put(3,new BigInteger("1"));
    }

    public BigInteger calculateLabSeq(int n){
        if(n < 0) throw new IllegalArgumentException("The n parameter has to be a positive integer.");
        if (n == 0 || n == 2) return new BigInteger("0");
        if (n == 1 || n == 3) return new BigInteger("1");

        if(cache.containsKey(n)){
            return cache.get(n);
        }

        BigInteger resultToReturn = calculateLabSeq(n-4).add(calculateLabSeq(n-3));
        cache.put(n, resultToReturn);
        return resultToReturn;

    }

}
