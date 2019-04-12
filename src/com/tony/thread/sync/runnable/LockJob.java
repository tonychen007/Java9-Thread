package com.tony.thread.sync.runnable;

import com.tony.thread.sync.mo.PrintQueue;

public class LockJob implements Runnable {
    private PrintQueue printQueue;

    public LockJob(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        printQueue.printJob();
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
