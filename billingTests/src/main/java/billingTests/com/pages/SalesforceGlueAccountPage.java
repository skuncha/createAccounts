package billingTests.com.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import net.thucydides.core.Thucydides;
import net.thucydides.core.csv.CSVTestDataSource;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Srinivasa.Kuncha
 * @see CreateDirectOrders
 */
public class SalesforceGlueAccountPage  extends PageObject {
//	int i=0;
	int j=1;
	int synctimeforSOPID = 5;
	String ref, financeID,clientURL;
	String[] customerUniqueID;
	ArrayList<String> arraylist = new ArrayList<String>(); 

/***********************************************************************WEB ELEMENTS************************************************************************************/
	private WebElementFacade salutation() 		 { return element(By.id("00ND0000005jggD"));							}
	private WebElementFacade firstname() 		 { return element(By.id("00ND0000005jgg9"));							}
	private WebElementFacade parentAccount()     { return element(By.cssSelector("#acc3"));								}
	private WebElementFacade phoneNumber()       { return element(By.cssSelector("#acc10"));							}
	private WebElementFacade accountName()       { return element(By.cssSelector("#acc2"));								}
	private WebElementFacade selectAccountType() { return element(By.id("p3")); 										}
	private WebElementFacade selectTypeOfAccount() { return element(By.id("acc6")); 									}
	private WebElementFacade billingStreet()     { return element(By.cssSelector("#acc17street"));       				}
	private WebElementFacade billingPostCode()   { return element(By.cssSelector("#acc17zip"));							}
	private WebElementFacade newButton() 		 { return element(By.cssSelector("input[value=' New ']"));				}
	private WebElementFacade readAccountName()   { return element(By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2"));  }
	private WebElementFacade mainCate()           { return element(By.name("j_id0:j_id1:j_id27:j_id36"));				}
	private WebElementFacade subCate()            { return element(By.name("j_id0:j_id1:j_id27:subcategory"));			}
	private WebElementFacade minorCate()          { return element(By.name("j_id0:j_id1:j_id27:minor"));				}
	private WebElementFacade saveIndCate()        { return element(By.name("j_id0:j_id1:j_id27:j_id28:j_id29"));		}
	private WebElementFacade newAccountButtonChild() { return element(By.cssSelector("input[value='New Account']"));	}
	private WebElementFacade continueButt()          { return element(By.cssSelector("input[value='Continue']")); 		}
	private WebElementFacade searchCustomerName() 	{ return element(By.xpath("//td[contains(label,'Customer Name or Aliases')]/input"));		}
	private WebElementFacade createDirectOrder() 	{ return element(By.cssSelector("input[value='Create Direct Order']"));						}
	private WebElementFacade billingSelection() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Selection.input"));					}
	private WebElementFacade billingOption() 	    { return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Options.input"));						}
	private WebElementFacade billingOption1() 	    { return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Options_0.input"));					}
	private WebElementFacade billingSelectionNext() { return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));								}
	private WebElementFacade finish() 				{ return element(By.cssSelector("input[value='Finish']"));									}
	private WebElementFacade CCICustomerMail()      { return element(By.cssSelector("input[value='Create CCI Customer-Mail']"));				}
	private WebElementFacade accountType() 			{ return element(By.id("j_id0:j_id1:i:f:pb:d:Account4Contact.input"));		}
	private WebElementFacade emailAddress() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:EmailAddress.input"));			}
	private WebElementFacade contactNext() 			{ return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));				}
	private WebElementFacade conSalutation() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:Salutation.input"));			}
	private WebElementFacade conFirstName() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:FirstName.input"));			}
	private WebElementFacade conLastName() 			{ return element(By.id("j_id0:j_id1:i:f:pb:d:LastName.input"));				}
	private WebElementFacade conPhonenumebr() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:Phone.input"));				}
	
