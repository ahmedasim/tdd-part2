import java.util.ArrayList;


public class TestSuite {
	ArrayList<TestCase> tests;

	public TestSuite() {
		this.tests = new ArrayList<TestCase>();
	}
	public void add( TestCase obj){
		tests.add(obj);
	}
	
	public TestResult run(TestResult testResult){
		for(TestCase oneTest : tests  ){
			oneTest.run( testResult );
		}
		return testResult;
	}
	
}
