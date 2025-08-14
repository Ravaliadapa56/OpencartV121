package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	@Test(groups= {"Regression", "Master"})
	public void verify_account_registration()
	{
		
		logger.info("*********Starting TC001_AccountRegistrationTest***********");
		
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount...");
		
		
		hp.clickRegister();
		logger.info("Clicked on Register...");
		
		AccountRegistrationPage ar= new AccountRegistrationPage(driver);
		
		logger.info("Providing the details...");
		ar.setFirstName(randomString().toUpperCase());
		ar.setLastName(randomString().toUpperCase());
		ar.setEmail(randomString()+"@gmail.com");	//randomly generate email
		ar.setTelephone(randomNumber());
		
		String password= randomAlphanumeric();
		System.out.println(password);
		
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		
		ar.setPrivacyPolicy();
		ar.clickContinue();
		
		logger.info("Validating the message...");
		String confirmationMsg= ar.getConfirmationMsg();
		AssertJUnit.assertEquals(confirmationMsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs......");
			Assert.fail();
		
	}
		}
	
	
	

}
