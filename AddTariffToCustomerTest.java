package guru99demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AddTariffToCustomerTest {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Click Add Tariff Plan to Customer
            wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Add Tariff Plan to Customer"))).click();

            // Enter Customer ID (use dummy or from previous run)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_id")))
                .sendKeys("557217");

            // Submit
            driver.findElement(By.name("submit")).click();

            // Select any tariff plan
            wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@type='radio']"))).click();

            // Submit again
            driver.findElement(By.name("submit")).click();

            // Validate success
            String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))
            ).getText();

            if (text.contains("Congratulation")) {
                System.out.println("Test Passed - Tariff assigned");
            } else {
                System.out.println("Test Failed ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        driver.quit();
    }
}
