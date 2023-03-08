package com.company;

import java.util.ArrayList;

public class BreakThread implements Runnable{
//    private boolean canBreak = false;
    public ArrayList<Integer> timers;
    @Override
    public void run() {
        try {
            ArrayList<Integer> distance_timers=new ArrayList<>();
            int index=0;
            distance_timers.add(index,0);
            index++;
            for (int i = 0; i < timers.size() - 1; i++)
            {
                distance_timers.add(index,timers.get(i + 1) - timers.get(i));
                index++;
            }

            for (int i = 0; i < timers.size(); i++)
            {
                Thread.sleep(distance_timers.get(i) * 1000);
                timers.set(i,0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public boolean isCanBreak(int time) {
        return !timers.contains(time);
    }
}
