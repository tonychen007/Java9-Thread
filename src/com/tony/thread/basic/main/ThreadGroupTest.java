package com.tony.thread.basic.main;

import com.tony.thread.basic.customizedThread.MyThreadGroup;
import com.tony.thread.basic.runnable.ThreadGroupTask;

public class ThreadGroupTest {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("Tony ThreadGroup");
        int numberOfThreads = Runtime.getRuntime().availableProcessors() >> 1;

        ThreadGroupTask task = new ThreadGroupTask();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }

        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
    }
}