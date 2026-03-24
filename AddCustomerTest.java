package guru99demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCustomerTest {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver;
        String url = "https://demo.guru99.com/telecom/index.html";
        
        // Launch browser
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        // Wait for page load
        Thread.sleep(2000);

        // Click Add Customer
        driver.findElement(By.linkText("Add Customer")).click();

        Thread.sleep(2000);

        // Select radio button
        driver.findElement(By.id("done")).click();

        // Fill form
        driver.findElement(By.id("fname")).sendKeys("Arya");
        driver.findElement(By.id("lname")).sendKeys("PP");
        driver.findElement(By.id("email")).sendKeys("arya@test.com");
        driver.findElement(By.name("addr")).sendKeys("Kerala");
        driver.findElement(By.id("telephoneno")).sendKeys("9876543210");

        Thread.sleep(1000);

        // Submit
        driver.findElement(By.name("submit")).click();

        Thread.sleep(2000);

        // Validate
        String text = driver.findElement(By.tagName("h3")).getText();

        if (text.contains("Customer ID")) {
            System.out.println("Test Passed ✅");
        } else {
            System.out.println("Test Failed ❌");
        }

        driver.quit();
    }
}