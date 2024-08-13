import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
	
	WebDriver driver=new ChromeDriver();
	String myWebsite="https://magento.softwaretestingboard.com/";
	Random random=new Random();
	String myPassword="I love momy";
	String logout="https://magento.softwaretestingboard.com/customer/account/logout/";
	String emailaddressToLogin="";
	
	
	@BeforeTest
	public void setUp() {
		
		driver.get(myWebsite);
		driver.manage().window().maximize();
		
	}
	//invocation count بعيد وبكرر التيست
	@Test(priority = 1,enabled = false)
	public void createAccout() {
		//linktext
	//	WebElement createaccout=driver.findElement(By.linkText("Create an Account"));
		//createaccout.click();
		
		//xpath
//		WebElement createaccount=driver.findElement(By.xpath("//a [@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
//		createaccount.click();
		
		//partial link text
		WebElement createaccount=driver.findElement(By.partialLinkText("Create"));
		createaccount.click();
	
	
		   String[] firstNames = {
		            "Alice", "Bob", "Charlie", "Diana", "Eve", 
		            "Frank", "Grace", "Hannah", "Isaac", "Judy"
		        };

		   
		   String[] lastNames = {
		            "Smith", "Johnson", "Williams", "Jones", "Brown", 
		            "Davis", "Miller", "Wilson", "Moore", "Taylor"
		        };

		  int randomIndexForTheFN=random.nextInt(firstNames.length);
		int randomIndexForTheLN= random.nextInt(lastNames.length);
		String domain_Name="@gmail.com";
		int rand=random.nextInt(7769);
		
		
		WebElement First_Name= driver.findElement(By.id("firstname"));
		WebElement last_Name=  driver.findElement(By.id("lastname"));
        WebElement Email_address=driver.findElement(By.id("email_address"));
		WebElement Password=driver.findElement(By.id("password"));
		WebElement confirmation_password=driver.findElement(By.id("password-confirmation"));
		WebElement createaccountButton=driver.findElement(By.xpath("//button[@title='Create an Account']"));
	
	String FN_INPUT=firstNames[randomIndexForTheFN];
	String LN_INPUT=lastNames[randomIndexForTheLN];
			
			First_Name.sendKeys(FN_INPUT);
		    last_Name.sendKeys(LN_INPUT);
		    Email_address.sendKeys(FN_INPUT+LN_INPUT+rand+domain_Name); 
		    Password.sendKeys(myPassword);
		    confirmation_password.sendKeys(myPassword);
		    createaccountButton.click();

		    emailaddressToLogin=FN_INPUT+LN_INPUT+rand+domain_Name;
		    
	}

	
	
	@Test(priority = 2,enabled = false)
	public void singout() {
		
		 driver.get(logout);
	}
	
	
	@Test(priority = 3,enabled = false)
	public void loginTest() {
		WebElement sign_in=driver.findElement(By.linkText("Sign In"));
		sign_in.click();
		
		
WebElement email=driver.findElement(By.id("email"));
email.sendKeys(emailaddressToLogin);
WebElement password=driver.findElement(By.id("pass"));
password.sendKeys(myPassword);
		
		WebElement loginbutton=driver.findElement(By.cssSelector(".action.login.primary"));
		loginbutton.click();
		
	}
	
	
	
	@Test (priority = 4)
	public void addMenItem() {
		
	WebElement mensection=driver.findElement(By.cssSelector("#ui-id-5"));
			mensection.click();
	WebElement itemCountainer=driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
List<WebElement> Items=	itemCountainer.findElements(By.tagName("li"));
Items.get(0).click();
	
	
	
	
	}
	
	
	
	
}
