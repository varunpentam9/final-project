package pages;

import org.openqa.selenium.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Logininpage {

    WebDriver driver;

    By searchBox = By.xpath("//input[contains(@placeholder,'Search')]");

    public Logininpage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchAndExport(String keyword) throws InterruptedException, IOException {
        WebElement box = driver.findElement(searchBox);
        box.sendKeys(keyword);
        box.submit();
        Thread.sleep(4000);

        // Scroll a bit to load more results
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 3; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(1500);
        }

        // Collect profile names & titles
        List<WebElement> names = driver.findElements(By.xpath("//span[contains(@class,'entity-result__title-text')]"));
        List<WebElement> subtitles = driver.findElements(By.xpath("//div[contains(@class,'entity-result__primary-subtitle')]"));

        // Save to CSV
        FileWriter csv = new FileWriter("output/results.csv");
        csv.write("Name,Title\n");

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText().replace(",", " ");
            String title = i < subtitles.size() ? subtitles.get(i).getText().replace(",", " ") : "";
            csv.write(name + "," + title + "\n");
        }

        csv.close();
        System.out.println("✅ Results saved to output/results.csv");
    }
}