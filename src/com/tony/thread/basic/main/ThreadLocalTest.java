package com.tony.thread.basic.main;

import com.tony.thread.basic.runnable.SafeDate;
import com.tony.thread.basic.runnable.UnsafeDate;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    public static void testSafe() {
        SafeDate task = new SafeDate();
        commonTask(task);
    }

    public static void testUnSafe() {
        UnsafeDate task = new UnsafeDate();
        commonTask(task);
    }

    private static void commonTask(Runnable r) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("unsafe without threadlocal");
        testUnSafe();
        System.out.println("**************************");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("safe with threadlocal");
        testSafe();
    }
}