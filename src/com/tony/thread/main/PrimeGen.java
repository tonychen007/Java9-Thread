package com.tony.thread.main;

import com.tony.thread.runnable.PrimeGenerator;

public class PrimeGen {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            String msg = e.getMessage();
            e.printStackTrace();
        }
        task.interrupt();
        System.out.printf("Main: Status of the Thread: %s\n", task.getState());
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
    }
}
