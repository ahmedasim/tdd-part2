

public class TestCaseTest extends TestCase {
	TestCaseTest(String name ){
		super(name);
	}
	
	public void testTemplateMethod(){
		WasRun test = new WasRun("testMethod");
		test.run( new TestResult()  );
	}
	
	public static void main(String[] args){
		
		// Test Single Method
		TestCaseTest testCaseTest = new TestCaseTest("testTemplateMethod");
		System.out.println( testCaseTest.run(new TestResult()).summary());
		
		TestCaseTest recordResults = new TestCaseTest("testResult");
		System.out.println( recordResults.run(new TestResult()).summary());
		
		TestCaseTest recordFailedResults = new TestCaseTest("testFailedResult");
		System.out.println( recordFailedResults.run(new TestResult()).summary());
		
		TestCaseTest recordFailedResultFormatting = new TestCaseTest("testFailedResultFormatting");
		System.out.println( recordFailedResultFormatting.run(new TestResult()).summary());
		
		//Test Suite
		TestCaseTest testSuite = new TestCaseTest("testSuite");
		testSuite.run(new TestResult()).summary();
		
		
	}
	
	public void testResult(){
		WasRun test = new WasRun("testMethod");
		TestResult result = test.run(new TestResult());
	}
	
	public void testFailedResult(){
		WasRun test = new WasRun("testBrokenMethod");
		TestResult result = test.run(new TestResult());
	}
	
	public void testFailedResultFormatting(){
		TestResult result = new TestResult();
		result.testStarted();
		result.testFailed();
	}
	
	public void testSuite(){
		
		TestSuite suite = new TestSuite();
		suite.add(new WasRun("testMethod"));
		suite.add(new WasRun("testBrokenMethod"));
		suite.add(new TestCaseTest("testTemplateMethod"));
		suite.add(new TestCaseTest("testResult"));
		suite.add(new TestCaseTest("testFailedResult"));
		suite.add(new TestCaseTest("testFailedResultFormatting"));
		
		TestResult result = new TestResult();
		System.out.println( "TestSuite Start");
		suite.run(result);
		System.out.println( "TestSuite Result:   "+ result.summary());
	}

}
