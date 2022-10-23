package com.medium.redis.util;

public class ExecutionTime {

    private long start;
    private long end;

    public ExecutionTime(boolean start){
        this.start = 0L;
        this.end = 0L;
        if (start){
            this.startTime();
        }else{
            this.reset();
        }
    }

    public void startTime() {
        this.start = System.currentTimeMillis();
        this.end = this.start;
    }

    public void endTime() {
        this.end = System.currentTimeMillis();
    }

    public long duration(){
        return this.end - this.start;
    }

    public static String formatElapsedTime(long millis){
        return String.format("%d sec (%d milisec)" , millis / 1000L,millis);
    }

    public void reset(){
        this.end = 0L;
        this.start = 0L;
    }

}
