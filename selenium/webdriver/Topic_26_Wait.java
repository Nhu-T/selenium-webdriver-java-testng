package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_26_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Visible(){
        driver.get("https://www.facebook.com/");
        //Element co tren UI va co trong HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }
    @Test
    public void TC_02_Invisible(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid ='open-registration-form-button']")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__")));
        //element khong co tren UI nhung van co trong HTML
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));
        //element khong co tren UI nhung va ko trong HTML
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));
    }
  @Test
    public void TC_03_Presence(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid ='open-registration-form-button']")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__")));
        driver.findElement(By.cssSelector("input[name='reg_email__")).sendKeys("nhu@gmail.com");
        //Element co tren UI va co trong HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));
        // Element ko co tren UI va van co trong HTML
        driver.findElement(By.cssSelector("input[name='reg_email__")).clear();
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='reg_email_confirmation__']")));

    }
    @Test
    public void TC_04_Staleness(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid ='open-registration-form-button']")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='reg_email__")));
        WebElement confirmEmail = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
        explicitWait.until(ExpectedConditions.stalenessOf(confirmEmail));
    }
    @AfterClass
    public void cleanBrowser(){driver.quit();}
}

