package StepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class ComposeEmailSteps {
	
public static WebDriver driver;
	
	@Before
	public static void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is:"+projectPath);
		System.setProperty("webdriver.edge.driver", projectPath+"/src/test/resources/drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	@After
public static void tearDown() {
		driver.quit();
	}
	
	
	
	@Given("User is on Yopmail Page")
	public void user_is_on_yopmail_page() {
		driver.get("https://yopmail.com/");
	}

	@When("User enter username as {string}")
	public void user_enter_username_as(String user) {
		 driver.findElement(By.id("login")).sendKeys(user);
	}

	@And("Clicks on the arrow button")
	public void click_on_arrow_button() throws InterruptedException {
		driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
		   Thread.sleep(2000);
	}

	@And("Check if User is able to login to Inbox")
	public void check_if_user_is_able_to_login_to_inbox() {
		assertTrue(driver.findElement(By.id("newmail")).isDisplayed());
	}

	@And("Click on Edit button")
	public void click_on_edit_button() throws InterruptedException {
		driver.findElement(By.id("newmail")).click();
		 Thread.sleep(2000);
	}

	@And("Enter Subject as {string}")
	public void enter_subject_as(String subject) {
		driver.switchTo().frame("ifmail");
		driver.findElement(By.id("msgsubject")).sendKeys("Incubyte Deliverables:1");
	}

	@And("Enter Body as {string}")
	public void enter_body_as(String body) {
	
			driver.findElement(By.id("msgbody")).sendKeys("Automation BQA test for Incubyte");
	}

	@And("Enter Email ID as {string}")
	public void enter_email_id_as(String email) {
		driver.findElement(By.id("msgto")).sendKeys(email);
	}

	@And("Click on Send Button")
	public void click_on_send_button() throws InterruptedException {
	    driver.findElement(By.id("msgsend")).click();
		 Thread.sleep(2000);
	}

	@When("Refresh the page to get EMail")
	public void refresh_the_page_to_get_mail() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.id("refresh")).click();
		 Thread.sleep(5000);
	}

	@Then("User must be able to view New EMail in Inbox")
	public void user_must_be_able_to_view_new_mail_in_inbox() {
		driver.switchTo().frame("ifinbox");
		assertTrue(driver.findElement(By.className("lms")).getText().contains("Incubyte Deliverables:2"));
	}


}
