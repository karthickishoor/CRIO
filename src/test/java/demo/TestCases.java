package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
         driver.close();
         driver.quit();

    }
    @Test
    public void testCase01() throws InterruptedException{
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        //WebElement headingEl =driver.findElement(By.xpath("//div[@role='heading']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15) );
        Thread.sleep(1000);
        WebElement nameEl = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        Wrappers.formName(nameEl,"Crio Learner");

         WebElement practiceAutoEl = driver.findElement(By.tagName("textarea"));
        Wrappers.formName(practiceAutoEl,"I want to be the best QA Engineer! 1710572021");

         WebElement expRadioEl = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));
         Wrappers.formExpRadioBtn(expRadioEl);

         JavascriptExecutor js = (JavascriptExecutor) driver;        
        WebElement javaCheckbxEl = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", javaCheckbxEl);
        Wrappers.formjavachckBx(javaCheckbxEl);


        WebElement seleniumCheckbxEl = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", seleniumCheckbxEl);
        Wrappers.formseleniumchckBx(seleniumCheckbxEl);


        WebElement testNgCheckbxEl = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
        js.executeScript("arguments[0].scrollIntoView(true);", testNgCheckbxEl);
        Wrappers.formTestNgchckBx(testNgCheckbxEl);

        //js.executeScript("window.scrollBy(0,790)", "");
        
        WebElement surnameEl =driver.findElement(By.xpath("//span[text()='Choose']"));    //e1    
        js.executeScript("arguments[0].scrollIntoView(true);", surnameEl);
        surnameEl.click();
        Thread.sleep(1000);

        WebElement selectMr = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]"));//e2 //the one you prodived
        //WebElement selectMr = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]"));
        wait.until(ExpectedConditions.visibilityOf(selectMr));
        selectMr.click();
        Thread.sleep(2000);
       // Wrappers.formSelectsurname(surnameEl,selectMr);

            
        

        WebElement dateEl =driver.findElement(By.xpath("//input[@type='date']"));        
        js.executeScript("arguments[0].scrollIntoView(true);", dateEl);

        Wrappers.formDatePicker(dateEl);

        WebElement timeEl1 = driver.findElement(By.xpath("(//input[@type ='text'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", timeEl1);
        WebElement timeEl2 = driver.findElement(By.xpath("(//input[@type ='text'])[3]"));
        Wrappers.formtime(timeEl1, timeEl2);

        WebElement submitBtnEl = driver.findElement(By.xpath("//span[text()='Submit']"));
        Wrappers.formSubmit(submitBtnEl);

        WebElement sucessMsgEl = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        wait.until(ExpectedConditions.visibilityOf(sucessMsgEl));
        WebElement headingEl =driver.findElement(By.xpath("//div[@role='heading']"));
        WebElement anotherResponseEl = driver.findElement(By.xpath("//div[@class='c2gzEf']/a"));
        System.out.println(headingEl.getText());
        System.out.println(anotherResponseEl.getText());
        System.out.println(anotherResponseEl.getText());
        System.out.println(sucessMsgEl.getText());

    }
}