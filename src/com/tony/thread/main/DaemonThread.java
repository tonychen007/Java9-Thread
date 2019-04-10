package com.tony.thread.main;

import com.tony.thread.mo.Event;
import com.tony.thread.runnable.CleanerTask;
import com.tony.thread.runnable.WriterTask;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DaemonThread {
    public static void main(String[] args) {
        Deque<Event> deque = new ConcurrentLinkedDeque<>();
        WriterTask writer = new WriterTask(deque);
        int cores = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < cores; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }

        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}