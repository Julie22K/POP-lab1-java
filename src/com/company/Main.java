package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        BreakThread breakThread = new BreakThread();

        int threads_number=9;
        ArrayList<Integer> timers = new ArrayList<>();
        for(int i=0;i<=threads_number;i++){
            int step = ThreadLocalRandom.current().nextInt(1, 11);
            int time = ThreadLocalRandom.current().nextInt(1, 21);
            new MainThread(i+1, breakThread,step,time).start();
            timers.add(i,time);

            breakThread.timers=timers;
            Collections.sort(timers);
        }
        new Thread(breakThread).start();
    }
}
