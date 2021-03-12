package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.security.Timestamp;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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
		Thread.sleep(2000);
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

	//create post
	/*@Test (priority=2)
	public static void PostCoversation() throws InterruptedException, IOException
	{	
		Thread.sleep(2000);
		//String	scrollUpward="com.threefiveeight.adda:id/tv_label_gate_updates";
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""+scrollUpward+"\"))");
		driver.findElement(By.id("com.threefiveeight.adda:id/iv_add_shortcuts")).click();
		Thread.sleep(1000);
		String visibleText="Post";
		String visibleText1="Conversation";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\").instance(0)").click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText1+"\").instance(0)").click();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String Topic = "Test Community Post-Automation" +timestamp;

		String Description="Test automation sample message"+timestamp;
		driver.findElement(By.id("com.threefiveeight.adda:id/etForumTopic")).sendKeys(Topic);
		driver.findElement(By.id("com.threefiveeight.adda:id/etForumDescription")).sendKeys(Description);
		driver.findElement(By.id("com.threefiveeight.adda:id/post")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.threefiveeight.adda:id/navigation_home")).click(); 


	} */

	//Create helpdesk ticket
	@Test (priority=3)
	public static void CreateHelpdesk() throws InterruptedException
	{

		Thread.sleep(1000);
        driver.findElement(By.id("com.threefiveeight.adda:id/iv_add_shortcuts")).click();
		Thread.sleep(1000);
		String visibleText="Helpdesk";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\").instance(0)").click();
		WebElement dropdownelement = driver.findElement(By.id("com.threefiveeight.adda:id/et_category"));
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

	} 
	//Create Poll
	@Test (priority=5)

	public static void CreatePoll() throws InterruptedException, IOException
	{
		driver.findElement(By.id("com.threefiveeight.adda:id/iv_add_shortcuts")).click();
		Thread.sleep(1000);
		String visibleText="Post";
		String visibleText1="Poll";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\").instance(0)").click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText1+"\").instance(0)").click();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String pollTopic="I am A TEST"+timestamp;
		driver.findElement(By.id("com.threefiveeight.adda:id/etPollTopic")).sendKeys(pollTopic);
		driver.findElement(By.id("com.threefiveeight.adda:id/etPollQuestion")).sendKeys("Test description");
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Option 1\")").sendKeys("Yes");
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Option 2\")").sendKeys("No");
		driver.findElement(By.id("com.threefiveeight.adda:id/post")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.threefiveeight.adda:id/navigation_home")).click(); 


	}
	//Book facility
	@Test (priority=6)
	public static void bookFacility() throws InterruptedException
	{ 
		driver.findElement(By.id("com.threefiveeight.adda:id/iv_add_shortcuts")).click();
		Thread.sleep(1000);
		String visibleText="Book Facility";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\").instance(0)").click();
		String Facilityscreen="Facilities";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Facilityscreen+"\").instance(0)").click();
		String bookedFacility="Hour";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+bookedFacility+"\").instance(0)").click();

		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Select Date\").instance(0)").click();
		LocalDate localDate =java.time.LocalDate.now();   //Getting current date
		int Day = localDate.getDayOfMonth()+1;              //Extract day out of date
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Day+"\")").click(); //Selecting from calendar day
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();

		driver.findElement(By.id("com.threefiveeight.adda:id/from_time_tv")).click();
		driver.findElement(By.id("android:id/toggle_mode")).click();
		driver.findElement(By.id("android:id/input_hour")).click();
		driver.findElement(By.id("android:id/input_hour")).clear();
		driver.findElement(By.id("android:id/input_hour")).sendKeys("01");
		driver.findElement(By.id("android:id/input_minute")).click();
		driver.findElement(By.id("android:id/input_minute")).clear();
		driver.findElement(By.id("android:id/input_minute")).sendKeys("30");
		driver.findElement(By.id("android:id/am_pm_spinner")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"AM\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();

		driver.findElement(By.id("com.threefiveeight.adda:id/to_time_tv")).click();
		driver.findElement(By.id("android:id/toggle_mode")).click();
		driver.findElement(By.id("android:id/input_hour")).click();
		driver.findElement(By.id("android:id/input_hour")).clear();
		driver.findElement(By.id("android:id/input_hour")).sendKeys("02");
		driver.findElement(By.id("android:id/input_minute")).click();
		driver.findElement(By.id("android:id/input_minute")).clear();
		driver.findElement(By.id("android:id/input_minute")).sendKeys("30");
		driver.findElement(By.id("android:id/am_pm_spinner")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"AM\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();

		driver.findElement(By.id("com.threefiveeight.adda:id/et_notes")).sendKeys("Test");

		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"BOOK\")").click();

		Thread.sleep(2000);
		//driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();
		driver.findElement(By.id("android:id/button1")).click();

		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click(); //Click on back icon

		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Booking History\")").click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/dialog_positive_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	}
	//Expected Visitor
	/*@Test (priority=7)

	public static void addvisitor() throws InterruptedException, IOException
	{
		driver.findElement(By.id("com.threefiveeight.adda:id/navigation_home")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.ImageView")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/imageView6")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_exp_vis_submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_view_all")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/ll_delete")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/dialog_positive_button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Helpers']/android.widget.TextView")).click();
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	}
	//Pay Due
	@Test (priority=8)
	public static void payDue() throws InterruptedException
	{				
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/navigation_my_unit")).click();
		Thread.sleep(2000);
		driver.findElementById("com.threefiveeight.adda:id/b_pay_dues").click();
		Thread.sleep(4000);
		driver.findElementById("com.threefiveeight.adda:id/ctvSelectBill").click();
		Thread.sleep(2000);
		driver.findElementById("com.threefiveeight.adda:id/tvProceedPayment").click();	
		Thread.sleep(3000);
		//driver.findElementByXPath("//android.widget.TextView[@text='UPI']").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"UPI\")").click();
		Thread.sleep(3000);
		driver.findElementById("com.threefiveeight.adda:id/tvPayPayment").click();
		Thread.sleep(15000);

		// driver.findElementById("android.widget.Button").click();
		//Thread.sleep(4000);
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click(); //Click on back icon
		Thread.sleep(2000);
		//driver.findElement(By.id("com.threefiveeight.adda:id/navigation_home")).click(); //click on Home

	}


	//Validate GK link in my unit
	@Test (priority=9)
	public static void validateGkLink() throws InterruptedException
	{   
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_gk_shortcut")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click();
	}

	//Add Member
	@Test (priority=10)
	public static void AddMember() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Members\")").click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/fab_expand_menu_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/fabAddMember")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/etFirstName")).sendKeys("Test");
		driver.findElement(By.id("com.threefiveeight.adda:id/etLastName")).sendKeys("Member");
		driver.findElement(By.id("com.threefiveeight.adda:id/etEmail")).sendKeys("TestMember1@yopmail.com");
		driver.findElement(By.id("com.threefiveeight.adda:id/etMobile")).sendKeys("9999999999");
		driver.findElement(By.id("com.threefiveeight.adda:id/etMemberNotes")).sendKeys("Test");
		driver.findElement(By.id("com.threefiveeight.adda:id/rdOwner")).click();
		driver.findElement(By.id("com.threefiveeight.adda:id/menuAdd")).click();
		Thread.sleep(2000);


		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/navigation_home")).click(); 

	}


	//Direct message
	@Test (priority=11)

	public static void directMsg () throws InterruptedException, IOException
	{

		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/iv_more")).click();
		String chat="Chat";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+chat+"\")").click(); //Click on create poll 
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Neighbours\")").click();
		driver.findElement(By.id("com.threefiveeight.adda:id/ivMessageIcon")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/etMessage")).sendKeys("Hi hello");
		driver.findElement(By.id("com.threefiveeight.adda:id/ivSendMessage")).click();
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click();
	} */
	@AfterTest
	public void teardown() {

	}

}
