package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TumblrTask {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");
        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();
        Thread.sleep(2000);
        WebElement continueWithEmail = driver.findElement(By.xpath("//div[@class='ehOK3']//button"));
        continueWithEmail.click();
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("MYemail@gmail.com");
        email.sendKeys(Keys.ENTER);
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("1234");
        WebElement passwordLoginBotton = driver.findElement(By.xpath("//span[.='Log in']"));
        Thread.sleep(2000);
        passwordLoginBotton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));
        String expectedMessege ="Your email or password were incorrect.";
        Assert.assertEquals(errorMessage.getText().trim(),expectedMessege);

        //to be able to do that I used this command in Console -->setTimeout(function(){
        //    debugger;
        //}, 5000);
















    }
}
