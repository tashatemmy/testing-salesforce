package salesforce.au_pageobjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class TryForFree {
	
	protected WebDriver driver;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
//	@FindBy(xpath = "/html/body/page-builder-miaw-ui//div/form")
//	WebElement popUpForm;
//	@FindBy(xpath = "/html/body/page-builder-miaw-ui//div/form/div/button")
//	WebElement popUpButton;
	@FindBy(xpath = "//*[@id=\"1746598729316_13jt\"]/div[1]/article/div[2]/div/pbc-button[1]/a")
	WebElement tryForFree;
	
	@FindBy(xpath ="/html/body/div[1]/hgf-c360nav//header/div[1]/div[1]/nav[2]/div/hgf-button//a")
	WebElement tryButton;
	@FindBy(name = "UserFirstName")
	WebElement firstname;
	@FindBy(name = "UserLastName")
	WebElement lastname;
	@FindBy(name = "UserTitle")
	WebElement jobTitle;
	@FindBy(name = "UserEmail")
	WebElement workEmail;
	@FindBy(name = "CompanyName")
	WebElement company;
	@FindBy(name = "CompanyEmployees")
	WebElement employees;
	@FindBy(name = "UserPhone")
	WebElement phone;
	@FindBy(name = "CompanyCountry")
	WebElement country;
	@FindBy(name = "SubscriptionAgreement")
	WebElement agreementCheckbox;
	@FindBy(name ="Start free trial")
	WebElement start;
	
	
	
	public TryForFree(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 js = (JavascriptExecutor) driver;
	}
	
//	public void closeChatbox() {
//		wait.until(ExpectedConditions.(popUp));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		action.scrollToElement(popUp);
//		js.executeScript("arguments[0].click();", popUp);
//	}
	
	public void clickTryForFree(WebDriver driver) {
//		WebElement popUpForm = (WebElement) js.executeScript(
//			    "return document.querySelector('page-builder-miaw-ui').shadowRoot.querySelector('form fieldset')"
//			);
//
//			WebElement popUpButton = (WebElement) js.executeScript(
//			    "return document.querySelector('page-builder-miaw-ui').shadowRoot.querySelector('form div button')"
//			);
//			js.executeScript("arguments[0].click();", popUpButton);
//			js.executeScript("arguments[0].remove()", popUpForm);
		
		
		// 1️⃣ Locate the first shadow host (hgf-c360nav)
		WebElement shadowHost1 = driver.findElement(By.cssSelector("hgf-c360nav"));

		// 2️⃣ Get shadow root for hgf-c360nav
		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

		// 3️⃣ Inside shadowRoot1, locate the second shadow host (hgf-button with trial variant)
		WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("hgf-button[variant='trial']"));

		// 4️⃣ Get shadow root for hgf-button
		SearchContext shadowRoot2 = shadowHost2.getShadowRoot();

		// 5️⃣ Inside shadowRoot2, find the <a> link
		WebElement tryForFreeLink = shadowRoot2.findElement(By.cssSelector("a.hgf-button"));

		// 6️⃣ Click the link
		js.executeScript("arguments[0].click();", tryForFreeLink);


//		action.moveToElement(tryButton).perform();
//		js.executeScript("arguments[0].click();", tryButton);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowHandles = windows.iterator();
		String parentWindow = windowHandles.next();
		String tryForFreeWindow = windowHandles.next();
		driver.switchTo().window(tryForFreeWindow);
		
		firstname.sendKeys("Temi");
		wait.until(ExpectedConditions.attributeToBe(firstname, "value", "Temi"));
		lastname.sendKeys("Odey");
		wait.until(ExpectedConditions.attributeToBe(lastname, "value", "Odey"));
		jobTitle.sendKeys("QA Engineer");
		wait.until(ExpectedConditions.attributeToBe(jobTitle, "value", "QA Engineer"));
		workEmail.sendKeys("temtem21@gmail.com");
		company.sendKeys("CompanyInTest..com");
		Select select = new Select(employees);
		select.selectByIndex(1);
		phone.sendKeys("2412345678");
		action.moveToElement(agreementCheckbox).perform();
		js.executeScript("arguments[0].click();", agreementCheckbox);
		start.click();
		
		driver.switchTo().window(parentWindow);
		WebElement aiChat = driver.findElement(By.cssSelector("page-builder-miaw-ui"));
		SearchContext shadowrootAi = aiChat.getShadowRoot();
		
		WebElement messageBox = shadowrootAi.findElement(By.cssSelector("textarea[name='userMessage']"));
		messageBox.sendKeys("Hello Salesforce, my name is Temi!");
		wait.until(ExpectedConditions.attributeToBe(messageBox, "value", "Hello Salesforce, my name is Temi!"));
		
		
		
		

		
		
		
		
		
		
	}
	
}
