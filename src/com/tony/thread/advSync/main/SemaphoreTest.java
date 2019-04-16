package com.tony.thread.advSync.main;

import com.tony.thread.advSync.mo.PrintQueue;
import com.tony.thread.advSync.runnable.PrintJob;

public class SemaphoreTest {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[12];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new PrintJob(printQueue), "Thread" + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
