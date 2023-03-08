package com.company;

public class MainThread extends Thread{
    private final int id;
    private final BreakThread breakThread;
    private final int step;
    private final int time;

    public MainThread(int id, BreakThread breakThread,int step,int time) {
        this.id = id;
        this.breakThread = breakThread;
        this.step = step;
        this.time = time;
    }
    @Override
    public void run() {
        long sum = 0;
        int number=0;
        int numeric=0;
        boolean isStop = false;
        do{
            numeric++;
            number+=step;
            sum+=number;
            isStop = breakThread.isCanBreak(time);
        } while (!isStop);
        System.out.println("Thread id:" + id + "\tsum:" + sum + "\tstep:"+step+"\tnumeric:"+numeric+"\ttime:"+time);
    }
}
