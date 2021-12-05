package bgu.spl.mics.application.objects;


/**
 * Passive object representing the cluster.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * Add all the fields described in the assignment as private fields.
 * Add fields and methods to this class as you see fit (including public methods and constructors).
 */
public class Cluster {


	/**
	 * Retrieves the single instance of this class.
	 */
	private static bgu.spl.mics.application.objects.Cluster instance = null;
	public static bgu.spl.mics.application.objects.Cluster getInstance() {
		if(instance == null) {
			instance = new bgu.spl.mics.application.objects.Cluster();
		}
		return instance;
	}

	//constructor
	public Cluster(){}

}
