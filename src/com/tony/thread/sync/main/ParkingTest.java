package com.tony.thread.sync.main;

import com.tony.thread.sync.mo.ParkingCash;
import com.tony.thread.sync.mo.ParkingStats;
import com.tony.thread.sync.runnable.Sensor;

public class ParkingTest {
    public static void main(String[] args) {
        int numberSensors = Runtime.getRuntime().availableProcessors() >> 1;
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);
        System.out.printf("Parking Simulator\n");

        Thread threads[] = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        // wait for thread to complete
        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of cars: %d\n", stats.getNumberCars());
        System.out.printf("Number of motorcycles: %d\n", stats.getNumberMotorcycles());
        cash.close();
    }
}