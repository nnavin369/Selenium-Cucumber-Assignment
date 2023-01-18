package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
/*import pageobjects.AutomationStore;
import pageobjects.Homepage;
import pageobjects.Searchresults;
 */import pageobjects.LoginPage;
import pageobjects.NavigationPage;
import pageobjects.QuizPage;
import pageobjects.ReportPage;
import utils.ActionUtils;
import utils.CommonUtils;
import utils.FileUtils;
import utils.Waits;

 public class StepDefinitions {

	 public WebDriver driver;
	 public static Properties prop;

	 ActionUtils action = new ActionUtils();
	 Waits waits;
	 Scenario scenario;
	 LoginPage loginpage; 
	 NavigationPage navpage;
	 QuizPage quizpage;
	 ReportPage reportpage;
	 
	 Timer timer;
	 SoftAssert softAssert;
	
	 String qustType="";

	 public void startDriver(String url) throws IOException{

		 System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getPath());
		 //System.setProperty("webdriver.chrome.driver", "D:\\Technical\\Workspaces\\Testing-FW-WS\\Selenium-Cucumber-Assignment\\chromedriver.exe");
		 //D:\Technical\Workspaces\Testing-FW-WS\Selenium-Cucumber-Assignment\chromedriver.exe
		 driver = new ChromeDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 waits = new Waits(driver);
		 softAssert = new SoftAssert();
		 
		 loginpage = new LoginPage(driver);
		 navpage = new NavigationPage(driver);
		 quizpage = new QuizPage(driver);
		 reportpage = new ReportPage(driver);

	 }



	public Scenario getScenario()
	 {
		 return scenario;
	 }

	 public void setScenario(Scenario scenario)
	 {
		 this.scenario = scenario;
	 }

	 /*
  //loadConfig method is to load the configuration
  	@Before()
  	public void loadConfig() throws IOException {
  		ExtentManager.setExtent();
  		//DOMConfigurator.configure("log4j.xml");

  		try {
  			prop = new Properties();
  			FileInputStream ip = new FileInputStream(
  					System.getProperty("user.dir") + "\\resources\\Config.properties");
  			prop.load(ip);

  		} catch (FileNotFoundException e) {
  			e.printStackTrace();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	}
	  */

	 @Before
	 public void beforeMethod(Scenario scenario)
	 {
		 setScenario(scenario);
	 }

	 @After
	 public void tearDown(Scenario scenario) throws IOException, InterruptedException {

		 /*
		 if(true){
			 System.out.println("scenario.getName() ::"+scenario.getName()); 
			 scenario.attach("text/html;charset=utf-8", "Hello How are you...", "Test Report Data.."); 
		 }	*/

		 if(scenario.isFailed()){
			 FileUtils fileUtils = new FileUtils();
			 fileUtils.addScreenshot(scenario, driver);
		 }

		 
		 //Thread.sleep(10000);
		 action.pause(5000);
		 softAssert.assertAll();
		 //driver.quit();

	 }


	 @Given("I am on the Login page URL {string}")
	 public void i_am_on_the_login_page_url(String url) throws IOException {
		 startDriver(url);
		 waits.waitForElement(loginpage.loginLogo,20);

	 }

	 @Then("I enter registered emailId as {string}")
	 public void i_enter_registered_email_id_as(String emailId) {
		 waits.waitForElement(loginpage.loginEmail);
		 loginpage.loginEmail.sendKeys(emailId);

	 }

	 @Then("I click on login button and wait for Unext login page")
	 public void i_click_on_login_button_and_wait_for_unext_login_page() {
		 //loginpage.firstLoginButton.click();
		 action.fluentWait(driver, loginpage.firstLoginButton);
	 }

	 @Then("I enter password as {string}")
	 public void i_enter_password_as(String pwd) {
		 waits.waitForElement(loginpage.password);
		 loginpage.password.sendKeys(pwd);
	 }

	 @Then("I Click on Login button")
	 public void i_click_on_login_button() {
		 //loginpage.unextLoginButton.click();
		 action.fluentWait(driver, loginpage.unextLoginButton);
	 }

	 @Then("I should see dashboard page after login")
	 public void i_should_see_dashboard_page_after_login() {
	  Assert.fail();
	 }
	 
	 @Then("I should see Dashboard page")
	 public void i_should_see_dashboard_page() {
		 //action.fluentWait(driver, navpage.dashboardPageCheck);
		 
		 //driver.manage().deleteAllCookies();
		 action.pageLoadTimeOut(driver);
		 //driver.navigate().refresh();
		 //action.findElement(driver, navpage.dashboardPageCheck);
		 //waits.waitForElement(navpage.dashboardPageCheck,50);
		 //waits.waitForClickableElement(navpage.allCoursesBtn,30);
		 //action.fluentWait(driver, navpage.allCoursesBtn);
	 }

	 @Given("I am on the Dashboard page")
	 public void i_am_on_the_dashboard_page() {
		 driver.manage().deleteAllCookies();
		 action.pageLoadTimeOut(driver);
		 //action.fluentWait(driver, navpage.allCoursesBtn);
	 }

	 @Then("I click on All Courses button")
	 public void i_click_on_all_courses_button() {
		 //waits.waitForElement(navpage.allCoursesBtn,20);
		 //action.pageLoadTimeOut(driver);
		 //waits.waitForClickableElement(navpage.allCoursesBtn,20);
		 //navpage.allCoursesBtn.click();
		 action.fluentWait(driver, navpage.allCoursesBtn);

	 }

	 @Given("click on Automation Course link from course list page")
	 public void click_on_automation_course_link_from_course_list_page() {
		 //waits.waitForElement(navpage.automationCourseLink,25);
		 //navpage.automationCourseLink.click();
		 action.fluentWait(driver, navpage.automationCourseLink);
	 }

	 @Then("click on Go to Content Area button from Automation Course page")
	 public void click_on_go_to_content_area_button_from_automation_course_page() {
		 //waits.waitForElement(navpage.goToContentAreaBtn);
		 //navpage.goToContentAreaBtn.click();
		 action.fluentWait(driver, navpage.goToContentAreaBtn);
	 }

	 @Then("click on Quiz link from Course Dashboard")
	 public void click_on_quiz_link_from_course_dashboard() {
		 //waits.waitForElement(navpage.quizLink,20);
		 action.pageLoadTimeOut(driver,15);
		 action.fluentWait(driver, navpage.quizLink);
		 /* if(action.findElement(driver, navpage.quizLink)) {
			 navpage.quizLink.click(); 
		 }*/

	 }

	 @Then("click on Automation Task link from Automation Task page")
	 public void click_on_automation_task_link_from_automation_task_page() {
		 //waits.waitForElement(navpage.automationTaskHeader,25);
		 //navpage.automationTaskHeader.click();
		 action.fluentWait(driver, navpage.automationTaskHeader);
	 }

	
	 @Then("click on Start Quiz button from Automation Task page")
	 public void click_on_start_quiz_button_from_automation_task_page() {

		 action.pause(3000);
		 if(action.findElement(driver, quizpage.attemptedCnt)) {
			 System.out.println("Attempted Count ==>> "+quizpage.attemptedCnt.getText());
			 QuizPage.attemptedCntStr =  quizpage.attemptedCnt.getText();
		 }

		 action.fluentWait(driver, navpage.startQuizBtn);

		
		 //waits.waitForElement(navpage.resumeQuizBtn);
		 //navpage.resumeQuizBtn.click();

		 /*
		if(navpage.startQuizBtn.isDisplayed()) {
			waits.waitForElement(navpage.startQuizBtn);
			navpage.startQuizBtn.click();
		}else {
			waits.waitForElement(navpage.resumeQuizBtn);
			navpage.resumeQuizBtn.click();
		}*/
	 }


	 @Then("select Answer based on the question type and click Next button for next question")
	 public void select_answer_based_on_the_question_type_and_click_next_button_for_next_question() throws InterruptedException {

		 waits.waitForElement(quizpage.questionType,30);
		 //System.out.println("Question Type:"+quizpage.questionType.getText());

		 int qtnCnt = 6; 

		 /*		 public static String QTYPE_TEXTAREA = "Short Answer";
		 public static String QTYPE_DRAG_AND_DROP = "Ordering Type";
		 public static String QTYPE_CHKBOX_MCQ = "MCQ (Multiple Correct)";
		 public static String QTYPE_RADIO_MCQ = "MCQ (Single Correct)";
		 public static String QTYPE_RADIO_TF = "True / False";
		  */		//action.pause(2000);	

		 for(int i=1;i<=qtnCnt;i++) {
			 //driver.switchTo().activeElement()
			 if(i>1 && i<6) {
				 action.pause(4000);
			 }
			 qustType = quizpage.questionType.getText();
			 action.implicitWait(driver);
			 if(qustType.equalsIgnoreCase(CommonUtils.QTYPE_TEXTAREA)) {
				 System.out.println("Inside Text area");
				 action.pageLoadTimeOut(driver);
				 action.type(quizpage.shortAnswer, "test");  
				 if(i>4) {
					 action.pause(7000);  
					 if(action.isEnabled(driver, quizpage.shortAnswer)) {
						 action.type(quizpage.shortAnswer, "test"); 
					 }
				 }else {
					 action.pause(4000);
					 quizpage.nextBtn.click(); 
				 }
			 }else if(qustType.equalsIgnoreCase(CommonUtils.QTYPE_DRAG_AND_DROP)) {
				 System.out.println("Inside Drag and drop");
				 action.pageLoadTimeOut(driver);
				 action.draganddrop(driver, quizpage.srcEle, quizpage.destEle);
				 //action.draganddrop(driver, quizpage.destEle, quizpage.srcEle);
				 if(i>4) {
					 action.pause(9000);
				 }else {
					 action.pause(5000);
					 quizpage.nextBtn.click(); 
				 }
			 }else if(qustType.equalsIgnoreCase(CommonUtils.QTYPE_CHKBOX_MCQ)) {
				 System.out.println("Inside Check box MCQ");
				 action.pageLoadTimeOut(driver);
				 //action.click(driver, quizpage.checkBox);
				 //quizpage.checkBox.click();
				// action.pageLoadTimeOut(driver);
				 action.JSClick(driver, quizpage.checkBox);
				 if(i>4) {
					 action.pause(8000);
					 if(!action.isSelected(driver, quizpage.checkBox)) {
						 quizpage.checkBox.click(); 
					 }
				 }else {
					 action.pause(4000);
					 quizpage.nextBtn.click(); 
				 }
			 }else if(qustType.equalsIgnoreCase(CommonUtils.QTYPE_RADIO_MCQ)) {
				 System.out.println("Inside Radio btn MCQ");
				 action.pageLoadTimeOut(driver);
				 //action.JSClick(driver, quizpage.radioBtn);
				 quizpage.radioBtn.click();
				 //action.JSChecked(driver, quizpage.radioBtn);
				 if(i>4) {
					 action.pause(7000);
					 if(!action.isSelected(driver, quizpage.radioBtn)) {
						 quizpage.radioBtn.click(); 
					 }
				 }else {
					 action.pause(4000);
					 quizpage.nextBtn.click(); 
				 }
			 }else if(qustType.equalsIgnoreCase(CommonUtils.QTYPE_RADIO_TF)) {
				 System.out.println("Inside Radio btn True or False");
				 action.pageLoadTimeOut(driver);
				 
				 quizpage.radioBtn.click();
				 //action.JSChecked(driver, quizpage.radioBtn);
				 
				// JavascriptExecutor js = (JavascriptExecutor)driver;
				 //js.executeScript("document.getElementById('element_id').checked=true;");
				 
				 if(i>4) {
					 action.pause(7000);  
					 if(action.isSelected(driver, quizpage.radioBtn)) {
						 quizpage.radioBtn.click(); 
					 }
				 }else {
					 action.pause(4000);
					 quizpage.nextBtn.click(); 
				 }
			 }
		 }

	 }

	 @Then("repeat the above steps untill reach end of questions and click on submit")
	 public void repeat_the_above_steps_untill_reach_end_of_questions_and_click_on_submit() {
		 action.pageLoadTimeOut(driver);
		 action.pause(4000);
		 waits.waitForClickableElement(quizpage.submitBtn,25);
		 
		 QuizPage.quizTimerStr = quizpage.quizTimer.getText();
		 System.out.println("quizpage.quizTimer.getText() ===>> "+QuizPage.quizTimerStr);
		 if(action.isEnabled(driver, quizpage.submitBtn)) {
			 quizpage.submitBtn.click(); 
		 }
		 System.out.println("question Answered :: "+quizpage.questionsAnswered.getText());
		 action.pause(4000);
		 //waits.waitForElement(quizpage.finalSubmitBtn,25);
		 action.fluentWait(driver, quizpage.finalSubmitBtn);
		 //quizpage.finalSubmitBtn.click();
		 action.pause(4000);
		 //action.Alert(driver);
		 waits.waitForElement(quizpage.alertConfirmBtn,20);
		 quizpage.alertConfirmBtn.click();
		 action.pause(3000);

	 }

	 @Then("validate the attempted number display during quiz start page and noofattempts in report are equal")
	 public void validate_the_attempted_number_display_during_quiz_start_page_and_noofattempts_in_report_are_equal() {
		 

	 }

	 @Then("compare the time taken before submit and validate with report")
	 public void compare_the_time_taken_before_submit_and_validate_with_report() throws ParseException {
		 
		 
		
	 }
	 
	 @Given("print the quiz related details")
	 public void Given_print_the_quiz_related_details() throws ParseException {

		 ExtentCucumberAdapter.addTestStepLog("***************Marks Scored Questionwise***************");
		 int cnt=1; String.valueOf(cnt);
		
		 List<WebElement> marksList = driver.findElements(By.xpath("//span[@class='details question-points-blue ng-star-inserted' or @class='details question-points-red ng-star-inserted']"));
		 List<String> marklistStr = new ArrayList<String>();
		 for (WebElement markList : marksList) {
			 System.out.println(markList.getText());
			 ExtentCucumberAdapter.addTestStepLog(String.valueOf(cnt)+":"+markList.getText());
			 marklistStr.add(cnt-1, markList.getText());
			 cnt++;
		 }
		 ExtentCucumberAdapter.addTestStepLog("************************************************************");
		 System.out.println(CommonUtils.marksScored(marklistStr));
		 
		 String[] attemptStrSplit = QuizPage.attemptedCntStr.split("/");

		 System.out.println("attemptStrSplit[0] :"+attemptStrSplit[0]); 
		 System.out.println("attemptStrSplit[1] :"+attemptStrSplit[1]);
		 ReportPage.noOfAttemptsStr = reportpage.noOfAttempts.getText();  
		 ExtentCucumberAdapter.addTestStepLog("Total Attempted Count display before Start Quiz : "+attemptStrSplit[0]);
		 ExtentCucumberAdapter.addTestStepLog("No of Attempted Count display in report : "+ReportPage.noOfAttemptsStr);		 
		 
		 if (attemptStrSplit[0].equals(ReportPage.noOfAttemptsStr)) {
		 //if (attemptStrSplit[0].equals(attemptStrSplit[0])) {			 
			 ExtentCucumberAdapter.addTestStepLog("Both Attempted counts are Equal"); 
		 }else {
			 ExtentCucumberAdapter.addTestStepLog("Both Attempted counts are not Equal");
		 }		 
		 ExtentCucumberAdapter.addTestStepLog(CommonUtils.marksScored(marklistStr));
		 
		 List<WebElement> totalTimeTakenList = driver.findElements(By.xpath("//span[@class='time']/parent::div/b"));

		 ArrayList<String> totalTimeList = new ArrayList<String>();
		 System.out.println("totalTimeTakenList.size() :: "+totalTimeTakenList.size()); 
		 for (WebElement webElement : totalTimeTakenList) {
			 System.out.println(webElement.getText());
			 totalTimeList.add(CommonUtils.TIME_PFIX+webElement.getText().trim());
			 //ExtentCucumberAdapter.addTestStepLog(CommonUtils.TIME_PFIX+webElement.getText());
		 }
		 
		 Optional<String> reduced = totalTimeList.stream()
	                .reduce((s1,s2) -> s1 + " , " + s2);
	        reduced.ifPresent(System.out::println);

	        
		 String sumOfTimes =  CommonUtils.sumOfTimes(totalTimeList);
	     System.out.println("sumTimes :: "+sumOfTimes);
	     
	     
	     //scenario.log("closing the browser.....");
		 ExtentCucumberAdapter.addTestStepLog("Quiz timer Beofre Submit :"+QuizPage.quizTimerStr);
		 ExtentCucumberAdapter.addTestStepLog("Total time taken for each question :"+sumOfTimes);
		 ExtentCucumberAdapter.addTestStepLog("Time taken for each question :"+reduced);
	 }

	  }
