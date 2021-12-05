package bgu.spl.mics;

public class TimeService<prive> {
    private int speed;
    private int duration;
    private int now = 0;

    public TimeService(int a, int b){}
    public TimeService(){}

    public int geTimer(){return speed;}

    public int getCurrTime(){return now;}
}
