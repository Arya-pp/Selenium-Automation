package guru99demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeTest {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver;
        String url = "https://demo.guru99.com/telecom/index.html";

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Click Add Customer
        driver.findElement(By.linkText("Add Customer")).click();

        Thread.sleep(2000);

        // Click Submit WITHOUT filling form
        driver.findElement(By.name("submit")).click();

        Thread.sleep(2000);

        // Check if validation appears (simple check)
        System.out.println("Validation should be displayed");

        driver.quit();
    }
}