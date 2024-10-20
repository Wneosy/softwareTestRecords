

```java
@BeforeAll//之前执行一次
@BeforeEach//每个之前执行一次
@Test//测试方法
@ParameterizedTest//带参测试方法
@AfterEach//每个之后执行一次
@AfterAll//之后执行一次
```



常用代码：

```java
//自己的driver地址
"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
//句柄跳转
driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
```

比赛框架：

```java
package Test12306;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.interactions.Actions;
public class Test12306 {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.12306.cn/index/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void testUI() {
        takeScreenshot("12306_search_UI_001.png");
    }

    @ParameterizedTest
    @CsvSource({
            "北京北,南京,2024-10-14,12306_search_001.png",
            "北京北,南京,2024-10-15,12306_search_002.png",
            "北京北,南京,2024-10-20,12306_search_003.png",
            "北京北,南京,2024-10-29,12306_search_004.png",
            "北京北,南京,2024-10-30,12306_search_005.png"
    })
    public void test_12306_search(String from, String to, String fromTime, String screenShot) throws InterruptedException {


        WebElement fromField = driver.findElement(By.id("fromStationText"));
        fromField.sendKeys(from + Keys.ENTER);



        WebElement toField = driver.findElement(By.id("toStationText"));
        toField.sendKeys(to + Keys.ENTER);



        WebElement fromTimeField = driver.findElement(By.id("train_date"));
        fromTimeField.clear();
        fromTimeField.sendKeys(fromTime);

        Actions actions = new Actions(driver);
        //WebElement query = driver.findElement(By.id("search_one"));
        actions.contextClick(driver.findElement(By.id("search_one"))).perform();
        Thread.sleep(50000);
        //query.click();

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Thread.sleep(1000);
        takeScreenshot(screenShot);
    }

    @AfterEach
    public void teardown() {
        this.driver.quit();
    }

    private void takeScreenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

```
```