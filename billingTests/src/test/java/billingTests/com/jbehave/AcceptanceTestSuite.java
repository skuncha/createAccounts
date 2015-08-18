package billingTests.com.jbehave;

import billingTests.com.utils.WebDriverConfigurer;
import net.thucydides.jbehave.ThucydidesJUnitStories;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {
	
	public AcceptanceTestSuite() {
		
	WebDriverConfigurer.configureDrivers();
	
	}
}
