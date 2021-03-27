import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.xml.namespace.QName;

public class MFQ {
	
	private PrintWriter pw;
	ObjectQueue queue1 = new ObjectQueue();
	ObjectQueue queue2 = new ObjectQueue();
	ObjectQueue queue3 = new ObjectQueue();
	ObjectQueue queue4 = new ObjectQueue();
	private ObjectQueue job_q = new ObjectQueue();
	private Clock system_clock = new Clock();
	
	private Job temp_job;
	private CPU cpu;
	
	/**
	 * class constructure
	 * @param p
	 */
	public MFQ(PrintWriter p) {

		pw = p;

	}

	public void getJobs() throws IOException {

		String buf;
		// Job temp_job;

		Scanner mfq = new Scanner(new File("mfq.txt"));

		while (mfq.hasNext()) {

			buf = mfq.nextLine();
			String[] tokens = buf.split("[ ]+");
			
			int i = tokens[0].equals("") ? 1 : 0;
		
				Job temp_job = new Job(Integer.valueOf(tokens[i]), Integer.valueOf(tokens[i + 1]),
						Integer.valueOf(tokens[i+2]));
				
				job_q.insert(temp_job);
				
			}
		
		mfq.close();
	}
	
	public void outputHeader() {
		
		System.out.printf("%-11s %10s %10s %20s %22s %22s", "Event", "System Time", "PID", "CPU Time Needed", 
				"Total Time In System", "Lowest Level Queue");
		System.out.println("\n");
	}
	
	public void runSimulation() {
		
		while(!job_q.isEmpty()){
			
			system_clock.clockwise();
			System.out.println("System time is:" + system_clock.current_clock());
		
			temp_job = (Job) job_q.query();
		
		 int arrivaltime = temp_job.getarrivalTime();
		
		 
		 if(system_clock.current_clock() == arrivaltime) {	// if we have a new job that suppused ti insert
			 
			 queue1.insert(temp_job);
			 System.out.printf("%s %10d %15d %14d\n","Arrival" , system_clock.current_clock() , temp_job.getpid() , temp_job.getcpuTimeRequired() );
			if(cpu.isbusy()) // cpu is busy
			{
				cpu.decreaseTimes();
				
				if(cpu.jobdone()) { // ckeck job is done
					
					temp_job = cpu.removeJob();
					System.out.printf("%s %10d %15d %31d %16d\n","Departure" , system_clock.current_clock() , (system_clock.current_clock() - temp_job.getarrivalTime()) ,temp_job.getpid() , temp_job.getcurrentQueue());
					// output
					//keep totals
					submit_nextJob();//sumbmit new job to cpu
				}
				else {  // job in not finished
					if(!queue1.isEmpty()) {
						
						Pre_emption();
							
					}
				}
				
			}
			else {	// cpu is not busy
				
				submit_nextJob(); //sumbmit new job to cpu
			}
			  
			 
		 }
		}
		
		
	}
	
	public void outStates() {
		
	}
	
	public void submit_nextJob() {
		
		if(!queue1.isEmpty()) {
			
			cpu.setjob((Job)queue1.remove());
		}
		
		else if(!queue2.isEmpty()){
			
			cpu.setjob((Job)queue2.remove());
			
		}
		
		else if(!queue3.isEmpty()){
			
			cpu.setjob((Job)queue3.remove());
			
		}
		
		else if(!queue4.isEmpty()){
			
			cpu.setjob((Job)queue4.remove());
			
		}
		
		
	}
	
	public void Pre_emption() {
		
		temp_job = cpu.removeJob();
		 int level = temp_job.getcurrentQueue();
		
		 if(temp_job.getcpuTimeRemaining() == 0) {
			 
			 System.out.println(temp_job.getarrivalTime()+ "***" + temp_job.getpid()+"***"+ temp_job.getcpuTimeRequired());
		 }
		 
		 	if(level == 1) {
				queue2.insert(temp_job);
			}
			
			else if(level == 2) {
				queue3.insert(temp_job);
			}
			
			else {
				queue4.insert(temp_job);
			}
	}
	
}
