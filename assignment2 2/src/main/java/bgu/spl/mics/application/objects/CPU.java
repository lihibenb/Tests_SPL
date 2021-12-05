package bgu.spl.mics.application.objects;

import bgu.spl.mics.MicroService;
import bgu.spl.mics.application.services.CPUService;

import java.util.Collection;
import java.util.List;

/**
 * Passive object representing a single CPU.
 * Add all the fields described in the assignment as private fields.
 * Add fields and methods to this class as you see fit (including public methods and constructors).
 */
public class CPU {
    private int cores;
    private List<DataBatch> data;
    private Cluster cluster;
    private MicroService service;
    private boolean free=true;

    public CPU(int cores){
        this.cores=cores;
        service=new CPUService("myName");
    }

    //input: DataBatch needs to be processed
    public void getData(DataBatch NewData){
        data.add(NewData);
        ProcessData();
        free=true;
    }

    //return true if the CPU is free to get data
    //  -> false otherwise
    public boolean isfree(){
        return free;
    }

    //start to process the data, and return it after
    public DataBatch ProcessData(){
        free=false;
        //processing
        return null;
    }

    //return number of cores
    public int getCores(){
        return cores;
    }


}
