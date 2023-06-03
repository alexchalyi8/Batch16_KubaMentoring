package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAlert {
    @Test
    public void testAlert(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement jsAlerts = driver.findElement(By.linkText("Javascript Alerts"));
        jsAlerts.click();
        WebElement jsAlertBtn= driver.findElement(By.xpath("//p[contains(text(),'JS Alert')]//button"));
        jsAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement confirmBox = driver.findElement(By.xpath("//p[contains(text(),'Confirm')]//button"));
        confirmBox.click();
        alert.dismiss();
        String expectedText= "You pressed Cancel!";
        WebElement confirmText = driver.findElement(By.cssSelector("#confirm-demo"));
        Assert.assertEquals(confirmText.getText().trim(),expectedText);
        WebElement promptBtn = driver.findElement(By.xpath("//p[contains(text(),'Prompt')]//button"));
        promptBtn.click();
        alert.sendKeys("Alex");
        alert.accept();
        WebElement textPrompt = driver.findElement(By.cssSelector("#prompt-demo"));
        String expectedTextPrompt = "You have entered 'Alex' !";
        Assert.assertEquals(textPrompt.getText().trim(),expectedTextPrompt);












    }
}
