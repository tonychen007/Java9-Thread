package com.tony.thread.main;

import com.tony.thread.exception.ExceptionHanlder;
import com.tony.thread.runnable.ParseInt;

public class UncaughtException {
    public static void main(String[] args) {
        Thread th1 = new Thread(new ParseInt());
        th1.setUncaughtExceptionHandler(new ExceptionHanlder());
        th1.start();
    }
}
