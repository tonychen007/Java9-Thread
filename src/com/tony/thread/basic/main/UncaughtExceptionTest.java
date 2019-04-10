package com.tony.thread.basic.main;

import com.tony.thread.basic.runnable.ParseInt;
import com.tony.thread.basic.exception.ExceptionHanlder;

public class UncaughtExceptionTest {
    public static void main(String[] args) {
        Thread th1 = new Thread(new ParseInt());
        th1.setUncaughtExceptionHandler(new ExceptionHanlder());
        th1.start();
    }
}
