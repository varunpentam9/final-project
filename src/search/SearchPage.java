package search;

	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	

	public class SearchPage{

	    WebDriver driver;

	    By emailField = By.id("username");
	    By passwordField = By.id("password");
	    By signInButton = By.xpath("//button[@type='submit']");

	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void login(String email, String password) throws InterruptedException {
	        driver.get("https://www.linkedin.com/login");
	        driver.findElement(emailField).sendKeys(email);
	        driver.findElement(passwordField).sendKeys(password);
	        driver.findElement(signInButton).click();
	        Thread.sleep(4000);
	    }
	}

