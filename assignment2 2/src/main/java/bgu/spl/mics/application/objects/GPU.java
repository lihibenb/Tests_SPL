package bgu.spl.mics.application.objects;

import bgu.spl.mics.*;

/**
 * Passive object representing a single GPU.
 * Add all the fields described in the assignment as private fields.
 * Add fields and methods to this class as you see fit (including public methods and constructors).
 */
public class GPU<T> {
    /**
     * Enum representing the type of the GPU.
     */
    enum Type {RTX3090, RTX2080, GTX1080}

    private Cluster cluster;
    private Type type;
    private Model model;
    private int batchSpace;
    //Java doesn't create new object but pointer
    private MessageBusImpl messageBus;

    private MicroService serv;

    public GPU(Type type, Cluster cluster, MessageBusImpl messageBus, Model model){
        this.type = type;
        this.cluster = cluster;
        this.messageBus = messageBus;
        this.model = model;

        // MicroService which responsible for handling the
        // “TrainModelEvent” and “TestModelEvent”
        serv = new GPUService("name");

        //determine BatchSpace according to type
        if(type == Type.RTX3090)
            batchSpace = 32;
        else if(type == Type.RTX2080)
            batchSpace = 16;
        else
            batchSpace = 8;
    }


    public void TestModelEvent(){
        //TODO somthing
    }

    public MicroService getMiro(){
        return serv;
    }

    //Future will be updated using the messageBus "complete" method

//    public void increseFreeBatches(GPU curGpu){
//        //TODO while rucnning every TIK increse batchSize untill reaches max
//    }

    public void TrainModelEvent(){
        //TODO somthing
    }





}
