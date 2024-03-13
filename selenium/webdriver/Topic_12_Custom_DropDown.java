package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_DropDown {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // Hanhf vi để thao tác lên dropdown
        // chờ cho dropdown có thể thao tác lên đc( clikable)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#speed-button")));
        //click vào element nào để nó xổ dropdown ra
        driver.findElement(By.cssSelector("span#speed-button")).click();
        Thread.sleep(2000);
        // chờ tất cả items đc load ra(presence)
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#speed-menu>li>div")));
        //tim item nhu mong dowi
        List<WebElement> allitems = driver.findElements(By.cssSelector("ul#speed-menu>li>div"));
        for (WebElement item : allitems) {
            System.out.println(item.getText());
            if (item.getText().equals("Faster")) {
                item.click();
                break;
            }
        }
    }

    @Test
    public void TC_02_ham() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInCustomDropDown("span#speed-button", "ul#speed-menu>li>div", "Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).
                getText(), "Medium");
        selectItemInCustomDropDown("span#number-button", "ul#number-menu>li>div", "2");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).
                getText(), "2");
    }

    private void selectItemInCustomDropDown(String parentCss, String childCss, String textItem) throws
            InterruptedException {
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        List<WebElement> allitems = driver.findElements(By.cssSelector(childCss));
        for (WebElement item : allitems) {
            System.out.println(item.getText());
            if (item.getText().equals(textItem)) {
                item.click();
                break;
            }


        }
    }

    @Test
    public void TC_02_React () throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInCustomDropDown("div.dropdown", "div.item>span", "Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text")).getText(), "Jenny Hess");
    }

    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        EnterInputCustomDropDown("input.search", "div.item>span", "Albania");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text")).getText(), "Albania");
        EnterInputCustomDropDown("input.search", "div.item>span", "Argentina");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text")).getText(), "Argentina");
    }

    // Hanhf vi để thao tác lên dropdown
// chờ cho dropdown có thể nhập lên được (visible)
    private void EnterInputCustomDropDown(String parentCss, String childCss, String textItem) throws InterruptedException {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss))).clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss))).sendKeys(textItem);
        //sendkey vào drop down
        Thread.sleep(2000);
        // chờ tất cả items đc load ra(presence)
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        List<WebElement> allitems = driver.findElements(By.cssSelector(childCss));
        for (WebElement item : allitems) {
            System.out.println(item.getText());
            if (item.getText().equals(textItem)) {
                item.click();
                break;
            }
        }
    }
}


