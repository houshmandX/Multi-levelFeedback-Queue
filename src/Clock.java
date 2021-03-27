import java.io.PrintWriter;

public class Clock {
	
	
	private int clockwise; // counting up
	private int counterclockwise; // counting down
	

	public Clock(int i) {  // creat clock for counting down
		
		counterclockwise = i;
		
	}
	
	public Clock() {	// creat clock for counting up
		
		clockwise = 0;
		
	}


	public void counterclockwise() { // decrease cpu time clock
		
		 counterclockwise --;
		
	}
	
	public int current_counterclockwise() {
		
		return counterclockwise;
	}
	
	public int clockwise() {  //counting up the clock
		
		return clockwise++;
	}
	
	public int current_clock() {
		
		return clockwise;
	}
}
