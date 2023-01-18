package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuizPage {

    public QuizPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
  
    @FindBy(xpath = "//span[@class='timer']")
   	public WebElement quizTimer;
    
    @FindBy(xpath = "//span[@class='attemptcount']/em")
   	public WebElement attemptedCnt;
    
    @FindBy(xpath = "//em[@class='question-type']")
   	public WebElement questionType;
    
    @FindBy(xpath = "//span[text()='Next']")
   	public WebElement nextBtn;
    
    @FindBy(xpath = "//input[@type='checkbox']")  
   	public WebElement checkBox;
  
    @FindBy(xpath = "//input[@type='radio']")
   	public WebElement radioBtn;
    
    @FindBy(xpath = "(//img[@class='mr8 grey-txt-md'])[3]")
   	public WebElement srcEle;
    
    @FindBy(xpath = "(//img[@class='mr8 grey-txt-md'])[1]")
   	public WebElement destEle;
    
    @FindBy(xpath = "//span[@class='currentPageNumber']")
   	public WebElement currQuizPageNo;
    
    @FindBy(xpath = "//span[@class='counter']")
   	public WebElement totalQuizPageNo;
    
    @FindBy(id = "shortAnswer")
   	public WebElement shortAnswer;
   
    @FindBy(xpath = "//button[text()='Submit']")
   	public WebElement submitBtn;

    @FindBy(xpath = "//button[@class='submit yes-btn ml24']")
   	public WebElement finalSubmitBtn;
    
    @FindBy(xpath = "//button[@class='yes-btn confirm-yes']")
   	public WebElement alertConfirmBtn;
    
    @FindBy(xpath = "(//div[@class='questions-status mb24 d-inline-flex']/div/p)[1]")
   	public WebElement questionsAnswered;
    		
    public static String attemptedCntStr;
    
    public static String quizTimerStr;
 
}
