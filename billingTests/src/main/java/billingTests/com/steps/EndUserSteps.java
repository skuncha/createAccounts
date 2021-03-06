package billingTests.com.steps;


import java.io.IOException;
import java.util.ArrayList;

import billingTests.com.pages.SalesforceGlueContactsPage;
import net.thucydides.core.steps.ScenarioSteps;
import billingTests.com.pages.LoginPage;
import billingTests.com.pages.SalesforceGlueAccountPage;
import billingTests.com.pages.SalesforceGlueHomePage;

/**
 * @author Srinivasa.Kuncha
 *
 */
public class EndUserSteps extends ScenarioSteps {

    LoginPage loginPage;
    SalesforceGlueHomePage homePage;
    ArrayList<String> arraylist = new ArrayList<String>(); 
    
    public void is_this_home_page()  {
    	loginPage.open();
		getDriver().manage().window().maximize();
	}
    
    public void supplyLoginCredientials(String username, String password){
    	loginPage.supplyLogin_Credientials(username, password);
    }

    public void loginSuccessful() {
    	
    	loginPage.clickOnLogin();
    	waitABit(3000);
    }	
    
    public void accessNewAccountPage() {
    	
    	SalesforceGlueAccountPage accountPage = getPages().get(SalesforceGlueAccountPage.class);
		homePage.AccountsTab();
//		accountPage.newAccount();
    }
    
    public void searchForAnAccountUsingAccountName(String keyword) {
    	waitABit(1000);
    	SalesforceGlueAccountPage accountPage = getPages().get(SalesforceGlueAccountPage.class);
    	accountPage.newAccountChild(keyword);
    }
    	
    public void accessNewAccountsPageviaSearchResults() {
    	SalesforceGlueAccountPage accountPage = getPages().get(SalesforceGlueAccountPage.class);
		accountPage.newAccountButtonFromSearchResultsSection();
    }
    
/**************************************************CSVFile
 * @throws IOException **********************************************/
    public void read_csv_input(String file) throws IOException {

    	SalesforceGlueAccountPage accountPage = getPages().get(SalesforceGlueAccountPage.class);
    	accountPage.read_input(file);
	}
 
}