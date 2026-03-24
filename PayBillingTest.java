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
                .sendKeys("557217"); // Use valid ID if available

            // Submit
            driver.findElement(By.name("submit")).click();

            // Validate result (Bill details page)
            String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))
            ).getText();

            if (text.contains("Customer")) {
                System.out.println("Test Passed ✅ - Billing page displayed");
            } else {
                System.out.println("Test Failed ❌");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        driver.quit();
    }
}