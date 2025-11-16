package test;

import Base.Browserfactory;
import pages.Logininpage;
import search.SearchPage;
import org.openqa.selenium.WebDriver;

public class linkedinautomation {
    
    public static void main(String[] args) {
        WebDriver driver = Browserfactory.startBrowser();
        
        try {
            // STEP 1: Login first
            SearchPage search = new SearchPage(driver);
            search.login("your_email@example.com", "your_password"); // ✅ Replace with real credentials
            
            // STEP 2: Then search and export
            Logininpage login = new Logininpage(driver);
            login.searchAndExport("Automation Tester India");
            
            System.out.println("=== LinkedIn Search Automation Completed ===");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}