package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void formName (WebElement e , String name){
        e.click();
        e.sendKeys(name);
    }

    public static void formpracticeAuto (WebElement e , String text){
        e.click();
        e.sendKeys(text);
    }

    public static void formExpRadioBtn(WebElement e){
        e.click();
    }

    public static void formjavachckBx (WebElement e){
        e.click();
    }

    public static void formseleniumchckBx (WebElement e){
        e.click();
    }

    public static void formTestNgchckBx (WebElement e){
        e.click();
    }
    // public static void formSelectsurname (WebElement e1, WebElement e2) throws InterruptedException{
    //     e1.click();
    //     Thread.sleep(2000);
    //     e2.click();      

    // }
    public static void formDatePicker(WebElement e){
        //e.click();
        e.sendKeys("01/12/2024");
        
    }

    public static void formtime(WebElement e1, WebElement e2){
        e1.click();
        e1.sendKeys("07");

        e2.click();
        e2.sendKeys("30");
        //e.sendKeys("");
        
    }

    public static void formSubmit(WebElement e){
        e.click();
    }


}
