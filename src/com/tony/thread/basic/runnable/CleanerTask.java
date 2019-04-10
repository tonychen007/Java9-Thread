package com.tony.thread.basic.runnable;

import com.tony.thread.basic.mo.Event;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {
    private Deque<Event> events;
    private long timeout = 2000l;

    public CleanerTask(Deque<Event> deque) {
        this.events = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (events.size() == 0) {
            return;
        }

        delete = false;
        do {
            Event e = events.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > timeout) {
                System.out.printf("Cleaner: %s\n", e.getEvent());
                events.removeLast();
                delete = true;
            }
        } while (difference > timeout);
        if (delete) {
            System.out.printf("Cleaner: Size of the queue: %d\n", events.size());
        }
    }
}