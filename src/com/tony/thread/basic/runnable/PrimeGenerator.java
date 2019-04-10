package com.tony.thread.basic.runnable;

import com.tony.thread.basic.utils.Utils;

public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (Utils.isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            if (isInterrupted()) {
                //System.out.printf("The Prime Generator has been Interrupted " + Thread.interrupted() + "\n");
                System.out.printf("The Prime Generator has been Interrupted \n");
                return;
            }
            number++;
        }
    }
}
