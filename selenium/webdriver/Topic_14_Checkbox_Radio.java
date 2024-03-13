package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Checkbox_Radio {
    WebDriver driver;
    JavascriptExecutor jsExcutor;

    @BeforeClass
    public void initinalBrowser() {
        driver = new FirefoxDriver();
        jsExcutor =  (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_03_Ubuntu () {
        driver.get("https://login.ubuntu.com/");
        By newUserRadioInput = By.cssSelector("input#id_new_user");
        jsExcutor.executeScript("arguments[0].click();", driver.findElement(newUserRadioInput));
        Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());
        By termCheckbox = By.cssSelector("input#id_accept_tos");
        jsExcutor.executeScript("arguments[0].click();", driver.findElement(termCheckbox));
        Assert.assertTrue(driver.findElement(termCheckbox).isSelected());
    }
    @Test
    public void TC_04_doc(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By hcmRadio = By.xpath("//div[@aria-label = 'Hồ Chí Minh']");
        By quangNoodle = By.xpath("//div[@aria-label = 'Mì Quảng']");
        driver.findElement(hcmRadio).click();
        Assert.assertEquals(driver.findElement(hcmRadio).getAttribute("aria-checked"),"true");
       // driver.findElement(quangNoodle).click();
       // Assert.assertEquals(driver.findElement(quangNoodle).getAttribute("aria-checked"),"true");
        //check
        if(driver.findElement(quangNoodle).getAttribute("aria-checked").equals("false")){
            driver.findElement(quangNoodle).click();}
            Assert.assertEquals(driver.findElement(quangNoodle).getAttribute("aria-checked"),"true");
        //uncheck
        if(driver.findElement(quangNoodle).getAttribute("aria-checked").equals("true")){
            driver.findElement(quangNoodle).click();}
        Assert.assertEquals(driver.findElement(quangNoodle).getAttribute("aria-checked"),"false");
        }


   // @AfterClass
  //  public void cleanBrowser(){
      // driver.quit();
   // }
}

