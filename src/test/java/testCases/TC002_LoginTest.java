package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("******Strating TC_002_LoginTest******");
		try
		{
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		
		lp.clickLogin();
		
		
		MyAccountPage ap= new MyAccountPage(driver);
		boolean targetPage=ap.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPage, true, "Login failed");
		Assert.assertTrue(targetPage);
		
		logger.info("*******Completed TC_002_LoginTest******");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
