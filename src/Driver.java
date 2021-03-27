//Houshmand Esmaeilpourarabi
//ID: 010933959
import java.io.*;

/**
 * Multi-Level Feddback Queue Simulation
 * 
 * This program simulate an operating System's job scheduling policy
 * to determine which process will be assigned the CPU when it becomes available 
 * 
 * @author Houshmand Esmaeilpourarabi
 *
 *Driver class
 *
 */

public class Driver {
	
	/**
	 * Main method
	 * 
	 * @param args an array of command-line arguments for the application
	 * @throws IOException If an input or output exception occurred
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		MFQ mfq = new MFQ(pw);
		mfq.getJobs();
		mfq.outputHeader();
		mfq.runSimulation();
		//mfq.outStates();
		pw.close();
		
	}

}
