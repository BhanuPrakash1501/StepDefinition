package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {

	AppiumDriverLocalService service;
	AndroidDriver driver;

	@Given("open the My airports app from the mobile device")
	public void open_the_my_airports_app_from_the_mobile_device() throws InterruptedException, MalformedURLException {

//	  service = new AppiumServiceBuilder() .withAppiumJS(new File(
//		 "C:\\Users\\Mind-Graph\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
//		 )) .withIPAddress("127.0.0.1").usingPort(4723).build();
//	 
//	 service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 6 Pro API 34");
		options.setApp("C:\\Users\\Mind-Graph\\eclipse\\CucumberProject\\src\\test\\java\\resources\\prod.apk");

		// Thread.sleep(20000);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		Thread.sleep(20000);
		System.out.println("inside MobileApp");
	}

	@Then("close the mobile app")
	public void close_the_mobile_app() {

		driver.quit();
		// service.stop();

	}

	@Given("Click on the Login button in splash screen")
	public void click_on_the_login_button_in_splash_screen() throws InterruptedException {

		System.out.println("Click on Login Button");

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN / SIGN UP   | \"]")).click();

		Thread.sleep(2000);

	}

	@Given("Give the login credentials and click on the Submit button")
	public void give_the_login_credentials_and_click_on_the_submit_button() throws InterruptedException {

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Email ID\"]"))
				.sendKeys("iotuatproject@gmail.com");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Enter Password\"]"))
				.sendKeys("IOTuat@123");
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SUBMIT\"]")).click();
		Thread.sleep(15000);
		driver.switchTo().alert().accept();

	}

	@Then("Click on the Feedback Icon in the my profile page")
	public void click_on_the_feedback_icon_in_the_my_profile_page() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView[1]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.widget.ImageView"))
				.click();

	}

	@Then("Click on the X Button in Feedback Landing page")
	public void click_on_the_x_button_in_feedback_landing_page() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"))
				.click();

	}

	@Then("click on Give a compliment button")
	public void click_on_give_a_compliment_button() throws InterruptedException {
		Thread.sleep(8000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Give a Compliment\"]"));
		System.out.println(e.getText());
		/*
		 * if(e.getText().equals("Give a Compliment")) { driver.findElement(AppiumBy.
		 * xpath("//android.widget.TextView[@text=\"Give a Compliment\"]")).click(); }
		 * else { System.out.println("Button not found"); }
		 */
		if (e.isDisplayed()) {
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Give a Compliment\"]")).click();
		} else {
			System.out.println("Button not found");
		}

	}

	@Then("click on Make a Suggestion Button")
	public void click_on_make_a_suggestion_button() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Make a Suggestion\"]")).click();

	}

	@Then("click on File a Complaint button")
	public void click_on_File_a_Complaint_button() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"File a Complaint\"]")).click();
	}

	@Then("Click on Previous Button")
	public void click_on_previous_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Previous\"]")).click();

	}

	@Given("click on Terminal one")
	public void click_on_terminal_one() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"KUL Terminal 1\"]")).click();
	}

	@Given("Validate the Functionality of Are you a passenger as YES")
	public void validate_the_functionality_of_are_you_a_passenger_as_yes() throws InterruptedException {
		Thread.sleep(1000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Yes\"]"));

		if (e.getText().equals("Yes")) {

			// System.out.println("KUL Terminal 2");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
					.click();
		} else {
			System.out.println("Radio button is not selected");
		}
	}

	@Then("select the travel type as International")
	public void select_the_travel_type_as_international() throws InterruptedException {
		Thread.sleep(1000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"International\"]"));

		if (e.getText().equals("International")) {

			driver.findElement(AppiumBy.xpath(
					"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
					.click();
		} else {
			System.out.println("International option is not selected");
		}

	}

	@Then("click on You are\\/were as Departing")
	public void click_on_you_are_were_as_departing() throws InterruptedException {
		Thread.sleep(1000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Departing\"]"));

		if (e.getText().equals("Departing")) {

			driver.findElement(AppiumBy.xpath(
					"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
					.click();
		} else {
			System.out.println("Departing option is not selected");
		}

		// android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView
	}

	@Then("click on touch point")
	public void click_on_touch_point() throws InterruptedException {

		Thread.sleep(5000);

		// //android.widget.EditText[@text="E-hailing/Taxi/Shuttle bus service"]
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"E-hailing/Taxi/Shuttle bus service\"]"))
				.click();
		Thread.sleep(5000);

	}

	@Given("Enter Location Flight Number and Phone Number")
	public void enter_location_flight_number_and_phone_number() throws InterruptedException {

		// Enter Location
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Location\"]")).sendKeys("Testing");
		Thread.sleep(1000);

		// Flight Number
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Flight number\"]")).sendKeys("Testing");
		Thread.sleep(2000);

		// Scroll
		driver.findElement(new AppiumBy.ByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
						+ "Phone number" + "\").instance(0))"));
		Thread.sleep(2000);

		// Phone Number
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Phone number\"]")).sendKeys("Testing");
		Thread.sleep(2000);

	}

	@Given("click on Terminal Two")
	public void click_on_terminal_two() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"KUL Terminal 2\"]")).click();

	}

	@Then("select the travel type as Domestic")
	public void select_the_travel_type_as_domestic() throws InterruptedException {
		Thread.sleep(1000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Domestic\"]"));

		if (e.getText().equals("Domestic")) {

			driver.findElement(AppiumBy.xpath(
					"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
					.click();
		} else {
			System.out.println("Domestic option is not selected");
		}
	}

	@Given("Enter the text in Give a Compliment Text Box")
	public void enter_the_text_in_give_a_compliment_text_box() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Give a compliment\"]"))
				.sendKeys("Mobile Automation Testing please ignore");
		Thread.sleep(4000);
		/*
		 * driver.findElement(AppiumBy.xpath(
		 * "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"
		 * )) .click(); Thread.sleep(3000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.TextView[@text=\"PHOTO\"]")).click(); Thread.sleep(3000);
		 * driver.findElement(AppiumBy.
		 * xpath("//android.widget.TextView[@text=\"USE CAMERA\"]")).click();
		 * Thread.sleep(1000); driver.switchTo().alert().accept(); Thread.sleep(5000);
		 * driver.findElement(AppiumBy.
		 * xpath("//android.widget.TextView[@text=\"USE CAMERA\"]")).click();
		 * Thread.sleep(7000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.ImageView[@content-desc=\"Shutter\"]")).click();
		 * Thread.sleep(8000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.ImageButton[@content-desc=\"Done\"]")).click();
		 * Thread.sleep(7000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.TextView[@content-desc=\"Crop\"]")).click();
		 * Thread.sleep(5000);
		 */

	}

	@Then("Verify Rate your Experience stars should present in give a complaint page")
	public void verify_rate_your_experience_stars_should_present_in_give_a_complaint_page()
			throws InterruptedException {
		Thread.sleep(2000);
		WebElement e = driver.findElement(AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.ImageView"));

		if (e.isDisplayed()) {

			System.out.println("Rate your experience stars visible to User");
		} else {
			System.out.println("stars are not displaying to User");
		}

	}

	@Then("click on ratings button in Give a complaint page")
	public void click_on_ratings_button_in_give_a_complaint_page() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.ImageView"))
				.click();
	}

	@Then("click on submit button in Give a Compliment Page")
	public void click_on_submit_button_in_give_a_compliment_page() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SUBMIT\"]")).click();
		Thread.sleep(10000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView"))
				.click();

	}

	@Given("Capture the photo")
	public void capture_the_photo() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PHOTO\"]")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"USE CAMERA\"]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"USE CAMERA\"]")).click();
		Thread.sleep(7000);
		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Shutter\"]")).click();
		Thread.sleep(8000);
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]")).click();
		Thread.sleep(7000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Crop\"]")).click();
		Thread.sleep(5000);
	}

	@Then("Verify presence of Terminal one")
	public void verify_presence_of_terminal_one() throws InterruptedException {
		Thread.sleep(5000);
		WebElement e = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"You have selected: KUL Terminal 1\"]"));

		if (e.getText().equals("You have selected: KUL Terminal 1")) {

			System.out.println("KUL Terminal 1");
		} else {
			System.out.println("Terminal Not found");
		}
	}

	@Then("Enter the text in Make a suggestion Text Box")
	public void enter_the_text_in_make_a_suggestion_text_box() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Give your suggestion\"]"))
				.sendKeys("Mobile Automation Testing please ignore");
	}

	@Then("Verify presence of Rate your experince stars in Make a suggestion page")
	public void verify_presence_of_rate_your_experince_stars_in_make_a_suggestion_page() throws InterruptedException {
		Thread.sleep(2000);
		WebElement e = driver.findElement(AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.ImageView"));

		if (e.isDisplayed()) {

			System.out.println("Rate your experience stars visible to User");
		} else {
			System.out.println("stars are not displaying to User");
		}

	}

	@Then("click on ratings button in Make a suggestion page")
	public void click_on_ratings_button_in_make_a_suggestion_page() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.ImageView"))
				.click();
	}

	@Then("click on submit button in Make a suggestion Page")
	public void click_on_submit_button_in_make_a_suggestion_page() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SUBMIT\"]")).click();
		Thread.sleep(10000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView"))
				.click();
	}

	@Given("click on Terminal for File a Complaint button")
	public void click_on_terminal_for_file_a_complaint_button() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"KUL Terminal 1\"]")).click();

	}

	@Given("click on You are\\/were as Arriving")
	public void click_on_you_are_were_as_arriving() throws InterruptedException {
		Thread.sleep(1000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Arriving\"]"));

		if (e.getText().equals("Arriving")) {

			driver.findElement(AppiumBy.xpath(
					"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
					.click();
		} else {
			System.out.println("Arriving option is not selected");
		}
	}

	@Given("click on You are\\/were as Transit")
	public void click_on_you_are_were_as_transit() throws InterruptedException {
		Thread.sleep(1000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Transit\"]"));

		if (e.getText().equals("Transit")) {

			driver.findElement(AppiumBy.xpath(
					"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
					.click();
		} else {
			System.out.println("Transit option is not selected");
		}

	}

	@Given("Validate the Functionality of Are you a passenger as No")
	public void validate_the_functionality_of_are_you_a_passenger_as_no() throws InterruptedException {

		Thread.sleep(1000);
		WebElement e = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"No\"]"));

		if (e.getText().equals("No")) {

			// System.out.println("KUL Terminal 2");
			driver.findElement(AppiumBy.xpath(
					"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
					.click();
		} else {
			System.out.println("Radio button is not selected");
		}

	}

	@Then("click on touch point in T2")
	public void click_on_touch_point_in_t2() throws InterruptedException {
		Thread.sleep(3000);
		// //android.widget.TextView[@text="Prayer room"]
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Prayer room\"]")).click();
		Thread.sleep(3000);

	}

	@Then("Enter the text in desciption text box for give a complaint")
	public void enter_the_text_in_desciption_text_box_for_give_a_complaint() throws InterruptedException {
		// Description
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Description\"]"))
				.sendKeys("Mobile Automation Testing please ignore");
		Thread.sleep(4000);

		/*
		 * driver.findElement(AppiumBy.xpath(
		 * "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"
		 * )) .click(); Thread.sleep(3000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.TextView[@text=\"PHOTO\"]")).click(); Thread.sleep(3000);
		 * driver.findElement(AppiumBy.
		 * xpath("//android.widget.TextView[@text=\"USE CAMERA\"]")).click();
		 * Thread.sleep(1000); driver.switchTo().alert().accept(); Thread.sleep(5000);
		 * driver.findElement(AppiumBy.
		 * xpath("//android.widget.TextView[@text=\"USE CAMERA\"]")).click();
		 * Thread.sleep(7000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.ImageView[@content-desc=\"Shutter\"]")).click();
		 * Thread.sleep(15000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.ImageButton[@content-desc=\"Done\"]")).click();
		 * Thread.sleep(10000); driver.findElement(AppiumBy.xpath(
		 * "//android.widget.TextView[@content-desc=\"Crop\"]")).click();
		 * Thread.sleep(8000);
		 */
	}

	/*
	 * @Given("Enter Location then click on submit button") public void
	 * enter_location_then_click_on_submit_button() throws InterruptedException { //
	 * Enter Location driver.findElement(AppiumBy.xpath(
	 * "//android.widget.EditText[@text=\"Location\"]")).sendKeys("Testing");
	 * Thread.sleep(1000);
	 * 
	 * // Scroll driver.findElement(new AppiumBy.ByAndroidUIAutomator(
	 * "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
	 * + "Phone number" + "\").instance(0))")); Thread.sleep(2000);
	 * 
	 * // Phone Number driver.findElement(AppiumBy.
	 * xpath("//android.widget.EditText[@text=\"Phone number\"]")).sendKeys(
	 * "Testing"); Thread.sleep(2000);
	 * 
	 * 
	 * }
	 */

	@Given("send report")
	public void send_report() throws InterruptedException, IOException {
		// WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();
		driver1.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=16&ct=1700994484&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26RpsCsrfState%3d6c6eae09-d511-551f-f6d2-179a43ec1a55&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		driver1.manage().window().maximize();
		driver1.findElement(By.id("i0116")).sendKeys("bhanu.p@mind-graph.com");
		Thread.sleep(1000);
		driver1.findElement(By.id("idSIButton9")).click();
		Thread.sleep(5000);
		// idSIButton9
		driver1.findElement(By.id("i0118")).sendKeys("Mindgraph@123");
		Thread.sleep(500);
		driver1.findElement(By.id("idSIButton9")).click();
		Thread.sleep(500);
		driver1.findElement(By.id("idSIButton9")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath("//span[normalize-space()='New mail']")).click();
//i[@class='ms-Button-icon icon-288']//i[@class='Q0K3G ___198tor0 f14t3ns0 fne0op0 fg4l7m0 fmd4ok8 f1sxfq9t'][contains(text(),'')]

		Thread.sleep(3000);
		driver1.findElement(By.xpath("//div[@aria-label='To']")).sendKeys("mounika.cl@mind-graph.com");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@aria-label='To']")).sendKeys(Keys.ARROW_DOWN.ENTER);

		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='To']")).sendKeys("pravallika.k@mind-graph.com");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//div[@aria-label='To']")).sendKeys(Keys.ARROW_DOWN.ENTER);

		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys("veena.k@mind-graph.com");
		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys(Keys.ARROW_DOWN.ENTER);

		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys("venumadhav.g@mind-graph.com");
		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys(Keys.ARROW_DOWN.ENTER);

		Thread.sleep(3000);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys("bhanu.p@mind-graph.com");
		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys(Keys.ARROW_DOWN.ENTER);

		Thread.sleep(3000);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys("bhavani.p@mind-graph.com");
		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys(Keys.ARROW_DOWN.ENTER);
		
		Thread.sleep(3000);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys("bhargavi.b@mind-graph.com");
		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys(Keys.ARROW_DOWN.ENTER);

		Thread.sleep(3000);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys("krishna.g@mind-graph.com");
		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys(Keys.ARROW_DOWN.ENTER);
		
		//biswajit.panda@mind-graph.com
		Thread.sleep(3000);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys("biswajit.panda@mind-graph.com");
		Thread.sleep(500);
		driver1.findElement(By.xpath("//div[@aria-label='Cc']")).sendKeys(Keys.ARROW_DOWN.ENTER);

		Thread.sleep(500);
		// driver.findElement(By.xpath("//input[@aria-label = 'Add a
		// subject']")).click();
		driver1.findElement(By.xpath("//input[@aria-label = 'Add a subject']")).sendKeys("Automation Test Report");

		Thread.sleep(5000);
		driver1.findElement(By.xpath("//i[@class='ms-Button-icon icon-284']//i[@class='Q0K3G ___198tor0 f14t3ns0 fne0op0 fg4l7m0 fmd4ok8 f1sxfq9t'][contains(text(),'')]"))
				.click();
		
		////i[@class='ms-Button-icon icon-284']//i[@class='Q0K3G ___198tor0 f14t3ns0 fne0op0 fg4l7m0 fmd4ok8 f1sxfq9t'][contains(text(),'')]
		Thread.sleep(500);
		driver1.findElement(By.xpath("//span[normalize-space()='Browse this computer']")).click();
		Thread.sleep(500);
		Runtime.getRuntime().exec("C:\\Users\\Mind-Graph\\Documents\\uploadReport.exe");

		Thread.sleep(4000);
		// driver1.findElement(By.xpath("//span[normalize-space()='Send']")).click();
	}

	@Given("click on kota kinabalu International Airport")
	public void click_on_kota_kinabalu_international_airport() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Kota Kinabalu International Airport\"]"))
				.click();
	}

	@Then("Verify presence of kota kinabalu International Airport")
	public void verify_presence_of_kota_kinabalu_international_airport() throws InterruptedException {
		Thread.sleep(5000);
		WebElement e = driver.findElement(AppiumBy
				.xpath("//android.widget.TextView[@text=\"You have selected: Kota Kinabalu International Airport\"]"));

		if (e.getText().equals("You have selected: Kota Kinabalu International Airport")) {

			System.out.println("Kota Kinabalu International Airport");
		} else {
			System.out.println("Terminal Not found");
		}
	}

	@Given("click on Touch point for kota kinabalu International Airport")
	public void click_on_touch_point_for_kota_kinabalu_international_airport() throws InterruptedException {
		Thread.sleep(3000);
		// android.widget.TextView[@text="Cleanliness"]
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Cleanliness\"]")).click();
		Thread.sleep(3000);

	}

	@Given("click on kuching International Airport")
	public void click_on_kuching_international_airport() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Kuching International Airport\"]"))
				.click();

	}

	@Then("Verify presence of kuching International Airport")
	public void verify_presence_of_kuching_international_airport() throws InterruptedException {

		Thread.sleep(2000);
		WebElement e = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\\\"Kuching International Airport\\\"]"));

		if (e.getText().equals("You have selected: Kuching International Airport")) {

			System.out.println("Kuching International Airport");
		} else {
			System.out.println("Terminal Not found");
		}
	}

	@Given("click on each Touch point for kuching International Airport")
	public void click_on_each_touch_point_for_kuching_international_airport() throws InterruptedException {
		Thread.sleep(3000);
		// android.widget.TextView[@text="Cleanliness"]
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Cleanliness\"]")).click();
		Thread.sleep(3000);

	}

	@Given("click on Touch point for kuching International Airport")
	public void click_on_touch_point_for_kuching_international_airport() throws InterruptedException {
		Thread.sleep(3000);
		// android.widget.TextView[@text="Cleanliness"]
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Cleanliness\"]")).click();
		Thread.sleep(3000);

	}

	@Given("click on Penang International Airport")
	public void click_on_penang_international_airport() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Penang International Airport\"]")).click();

	}

	@Then("Verify presence of Penang International Airport")
	public void verify_presence_of_penang_international_airport() throws InterruptedException {

		Thread.sleep(2000);
		WebElement e = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\\\"Penang International Airport\\\"]"));

		if (e.getText().equals("You have selected: Penang International Airport")) {

			System.out.println("Penang International Airport");
		} else {
			System.out.println("Terminal Not found");
		}
	}

	@Given("click on Touch point for Penang International Airport")
	public void click_on_touch_point_for_penang_international_airport() throws InterruptedException {
		Thread.sleep(3000);
		// android.widget.TextView[@text="Cleanliness"]
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Cleanliness\"]")).click();
		Thread.sleep(3000);

	}

	@Then("Verify presence of Terminal two")
	public void verify_presence_of_terminal_two() throws InterruptedException {

		Thread.sleep(5000);
		WebElement e = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"You have selected: KUL Terminal 2\"]"));

		if (e.getText().equals("You have selected: KUL Terminal 2")) {

			System.out.println("KUL Terminal 2");
		} else {
			System.out.println("Terminal Not found");
		}
	}

	@Given("click on plan my journey card")
	public void click_on_plan_my_journey_card() throws InterruptedException {
		// Plan My journey Card
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);

		// Ok Button
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"OK\"]")).click();
		Thread.sleep(3000);

		// Back Arrow
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"))
				.click();
		Thread.sleep(5000);
	}

	@Given("again click on Plan my journey card")
	public void again_click_on_plan_my_journey_card() throws InterruptedException {

		// search Bar
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Search your flight\"]")).click();
		Thread.sleep(3000);

		// back arrow
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"))
				.click();

	}

	@Then("Click on the ChatBot Icon in home page")
	public void click_on_the_chat_bot_icon_in_home_page() throws InterruptedException {
		// Chat bot icon
		// android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView
		Thread.sleep(10000);
		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView\r\n"
						+ ""))
				.click();
	}

	@Then("click on back button for chatbot")
	public void click_on_back_button_for_chatbot() throws InterruptedException {
		Thread.sleep(8000);
		// Back button
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();

	}

	/*@Then("click on Faq button")
	public void click_on_faq_button() throws InterruptedException {
		Thread.sleep(7000);
		// Faq
		// android.widget.TextView[@resource-id="klia.mahb.ios:id/kmFaqOption"]
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"klia.mahb.ios:id/kmFaqOption\"]"))
				.click();
	}*/

	@Then("click on start conversation")
	public void click_on_start_conversation() throws InterruptedException {
		// start conversation
		// android.widget.Button[@resource-id="klia.mahb.ios:id/start_new_conversation"]
		Thread.sleep(5000);
		driver.findElement(
				AppiumBy.xpath("//android.widget.Button[@resource-id=\"klia.mahb.ios:id/start_new_conversation\"]"))
				.click();

	}

	@Then("click on refresh button")
	public void click_on_refresh_button() throws InterruptedException {
		// refresh
		// android.widget.TextView[@resource-id="klia.mahb.ios:id/kmRefreshOption"]
		Thread.sleep(5000);
		driver.findElement(
				AppiumBy.xpath("// android.widget.TextView[@resource-id=\"klia.mahb.ios:id/kmRefreshOption\"]"))
				.click();

	}

	@Then("click on Menu button")
	public void click_on_menu_button() throws InterruptedException {
		// Menu
		// android.widget.TextView[@resource-id="klia.mahb.ios:id/messageTemplateTv" and
		// @text="Menu"]
		Thread.sleep(5000);
		driver.findElement(
				AppiumBy.xpath("// android.widget.TextView[@resource-id=\"klia.mahb.ios:id/messageTemplateTv\" and\r\n"
						+ "		// @text=\"Menu\"]"))
				.click();

	}

	@Then("click on Map button")
	public void click_on_map_button() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(
				AppiumBy.xpath("//android.widget.TextView[@resource-id=\"klia.mahb.ios:id/messageTemplateTv\" and @text=\"Map\"]"))
				.click();


	}

	@Then("click on button for maps button")
	public void click_on_button_for_maps_button() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(
				AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView"))
				.click();

	}

	@Then("click on flights button")
	public void click_on_flights_button() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(
				AppiumBy.xpath("//android.widget.TextView[@resource-id=\"klia.mahb.ios:id/messageTemplateTv\" and @text=\"Flights\"]"))
				.click();
	}

	@Then("click on Back button in flights")
	public void click_on_back_button_in_flights() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(
				AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"))
				.click();
	}

	

	// Menu
	// android.widget.TextView[@resource-id="klia.mahb.ios:id/messageTemplateTv" and
	// @text="Menu"]

	// map
	// android.widget.TextView[@resource-id="klia.mahb.ios:id/messageTemplateTv" and
	// @text="Map"]

	// back button
	// android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView

	// flights
	// android.widget.TextView[@resource-id="klia.mahb.ios:id/messageTemplateTv" and
	// @text="Flights"]

	// back
	// android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView

}
