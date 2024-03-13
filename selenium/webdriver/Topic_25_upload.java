package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_25_upload {
    WebDriver driver;
    String uploadFolderPath = System.getProperty("user.dir")+ File.separator + "uploadFiles" + File.separator;
    String bana = "bana.jpg";
    String bien ="bien.jpg";
    String caurong = "caurong.jpg";
    String banaPath = uploadFolderPath + bana;
    String bienPath = uploadFolderPath + bien;
    String caurongPath = uploadFolderPath + caurong;


    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_single_file() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputBy = By.xpath("//input[@type='file']");
        //WebElement uploadFileElement = driver.findElement(inputBy);
        //load file len
        driver.findElement(inputBy).sendKeys(banaPath);
        Thread.sleep(2000);
        driver.findElement(inputBy).sendKeys(bienPath);
        Thread.sleep(2000);
        driver.findElement(inputBy).sendKeys(caurongPath);
        Thread.sleep(2000);
        //verify file dc load len
        Assert.assertTrue(driver.findElement(By.xpath
                ("//p[@class='name' and text()='"+ bana +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath
                ("//p[@class='name' and text()='"+ bien +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath
                ("//p[@class='name' and text()='"+ caurong +"']")).isDisplayed());
        //click upload cho tung file
       List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
       for (WebElement startButton:  startButtons){
           startButton.click();
           Thread.sleep(2000);}
           Assert.assertTrue(driver.findElement(By.xpath
                   ("//a[text()='"+bana+"']")).isDisplayed());
           Assert.assertTrue(driver.findElement(By.xpath
                   ("//a[text()='"+bien+"']")).isDisplayed());
           Assert.assertTrue(driver.findElement(By.xpath
                   ("//a[text()='"+caurong+"']")).isDisplayed());

        //verify casc file dc upload thanh cong

    }
    @Test
    public void TC_02_Multiple_file() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By inputBy = By.xpath("//input[@type='file']");
        //WebElement uploadFileElement = driver.findElement(inputBy);
        //load file len-nhieu file cung 1 lan
        driver.findElement(inputBy).sendKeys(banaPath +"\n"+ bienPath+"\n"+ caurongPath);
        Thread.sleep(2000);

        //verify file dc load len
        Assert.assertTrue(driver.findElement(By.xpath
                ("//p[@class='name' and text()='"+ bana +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath
                ("//p[@class='name' and text()='"+ bien +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath
                ("//p[@class='name' and text()='"+ caurong +"']")).isDisplayed());
        //click upload cho tung file
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton:  startButtons){
            startButton.click();
            Thread.sleep(2000);}
        Assert.assertTrue(driver.findElement(By.xpath
                ("//a[text()='"+bana+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath
                ("//a[text()='"+bien+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath
                ("//a[text()='"+caurong+"']")).isDisplayed());

        //verify casc file dc upload thanh cong
    }
    @AfterClass
    public void cleanBrowser(){ driver.quit();}
}
