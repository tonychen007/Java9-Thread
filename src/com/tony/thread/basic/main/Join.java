package com.tony.thread.basic.main;

import com.tony.thread.basic.runnable.DataSourceLoader;
import com.tony.thread.basic.runnable.NetworkLoader;

import java.util.Date;

public class Join {
    public static void main(String[] args) {
        Thread th1 = new Thread(new DataSourceLoader(), "data source thread");
        Thread th2 = new Thread(new NetworkLoader(), "network thread");
        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {

        }

        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
    }
}
