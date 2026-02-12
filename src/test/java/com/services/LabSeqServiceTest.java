package com.services;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class LabSeqServiceTest {

    @Inject
    LabSeqService service;
    //MethodName_StateUnderTest_ExpectedBehavior
    @Test
    void calculateLabSeq_FirstTenNumbers_ShouldPass(){
        HashMap<Integer, BigInteger> expectedRes = new HashMap<>();
        expectedRes.put(0,new BigInteger("0"));
        expectedRes.put(1,new BigInteger("1"));
        expectedRes.put(2,new BigInteger("0"));
        expectedRes.put(3,new BigInteger("1"));
        expectedRes.put(4,new BigInteger("1"));
        expectedRes.put(5,new BigInteger("1"));
        expectedRes.put(6,new BigInteger("1"));
        expectedRes.put(7,new BigInteger("2"));
        expectedRes.put(8,new BigInteger("2"));
        expectedRes.put(9,new BigInteger("2"));


        for (int i = 0; i < 10; i++) {
            BigInteger actual = service.calculateLabSeq(i);
            assertEquals(expectedRes.get(i), actual);
        }

    }

    @Test
    void calculateLabSeq_NegativeNumber_ShouldThrowIllegalArgument(){
        assertThrows(IllegalArgumentException.class, () -> service.calculateLabSeq(-1));
    }

    @Test
    void calculateLabSeq_OneHundredThousand_ShouldBeCorrectAndCompleteUnder10s(){
        BigInteger actual = service.calculateLabSeq(99996).add(service.calculateLabSeq(99997));
        long startTime = System.nanoTime();

        BigInteger result = service.calculateLabSeq(100000);

        long stopTime = System.nanoTime();

        long duration = (stopTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

        assertTrue(duration < 10000, "Labseq method duration (" + duration + ") should not exceed 10 seconds. (" + duration + ")");
        assertEquals(result, actual);
    }
}
