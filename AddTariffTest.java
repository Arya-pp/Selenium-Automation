package guru99demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddTariffTest {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver;
        String url = "https://demo.guru99.com/telecom/index.html";

        // Launch browser
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Click Add Tariff Plan
        driver.findElement(By.linkText("Add Tariff Plan")).click();

        Thread.sleep(2000);

        // Fill Tariff Plan Details
        driver.findElement(By.id("rental1")).sendKeys("100");
        driver.findElement(By.id("local_minutes")).sendKeys("500");
        driver.findElement(By.id("inter_minutes")).sendKeys("300");
        driver.findElement(By.id("sms_pack")).sendKeys("100");
        driver.findElement(By.id("minutes_charges")).sendKeys("1");
        driver.findElement(By.id("inter_charges")).sendKeys("2");
        driver.findElement(By.id("sms_charges")).sendKeys("1");

        Thread.sleep(1000);

        // Submit
        driver.findElement(By.name("submit")).click();

        Thread.sleep(2000);

        // Validate success
        String text = driver.findElement(By.tagName("h2")).getText();

        if (text.contains("Congratulation")) {
            System.out.println("Test Passed and  Tariff Plan Added");
        } else {
            System.out.println("Test Failed ");
        }

        driver.quit();
    }
}
