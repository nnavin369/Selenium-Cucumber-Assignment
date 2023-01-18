package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {

    public NavigationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
  
    @FindBy(xpath = "(//h1[@class='h1title' and text()='Dashboard'])[1]")
   	public WebElement dashboardPageCheck;
    
    @FindBy(xpath = "(//div[text()='All Courses'][@class='buttontext'])[2]")
    public WebElement allCoursesBtn;	
    
    @FindBy(xpath = "//a[text()='Automation Course']")
   	public WebElement automationCourseLink;
    
    @FindBy(xpath = "(//button[text()='Go to Content Area'])[1]")
   	public WebElement goToContentAreaBtn;
    
    @FindBy(xpath = "//span[text()='Quiz']")
   	public WebElement quizLink;
    
    @FindBy(xpath = "//h4[text()='Automation Task']")
 	public WebElement automationTaskHeader;

    @FindBy(xpath = "//button[text()='Start Quiz']")
 	public WebElement startQuizBtn;
  
    @FindBy(xpath = "//button[text()='Resume Quiz']")
 	public WebElement resumeQuizBtn;
    
}
