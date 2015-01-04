import java.lang.reflect.Method;


public class TestCase {
	protected String name;
	private Class noparams[] = {};
	boolean wasSetUp;
	
	public TestCase(String name) {
		this.name = name;
	}
	public TestCase() {
	}
	
	public TestResult run(TestResult testResult){
		try{
			testResult.testStarted();
			setUp();
			Class cls = this.getClass();
			Method method = cls.getDeclaredMethod( name, noparams);
			method.invoke( this );
			tearDown();
		}catch(Exception e){
			testResult.testFailed();
		}
		return testResult;
	}
	
	public void setUp(){
		
	}
	public void tearDown(){
		
	}
	
}
