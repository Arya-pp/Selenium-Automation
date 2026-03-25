package guru99demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PayBillingTest {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Click Pay Billing
            wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Pay Billing"))).click();

            // Enter Customer ID
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_id")))
                .sendKeys("606810"); // Use valid ID if available

            // Submit
            driver.findElement(By.name("submit")).click();

            Thread.sleep(3000);

            String pageText = driver.getPageSource();

            if (pageText.contains("Congratulation")) {
                System.out.println("Test Passed  - Tariff assigned");
            } else if (pageText.contains("Please enter valid customer id")) {
                System.out.println("Invalid Customer ID ");
            } else {
                System.out.println("Test Failed ");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        driver.quit();
    }
}
