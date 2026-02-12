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
        cache.put(0,BigInteger.ZERO);
        cache.put(1,BigInteger.ONE);
        cache.put(2,BigInteger.ZERO);
        cache.put(3,BigInteger.ONE);
    }

    public BigInteger calculateLabSeq(int n) {
        if(n < 0) throw new IllegalArgumentException("The n parameter must be a positive integer.");
        if (n == 0 || n == 2) return BigInteger.ZERO;
        if (n == 1 || n == 3) return BigInteger.ONE;

        BigInteger result = BigInteger.ZERO;

        for(int i = 4; i <= n; i++){
            result = cache.get(i-4).add(cache.get(i-3));
            if(!cache.containsKey(i)) cache.put(i, result);
        }
        return result;
    }

}
