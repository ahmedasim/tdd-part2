
public class TestResult {
	int runCount = 0;
	int errorCount = 0;
	
	public String summary(){
		return  runCount + " run, " + errorCount + " failed";
	}
	public void testStarted(){
		runCount++;
	}
	public void testFailed() {
		errorCount++;
	}
}
