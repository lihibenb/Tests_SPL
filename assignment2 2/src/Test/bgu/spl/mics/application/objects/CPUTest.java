package bgu.spl.mics.application.objects;

import bgu.spl.mics.TimeService;
import org.junit.Test;


import static org.junit.Assert.*;

public class CPUTest {

    CPU cpu=new CPU(8);
    DataBatch mydata=new DataBatch(DataBatch.Type.Text);

    //the time we want to get:
    //takes for text:  (32 / number of cores)*2  ticks
    int processTime= (32/cpu.getCores())*2;

    TimeService timeService = new TimeService(1 ,50);

    @Test
    public void getData() {
        //the time we started process
        int startTime = timeService.getCurrTime();

        cpu.getData(mydata);

        //the time we finished process
        int endTime = timeService.getCurrTime();

        //check if the process took the amount of time we expect
        assertSame(processTime,endTime-startTime);
    }


    @Test
    public void processData() {
        //tested in the getData() function which calls it
    }
}