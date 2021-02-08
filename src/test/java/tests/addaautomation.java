package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.security.Timestamp;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class addaautomation {
	public static AndroidDriver driver;
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.UDID, "cf27ceaa7d31"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9 PPR1.180610.011");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		caps.setCapability("appPackage", "com.threefiveeight.adda");
		caps.setCapability("appActivity", ".login.LoginActivity");
		caps.setCapability("automationName", "Appium");
		caps.setCapability("ignoreHiddenApiPolicyError", true);
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeyboard", false);
		caps.setCapability("ignoreUnimportantViews", true);
		caps.setCapability("disableAndroidWatchers", true);
		/*caps.setCapability("noReset", "true");
		caps.setCapability("automationName", "Appium");
		caps.setCapability("fullReset", "false");
		caps.setCapability("appPackage", "com.threefiveeight.adda");
		//cape.setCapability("appActivity",".apartmentaddaactivity.SplashScreenActivity");
		caps.setCapability("appActivity", ".login.LoginActivity");
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeyboard", false);
		caps.setCapability("ignoreUnimportantViews", true);
		caps.setCapability("disableAndroidWatchers", true); */


		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		Thread.sleep(2000);
	}
	@Test (priority=1)
	public void openapp() throws InterruptedException {
		//System.out.println("Test Passed");
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_switch_email_mobile")).click(); //swith to login with emailid
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/et_email_id")).sendKeys("test90923@gmail.com");  //enter email id
		driver.findElement(By.id("com.threefiveeight.adda:id/et_password")).sendKeys("adda1234"); //enter password
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_login")).click(); //click login

		Thread.sleep(6000);
		//try catch to handle if already logged in popup appears
		try{
			if(driver.findElement(By.id("com.threefiveeight.adda:id/tvOk")).isDisplayed())
			{driver.findElement(By.id("com.threefiveeight.adda:id/tvOk")).click(); 

			Thread.sleep(6000);
			}
		}
		catch (Exception e)
		{
			//System.out.println(e);
			System.out.println("Already logged in popup not displayed");
		}

		//try catch to handle if confirm number screen appears
		try{
			if(driver.findElement(By.id("com.threefiveeight.adda:id/confirm_action")).isDisplayed())
			{ 
				driver.findElement(By.id("com.threefiveeight.adda:id/confirm_action")).click();
			}
		}
		catch(Exception e)
		{
			//System.out.println(e);
			System.out.println("Confirm mobile number not displayed");

		}

		//Try catch to handle if rating screen appears
		try{
			if(driver.findElement(By.id("com.threefiveeight.adda:id/iv_cancel")).isDisplayed())
			{driver.findElement(By.id("com.threefiveeight.adda:id/iv_cancel")).click();
			}
		}
		catch(Exception e)
		{
			//System.out.println(e);
			System.out.println("Rating screen not displayed");
		}

		Thread.sleep(2000);




		//Try catch to handle app tour

		try{	
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/fl_discover_pager")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/tv_label_discover")).click();
			Thread.sleep(2000);

		}
		catch(Exception e)
		{
			//System.out.println(e);
			System.out.println("App tour not displayed");
		}
		Thread.sleep(2000);	
	}
	
/*	@Test (priority=2)
	public static void PostCoversation() throws InterruptedException, IOException
	{
		
			
    Thread.sleep(2000);
    String	scrollUpward="com.threefiveeight.adda:id/tv_label_shortcuts";
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""+scrollUpward+"\"))");
	String visibleText="Post";
	driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\").instance(0)").click();
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String Topic = "Test Conversation-Automation" +timestamp;
	
	String Description="Test automation sample message"+timestamp;
	driver.findElement(By.id("com.threefiveeight.adda:id/etForumTopic")).sendKeys(Topic);
	driver.findElement(By.id("com.threefiveeight.adda:id/etForumDescription")).sendKeys(Description);
	driver.findElement(By.id("com.threefiveeight.adda:id/post")).click();
	Thread.sleep(3000);
	
	
	} 

	@Test (priority=3)
	public static void CreateHelpdesk() throws InterruptedException
	{
			//******Create helpdesk*******
		Thread.sleep(2000);

		String	scrollUpward="com.threefiveeight.adda:id/tv_label_shortcuts";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""+scrollUpward+"\"))");
		String Ticket="Lodge Ticket";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Ticket+"\").instance(0)").click();
	
	    WebElement dropdownelement = driver.findElement(By.id("com.threefiveeight.adda:id/et_category"));
		
		Thread.sleep(2000);
		
		dropdownelement.click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView").click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_male")).click();
		String ticket1="Test comment";
		driver.findElement(By.id("com.threefiveeight.adda:id/et_issue")).sendKeys(ticket1);
		Thread.sleep(3000);
		String	scrolldown="com.threefiveeight.adda:id/btn_post";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""+scrolldown+"\"))").click();
		//driver.findElement(By.id("com.threefiveeight.adda:id/btn_post")).click();
		Thread.sleep(2000);
		
		//***** Clicking back from success screen of helpdesk ticket********
		
		driver.findElement(By.id("com.threefiveeight.adda:id/iv_back")).click();
		Thread.sleep(2000);
		
	} */
	 @Test (priority=5)
		
		public static void CreatePoll() throws InterruptedException, IOException
		{
		 String	scrollUpward="com.threefiveeight.adda:id/tv_label_shortcuts";
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""+scrollUpward+"\"))");
		
		driver.findElement(By.id("com.threefiveeight.adda:id/iv_more")).click();
		String createPoll="Create Poll";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+createPoll+"\")").click(); //Click on create poll 
		Thread.sleep(2000);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String pollTopic="Test Poll"+timestamp;
		driver.findElement(By.id("com.threefiveeight.adda:id/etPollTopic")).sendKeys(pollTopic);
		driver.findElement(By.id("com.threefiveeight.adda:id/etPollQuestion")).sendKeys("Test poll description");
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Option 1\")").sendKeys("Yes");
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Option 2\")").sendKeys("No");
		driver.findElement(By.id("com.threefiveeight.adda:id/post")).click();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+pollTopic+"\").instance(0))");
	
		
		}
     
	@AfterTest
	public void teardown() {

	}

}
