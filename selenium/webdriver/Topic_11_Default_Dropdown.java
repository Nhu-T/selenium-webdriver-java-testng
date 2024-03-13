package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Facebook_Signup() {
        driver.get("https://www.facebook.com/reg/");
        select = new Select(driver.findElement(By.cssSelector("select#day")));
        select.selectByVisibleText("23");
        // chọn xong verify đã chọn thành công hay chưa
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "23");
        //Verify cái dropdown có phải là multiple select hay ko
        // Nếu là multiple nó sẽ trả về true
        // Nếu là single nso sẽ trả về false
        Assert.assertFalse(select.isMultiple());
        //Verify xem tổng số lượng item trong dropdown này là bn
        Assert.assertEquals(select.getOptions().size(), 31);
    }
    @Test
    public void TC_02_NopCommerce(){
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText("");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText("");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText("");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("");
        driver.findElement(By.cssSelector("input#Company")).sendKeys("");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("");
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.registration-result-page div.result")).getText(),
                "Your registration completed");
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input#Email")).sendKeys("");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("");
        driver.findElement(By.cssSelector("button.login-button"));
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),"");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),"");
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().
                getText(), "");
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(), "");
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(), "");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), "");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "");

    }
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}
