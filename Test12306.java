package Test12306;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class Test12306 {
    private WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.12306.cn/index/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    //请在这里写JUnit5测试代码

    @Test
    public void testUI(){ takeScreenshot("12306_search_UI_001.png");}

    @ParameterizedTest
    @CsvSource({
            "北京北,南京,2024-10-14,12306_search_001.png",
            "北京北,南京,2024-10-15,12306_search_002.png",
            "北京北,南京,2024-10-20,12306_search_003.png",
            "北京北,南京,2024-10-29,12306_search_004.png",
            "北京北,南京,2024-10-30,12306_search_005.png"
    })
    public void test_12306_search(String from,String to,String fromTime,String screenShot) throws InternalError, InterruptedException {
        WebElement fromField = driver.findElement(By.id("fromStationText"));
        fromField.sendKeys(from+Keys.ENTER);
        WebElement toField = driver.findElement(By.id("toStationText"));
        toField.sendKeys(to+Keys.ENTER);
        WebElement fromTimeFIeld = driver.findElement(By.id("train_date"));
        fromTimeFIeld.clear();
        fromTimeFIeld.sendKeys(fromTime);
        WebElement query = driver.findElement(By.id("search_one"));
        query.click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }
    @AfterEach
    public void teardown(){
        this.driver.quit();
    }
    public void takeScreenshot(String fileName){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenshotFile,new File(fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}