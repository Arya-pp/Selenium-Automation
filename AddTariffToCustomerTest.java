package guru99demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AddTariffToCustomerTest {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Click Add Tariff Plan to Customer
            wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Add Tariff Plan to Customer"))).click();

            // Enter Customer ID 
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_id")))
                .sendKeys("606810"); // change if needed

            // Submit
            driver.findElement(By.name("submit")).click();

            Thread.sleep(2000);

            if (driver.getPageSource().contains("Please enter valid customer id")) {
                System.out.println("Invalid Customer ID ");
            } else {

                // Select FIRST tariff plan
            		((org.openqa.selenium.JavascriptExecutor) driver)
            		.executeScript("document.querySelectorAll(\"input[type='radio']\")[0].click();");
            		
                driver.findElement(By.name("submit")).click();

                // Validate success
                String text = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))
                ).getText();

                if (text.contains("Congratulation")) {
                    System.out.println("Test Passed - Tariff assigned");
                } else {
                    System.out.println("Test Failed");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        driver.quit();
    }
}


