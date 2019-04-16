package com.tony.thread.advSync.main;

import com.tony.thread.advSync.runnable.Participant;
import com.tony.thread.advSync.runnable.Videoconference;

public class CountdownLatchTest {
    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
