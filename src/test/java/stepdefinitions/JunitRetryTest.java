package stepdefinitions;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class JunitRetryTest {
	
	int retryCount = 4;
	
	@Rule
	public JUnitRetry retry = new JUnitRetry(retryCount);
	
	@Test
	public void FailedRetryCheck() {
		Assert.fail();		
	}
}