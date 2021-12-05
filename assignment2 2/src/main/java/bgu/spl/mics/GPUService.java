package bgu.spl.mics;

public class GPUService extends MicroService{
    /**
     * @param name the micro-service name (used mainly for debugging purposes -
     *             does not have to be unique)
     */
    public GPUService(String name) {
        super(name);
    }

    @Override
    protected void initialize() {
        terminate();
    }
}
