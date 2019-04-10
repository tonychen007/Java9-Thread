package com.tony.thread.runnable;

public class ParseInt implements Runnable {
    @Override
    public void run() {
        Integer.parseInt("TTT");
    }
}
