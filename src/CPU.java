import java.io.PrintWriter;

public class CPU {

	private Job job;
	//private int cpuQuantumClock;
	private boolean busyFlag;
	private PrintWriter pw; 
	private Clock quantum_clock;
	
	public CPU() {
		busyFlag = false;	// cpu in not busy
		
	}
	
	public void setjob(Job j) { // insert job to cpu
		
		job = j;
		busyFlag = true;
		cpuQuantumClock();
	}
	
	 private void cpuQuantumClock() {
		 
		int level = job.getcurrentQueue();
		
			if(level == 1) {
				quantum_clock = new Clock(2);
			}
			else if(level == 2) {
				quantum_clock = new Clock(4);
			}
			else if(level == 3) {
				quantum_clock = new Clock(8);
			}
			else {
			quantum_clock = new Clock(16);
			}
	    }
	 
	 public void decreaseTimes() { // decrease quantum clock, and system clock
		 
		 job.decreaseTimeRemaining(); 
		 quantum_clock.counterclockwise();
	 }
	 
	 public boolean isbusy() {
		 
		 return busyFlag;
	 }
	 
	
	 
	 public boolean jobdone() {
		
		 return (job.getcpuTimeRemaining() == 0);
			 
		 }
	 
	 public Job removeJob() {
		
		 busyFlag = false;
		return job; 
		
		 
	 }
	 
	 public boolean quantum_remaining() {
		 
		 return quantum_clock.current_counterclockwise() != 0;
	 }
		 
}
