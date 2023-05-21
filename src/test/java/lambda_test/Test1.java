package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    @Test
    public void test1() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
        WebElement form = driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]"));
        form.click();
        Thread.sleep(2000);
        WebElement name1 = driver.findElement(By.xpath("//input[@id='name']"));
        name1.sendKeys("Alex");
        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("Alexchalyi90@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("1234567");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("CodeFish");
        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("CodeFish.com");
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Chicago");
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("United States");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("2540 street 45");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("2540 street 45455");
        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("IL");
        WebElement zip = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zip.sendKeys("04556");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submit.click();
        WebElement text = driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us, we will get back to you shortly.')]"));
        Assert.assertTrue(text.isDisplayed());

    }
}
