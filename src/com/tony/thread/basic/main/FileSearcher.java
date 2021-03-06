package com.tony.thread.basic.main;

import com.tony.thread.basic.runnable.FileSearch;

import java.util.concurrent.TimeUnit;

public class FileSearcher {
    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("C:\\Windows", "explorer.exe");
        Thread thread = new Thread(searcher);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
