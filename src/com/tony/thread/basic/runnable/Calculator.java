package com.tony.thread.basic.runnable;

import com.tony.thread.basic.utils.Utils;

public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 2L;
        long max = 100L;
        long numPrimes = 0L;
        System.out.printf("Thread '%s': START\n", Thread.currentThread().getName());

        while (current <= max) {
            if (Utils.isPrime(current)) {
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s': END. Number of Primes: %d\n", Thread.currentThread().getName(), numPrimes);
    }
}
