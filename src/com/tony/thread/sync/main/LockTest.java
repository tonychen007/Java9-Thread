package com.tony.thread.sync.main;

import com.tony.thread.sync.mo.PrintQueue;
import com.tony.thread.sync.runnable.LockJob;

public class LockTest {

    public static void main(String[] args) {
        //System.out.printf("Running example with fair-mode = false\n ");
        //testPrintQueue(false);
        //System.out.printf("*******************************************\n");
        System.out.printf("Running example with fair-mode = true\n");
        testPrintQueue(true);
    }

    private static void testPrintQueue(Boolean fairMode) {
        PrintQueue printQueue = new PrintQueue(fairMode);
        Thread thread[] = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new LockJob(printQueue), "Thread " + i);
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
