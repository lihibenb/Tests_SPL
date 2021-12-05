package bgu.spl.mics.application.objects;

import bgu.spl.mics.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class GPUTest {
    Cluster cluster = new Cluster();
    Model model = new Model();
    GPU testModelGPU;
    GPU trainModelGPU;
    MessageBusImpl messageBus;
    TestEventModel testEventModel = new TestEventModel();
    TimeService timeService = new TimeService(1 ,50);

    @Test
    public void testModelEvent() throws InterruptedException {
        model.setStatus(Model.statusList.Trained);
        testModelGPU = new GPU(GPU.Type.GTX1080, cluster, messageBus,model);

        //registering and adding the new MicroService into the msB
        messageBus.register(testModelGPU.getMiro());
        messageBus.subscribeEvent(testEventModel.getClass(), testModelGPU.getMiro() );
        messageBus.sendEvent(testEventModel);

        //preforming the action
        testModelGPU.TestModelEvent();

        //checking if the values fit the expected ones
        boolean changed, tested;
        changed = (model.getResult() == Model.resultsList.Bad || model.getResult() == Model.resultsList.Good);
        tested = (model.getStatus() == Model.statusList.Tested);
        assertTrue(changed == tested && tested == true);

        //first time is the name (our implementation)
        messageBus.awaitMessage(testModelGPU.getMiro());

        //the second one need to be Future with with our result
        Future future = (Future) messageBus.awaitMessage(testModelGPU.getMiro());

        assertFalse(future == null);
        assertTrue(future.isDone());
    }

    @Test
    public void trainModelEvent() {
//        Tick before
//        action:
//        Tick after
//        after - before = expectedTimeAccoridng2Type(1080, 2080, 3090)
//        we'll check only for 1080 since its the same code

        trainModelGPU = new GPU(GPU.Type.GTX1080, cluster, messageBus,model);
        int start = timeService.getCurrTime();
        trainModelGPU.TestModelEvent();
        int end = timeService.getCurrTime();
        assertTrue(start - end == 4);
    }



}