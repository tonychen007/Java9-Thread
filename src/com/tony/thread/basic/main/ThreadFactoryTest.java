package com.tony.thread.basic.main;

import com.tony.thread.basic.customizedThread.MyThreadFactory;
import com.tony.thread.basic.runnable.ThreadFactoryTask;

public class ThreadFactoryTest {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("Tony-ThreadFactory");
        ThreadFactoryTask task = new ThreadFactoryTask();

        for (int i = 0; i < 10; i++) {
            myThreadFactory.newThread(task).start();
        }

        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n",myThreadFactory.getStats());
    }
}
