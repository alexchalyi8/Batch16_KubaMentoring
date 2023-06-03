package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Sliders {
    @Test
    public void slider(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        List<WebElement> allInputs = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement>allOutPut = driver.findElements(By.tagName("output"));

        for ( int i =0; i<allInputs.size();i++){
            while(!allOutPut.get(i).getText().equals("50")){
               if(allOutPut.get(i).getText().equals("50")){
                   break;
            }else{
                   allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
               }
        }





    }
}}
