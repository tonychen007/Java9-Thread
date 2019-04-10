package com.tony.thread.basic.main;

import com.tony.thread.basic.runnable.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Calc {
    private static final int THREAD_SIZE = 10;
    private static Thread threads[] = new Thread[THREAD_SIZE];
    private static Thread.State status[] = new Thread.State[THREAD_SIZE];

    private static void setUp() {
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

        for (int i = 0; i < THREAD_SIZE; i++) {
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }
    }

    private static void run() {
        try (FileWriter file = new FileWriter("z:\\log.txt");
             PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < THREAD_SIZE; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < THREAD_SIZE; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {

        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }

    public static void main(String[] args) {
        setUp();
        run();
    }
}