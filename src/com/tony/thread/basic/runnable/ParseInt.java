package com.tony.thread.basic.runnable;

public class ParseInt implements Runnable {
    @Override
    public void run() {
        Integer.parseInt("TTT");
    }
}