	@FindBy(how = How.LINK_TEXT, using = "Accounts")
	private WebElement accounts;
	@FindBy(how = How.XPATH, using = "//div[@class='pbBottomButtons']//input[@value='Search']")
	private WebElement customerSearchButton;
	@FindBy(how = How.CSS, using = "input[value=' Save ']")
	private WebElement saveButton;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "AM-")
	private WebElement accountMapping;
	/*@FindBy(how = How.PARTIAL_LINK_TEXT, using = "-Mail Advertising")
	private WebElement financeAccount;*/
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "- Mail")
	private WebElement financeAccount;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "- Mail")
	private WebElement FFfinanceAccount;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "W8 5TT")
	private WebElement privateAdvFinanceAccount;
	private WebElementFacade FinanceAccNum()     { return element(By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr[3]/td[2]"));}
	private WebElementFacade CCIMailCustomerID() { return element(By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr[5]/td[4]"));}
	private WebElementFacade CustomerID() 		{ return element(By.xpath("//*[@id='ep']/div[2]/div[2]/table/tbody/tr[4]/td[2]"));}

//	private WebElementFacade SOPID() 			 { return element(By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr[9]/td[2]"));}
	private WebElementFacade SOPID() 			 { return element(By.xpath("//*[@id='ep']/div[2]/div[2]/table/tbody/tr[4]/td[4]"));}
	private WebElementFacade FFSOPID() 			 { return element(By.xpath("//*[@id='ep']/div[2]/div[2]/table/tbody/tr[5]/td[2]")); }
	
	@FindBy(how = How.XPATH, using = "//input[@title='New Relationship']")
	private WebElement newRelationship;
	private WebElementFacade accountB_Name() 	  { return element(By.id("CF00ND0000003g0n9"));							}
	private WebElementFacade billing() 			  { return element(By.id("00ND0000003g0nB"));							}
	@FindBy(how = How.XPATH, using = "//td[@id='bottomButtonRow']/input[@title='Save']")
	private WebElement saveRelationship;
	private WebElementFacade billingRef()        { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Billing_AgenciesList.input']/option[1]"));}
	private WebElementFacade selectBillingRef()  { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Account4Contact.input']/option[1]"));		}
	private WebElementFacade busyIntegrating() 	 { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Msg']"));				                    }
	private WebElementFacade syncNext() 		 { return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));				                        }
	
/***********************************************************************WEB ELEMENTS************************************************************************************/
	public void type(String mytype) {
    	Select droplist = new Select(find(By.id("acc6")));   
    	droplist.selectByVisibleText(mytype);
    }
    
    public void newAccount() {
    	newButton().click();
    }
     
    public void newAccountChild(String keyword) {
    	
    	waitFor(8).second();
    	searchCustomerName().type(keyword);
    	customerSearchButton.click();
    	waitFor(5).second();
    }
    
    public void newAccountButtonFromSearchResultsSection() {
    	waitFor(1).second();
    	newAccountButtonChild().click();
    }
    
    public void accountMapping(){
    	
    	accountMapping.click();
    	waitFor(3).seconds();
    	System.out.print("Customer Ref = "+CustomerID().getText()  +" + ");
    	getDriver().navigate().back();
    	waitFor(5).seconds();
    }
    
    public void accountCreation(){
    		waitFor(1).seconds();
    		accounts.click();
    		waitFor(5).seconds();
			searchCustomerName().type("xyz");
	    	customerSearchButton.click();
	    	waitFor(3).seconds();
	    	newAccountButtonChild().click();
	    	waitFor(3).seconds();
    }
    
    public void CCIMailIntegration(){
    	
    	CCICustomerMail().click();
    	waitFor(4).seconds();
		getDriver().switchTo().alert().accept();  
		waitFor(15).seconds();
		getDriver().switchTo().alert().accept(); 
		waitFor(5).seconds();
    }
    
/**************************************************************CSVFile 
 * @throws IOException *****************************************************/
    public void read_input(String fileLoc) throws IOException {
    	System.out.println("\n");
		File filePath = new File(fileLoc);
		if (filePath.isFile()) {
			String file = filePath.getAbsolutePath();
				CSVTestDataSource testDataSrc = new CSVTestDataSource(file);
				for (Map<String, String> record : testDataSrc.getData()) {
				try{
/************** Select Agency Type ******************************************/  
				    selectAccountType().selectByVisibleText(record.get("type"));
				    continueButt().click();
				    long timeNow = System.currentTimeMillis();
/************** Supply User Account details ********************************/  
				    waitFor(5).seconds();
				    String str = record.get("accountType");
				    selectTypeOfAccount().selectByVisibleText(record.get("accountType"));
			    	accountName().type(record.get("lastName") + " - "+ timeNow);
			    	phoneNumber().type(record.get("phone"));
			    	billingStreet().type(record.get("billingStreet"));
			    	billingPostCode().type(record.get("postalCode"));

					    	if (str.equalsIgnoreCase("Brand")) {
								parentAccount().type(record.get("parentAccount"));
								waitABit(1000);
							}
			    	 
					    	if (str.equalsIgnoreCase("Private Advertiser")) {
					    		 salutation().selectByVisibleText(record.get("salutation"));
				    		     firstname().type(record.get("firstName"));
					    	}
			    	
					    	if (str.equalsIgnoreCase("Direct Advertiser") || str.equalsIgnoreCase("Charity") || str.equalsIgnoreCase("Brand")|| str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
					    	{
					    		waitABit(1000);
								saveButton.click();
								waitFor(8).seconds();
								Thucydides.takeScreenshot();
								String Name = readAccountName().getText();
						    	arraylist.add(Name);
						    	clientURL = getDriver().getCurrentUrl();
						    	customerUniqueID = clientURL.split("com/");
						    	System.out.print(" " +j++ + ". " + "Unique ID : " +customerUniqueID[1] + "  +  ");
/**************************************************************************/ 
									    	if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
									    	{
										    		String readClientAccountName = readAccountName().getText();
										    		clientURL = getDriver().getCurrentUrl();
										    		accountCreation();
										    		selectAccountType().selectByVisibleText("Agency"); //Create Billing a/c
										    		continueButt().click();
										    		waitFor(3).seconds();
													accountName().type("Billing Agency " + timeNow);
										    		phoneNumber().type(record.get("phone"));
											    	billingStreet().type(record.get("billingStreet"));
											    	billingPostCode().type(record.get("postalCode"));
											    	waitFor(1).seconds();
													saveButton.click();
													waitFor(8).seconds();
													CCIMailIntegration(); // CCIMail Integration
													financeAccount.click(); 
//													FFfinanceAccount.click(); 
													waitFor(5).seconds();
													String id = SOPID().getText();
//													String id = FFSOPID().getText();
													while(id.equals(" ")) 
													   {
															waitFor(2).seconds();
															getDriver().navigate().back();
															waitFor(12).seconds();
															financeAccount.click();
//															FFfinanceAccount.click(); 
															waitFor(5).seconds();
															id = SOPID().getText();
//															id = FFSOPID().getText();
															synctimeforSOPID = synctimeforSOPID + 20;
														}
													financeID = id;
													System.out.print("Account Name : "+arraylist.get(0) +  " +  SOPID : " +financeID + " + ");
													getDriver().navigate().back();
													waitFor(6).seconds();
													newRelationship.click(); 
													waitFor(3).seconds();
													accountB_Name().type(readClientAccountName);
											    	billing().selectByVisibleText("Billing");
											    	saveRelationship.click();
											    	waitFor(4).seconds();
											    	getDriver().get(clientURL); // Back to client account page
											    	waitFor(5).seconds();
									    	}
/************** Select Industry Category **********************************/
							    	getDriver().switchTo().frame("066D0000000kh27");
							    	WebElement editable = getDriver().switchTo().activeElement();
							    	editable.findElement(By.cssSelector("input[name='j_id0:j_id1:j_id27:j_id28:j_id31']")).click();
							    	waitFor(3).seconds();
						    	   	mainCate().selectByVisibleText(record.get("mainCategory"));
						    	   	waitFor(4).seconds();
							 	    subCate().selectByVisibleText(record.get("subCategory"));
							 	    waitFor(4).seconds();
							 	    minorCate().selectByVisibleText(record.get("minorCategory"));
							 	    waitFor(3).seconds();
							 	    saveIndCate().sendKeys(Keys.RETURN);
							 	    waitFor(4).seconds();
								    getDriver().switchTo().defaultContent();
					    	}
						    	else 
						    	{
						    	saveButton.click();
						    	waitFor(8).seconds();
						    	String Name = readAccountName().getText();
						    	arraylist.add(Name);
						    	Thucydides.takeScreenshot();
						    	clientURL = getDriver().getCurrentUrl();
						    	customerUniqueID = clientURL.split("com/");
						    	System.out.print(" " +j++ + ". " + "Unique ID : " +customerUniqueID[1] + "  +  ");
						    	}
									if (str.equalsIgnoreCase("Direct Advertiser") || str.equalsIgnoreCase("Charity") || str.equalsIgnoreCase("Brand")|| str.equalsIgnoreCase("Private Advertiser"))
									{
										
										 CCIMailIntegration(); // CCIMail Integration
										 waitFor(3).seconds();
										 accountMapping(); /**************  Account Mapping  *******************************************/
										 
												if (str.equalsIgnoreCase("Private Advertiser")){
													financeAccount.click();
//													privateAdvFinanceAccount.click();   /***** DEPENDENDT ON POSTCODE SUPPLIED*************/
													waitFor(5).seconds();
													String id = SOPID().getText();
													
												} 
												else 
													{ 
														financeAccount.click(); 
//														FFfinanceAccount.click(); 
													}	
												
												waitFor(4).seconds();
												String id = SOPID().getText();
//												String id = FFSOPID().getText();
												while(id.equals(" ")) 
												  {
														waitFor(2).seconds();
														getDriver().navigate().back();
														waitFor(12).seconds();
														financeAccount.click();
//														FFfinanceAccount.click(); 
														waitFor(5).seconds();
														id = SOPID().getText();
//														id = FFSOPID().getText();
														synctimeforSOPID = synctimeforSOPID + 20;
													}
										 financeID = id;
//										 ref =CCIMailCustomerID().getText();
										System.out.print("Account Name : "+arraylist.get(0) +  " +  SOPID : " +financeID + " + ");
										getDriver().navigate().back(); 
									}
									else {
										CCIMailIntegration();
									}
						waitFor(5).seconds();
						Thucydides.takeScreenshot();
						createDirectOrder().click();
/**************  Select Order Type *************************************************************/
				    	
						if (str.equalsIgnoreCase("Direct Advertiser") || str.equalsIgnoreCase("Charity") || str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
				    	{
							waitFor(6).seconds();
							
							    	if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group"))
							    	{
							    		
							    		billingRef().click();
							    		billingSelectionNext().click();
							    		waitFor(5).seconds();
								    		try {
								    			 while(busyIntegrating().getText()!=null) {
								    				 
								    				 waitFor(20).seconds();
								    				 syncNext().click();
								    				 synctimeforSOPID = synctimeforSOPID + 20;
								    			 }
								    		} catch (Exception e) {}
							    	}
							    	else {
							    		
							    		billingSelection().selectByVisibleText("Direct");
									 	billingSelectionNext().click();  
							    	}
				    	}	
					if (str.equalsIgnoreCase("Brand"))
					{
						try{
						waitFor(3).seconds();
			    		billingOption().selectByVisibleText("Direct");
						} catch (Exception noSuchelement) {
						billingOption1().selectByVisibleText("Direct");
						}
			    		billingSelectionNext().click(); 
			    	}
/**************  Create Contact ******************************************************************/
					String contact = record.get("firstName").concat(" ").concat(record.get("lastName")); // added
					 	waitFor(4).seconds();
						conSalutation().selectByVisibleText(record.get("salutation"));
		    		    conFirstName().type(record.get("firstName"));
		    		    conLastName().type(record.get("lastName"));
				    	emailAddress().type(record.get("email"));
					   	conPhonenumebr().type(record.get("phone"));
					   	System.out.println(" Contact : "+contact ); 	// added
/**************  Associate Account*****************************************************************/			    	
					   	if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
					   	{
				    		selectBillingRef().click();
				    		waitFor(1).seconds();
//				    		i++;
				    	}
						   	else 
						   	{
						   		String endUseraccount = arraylist.get(0);
								accountType().selectByVisibleText(endUseraccount);
								waitFor(1).seconds();
//								i++;
						   	}
						contactNext().click();
						waitFor(2).seconds();
						arraylist.clear();
//						accountCreation();
						waitFor(1).seconds();
						/*finish().click();
						waitFor(10).seconds();*/
/************************************************************************************************/						
				} 
				catch (Exception e1)
				{
					System.out.println("    ---> Sorry latency issue can't create this account ");
//					i++;
					arraylist.clear();
				} 
				accountCreation();
			}
			waitABit(1000);
		}
	}
}
