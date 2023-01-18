package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {

    public ReportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='details question-points-blue ng-star-inserted']")
   	public WebElement correctMarks;
    
    @FindBy(xpath = "//span[@class='details question-points-red ng-star-inserted']")
   	public WebElement wrongMarks;
    
    @FindBy(xpath = "//span[@class='time']/parent::div/b")
   	public WebElement totalTimeTaken;
    
    @FindBy(xpath = "//div[@class='attempts']/p")
   	public WebElement noOfAttempts;

   	@FindBy(xpath = "/html/body/app-root/app-layout/div/app-content-layout/scrollbar/div[2]/div/app-learning-center/app-quiz-report/div/div[2]/div[1]/div[2]/circle-progress/svg/text/tspan[1]")		
    public WebElement myScore;

    @FindBy(xpath = "/html/body/app-root/app-layout/div/app-content-layout/scrollbar/div[2]/div/app-learning-center/app-quiz-report/div/div[2]/div[1]/div[2]/circle-progress/svg/text/tspan[2]")
   	public WebElement overAllScore;
    
    
  
    
    public static String noOfAttemptsStr;

    public static String scoredMarksStr;
    
    public static String totalTimeTakenStr;
    
    
    
    
    
}
