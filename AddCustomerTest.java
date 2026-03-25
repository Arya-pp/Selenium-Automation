package guru99demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AddCustomerTest {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Click Add Customer
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Customer"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='done']")
            )).click();

            // Fill form
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname"))).sendKeys("Arya");
            driver.findElement(By.id("lname")).sendKeys("PP");
            driver.findElement(By.id("email")).sendKeys("arya@test.com");
            driver.findElement(By.name("addr")).sendKeys("Kerala");
            driver.findElement(By.id("telephoneno")).sendKeys("9876543210");

            // Submit
            driver.findElement(By.name("submit")).click();
            
            Thread.sleep(5000);

            // Validate
            String text = driver.findElement(By.tagName("h3")).getText();
            System.out.println("Result: " + text);

            if (text != null && !text.isEmpty()) {
                System.out.println("Test Passed ");
            } else {
                System.out.println("Test Failed ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        driver.quit();
    }
}
