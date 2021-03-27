//Houshmand Esmaeilpourarabi
//ID:010933959


/**
 * Job class 
 * 
 * @author Houshmand Esmaeilpourarabi
 * 
 * Properties: pid, arrivalTime, cpuTimeRequired and cpuTimeRemaining
 *
 */
public class Job {
	
	private int pid;
	private int arrivalTime;
	private int cpuTimeRequired;
	private int cpuTimeRemaining;
	private int currentQueue;
	
	
	/**
	 * Class constructor
	 * @param id
	 * @param arrival
	 * @param cpu_Time
	 *
	 */
	public Job(int arrival, int id, int cpu_Time) {
		
		arrivalTime = arrival;
		pid = id;
		cpuTimeRequired = cpu_Time;
		cpuTimeRemaining = cpuTimeRequired;
		currentQueue = 1; // new job always come to q1
		
	}
	
	/**
	 * Extracts the job ID
	 * @return pid
	 */
	public int getpid() {
		
		return pid;
	}
	
	/**
	 * Extracts the time when this job arrived in the queue/level
	 * @return arrivalTime
	 */
	public int getarrivalTime() {
		
		return arrivalTime;
	}
	
	/**
	 * Returns the cpu time required for the current job
	 * @return cpuTimeRequired
	 */
	public int getcpuTimeRequired() {
		
		return cpuTimeRequired;
	}
	
	/**
	 * Returns the number of seconds needed to finish this job
	 * @return cpuTimeRemaining
	 */
	public int getcpuTimeRemaining() {
		
		return cpuTimeRemaining; 
	}
	
	public int getcurrentQueue() {
		
		return currentQueue;
	}
	
	public void decreaseTimeRemaining() { // decrease remaining time of job clock
		
		cpuTimeRemaining-- ;
	}

}
