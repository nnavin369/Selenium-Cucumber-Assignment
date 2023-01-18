package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='login-logo']")
   	public WebElement loginLogo;
    
    @FindBy(id = "login-form-emailId")
    public WebElement loginEmail;

    @FindBy(id = "login-form-submit-btn")
	public WebElement firstLoginButton;

    @FindBy(id = "password")
    public WebElement password;
  
    @FindBy(xpath = "//button[@class='login-btn']")
   	public WebElement unextLoginButton;
    
}
