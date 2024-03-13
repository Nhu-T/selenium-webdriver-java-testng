package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_HandleButton {
    WebDriver driver;

    @BeforeClass
    public void initinalBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01(){
        driver.get ("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
       By loginButton = By.cssSelector("button.fhs-btn-login");
       //isEnabled : nếu element mà nó enabled thì trả về true/disable tra về false
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());
       //String logninBackgroundColor = driver.findElement(loginButton).getCssValue("background-color");
       //System.out.println(logninBackgroundColor) ;
      // Color loginColor = Color.fromString(logninBackgroundColor);
      // Assert.assertEquals(loginColor.asHex().toUpperCase(),"#000000");
       Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().
               toUpperCase(),"#000000");
       driver.findElement(By.cssSelector ("input#login_username")).sendKeys("nhu@gmail.com");
       driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");
       Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().
                toUpperCase(),"#C92127");
        driver.findElement(loginButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");




    }
}
