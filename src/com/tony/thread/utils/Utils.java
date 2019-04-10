package com.tony.thread.utils;

public class Utils {
    public static boolean isPrime(long num) {
        if (num == 2 || num == 3 || num == 5 || num == 7)
            return true;

        if ((num % 3) == 0 || ((num % 5)) == 0 || (num % 7) == 0)
            return false;

        for (int i = 2; i < num; i++) {
            if ((num % i) == 0)
                return false;
        }

        return true;
    }
}
