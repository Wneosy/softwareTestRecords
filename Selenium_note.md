元素定位

````java
id
name
className
linkText
xpath
````

控制浏览器窗口大小

```java
driver.manage().window().setSize(new Dimension(400,500));
```

控制浏览器后退、前进

```java
//后退
driver.navigate().back();
//前进
driver.navigate().forward();
//刷新
driver.navigate().refresh();
```

简单的元素操作

```java
clear()//清楚文本
sendKeys(value)//模拟按键输入
click()//单击元素
submit()//提交表单
getSize()//返回元素的尺寸
getText()//获取元素的文本
getAttribute(name)//获取属性值
isDisplayed()//设置该元素是否用户可见
```

鼠标事件

```java
import org.openqa.selenium.interactions.Actions;
Actions action = new Actions(driver);
//鼠标右键操作
action.contextClick(driver.findElement(By.id(""))).perform();
//鼠标悬停操作
action.clickAndHold(driver.findElement(By.id(""))).perform();
//鼠标双击操作
action.doubleClick(driver.findElement(By.id(""))).perform();
//鼠标拖放操作
webElement source = driver.findElement(By.id(""));
webElement target = driver.findElement(By.id(""));
action.dragAndDrop(source,target).perform();
//释放鼠标
action.release().perfrom();
```

键盘事件

````java
sendKeys(Keys,BACK_SPACE)//删除键(BackSpace)
sendKeys(Keys,SPACE)//空格键(SPACE)
sendKeys(Keys,TAB)//制表键(Tab)
sendKeys(Keys,ESCAPE)//回退键(ESC)
sendKeys(Keys,ENTER)//回车键(Enter)
sendKeys(Keys,CONTROL,'a')//全选
sendKeys(Keys,CONTROL,'c')//复制
sendKeys(Keys,CONTROL,'v')//粘贴
sendKeys(Keys,CONTROL,'x')//剪切
sendKeys(Keys.F1-F12)//键盘F1-F2
````

获得验证信息

```java
getTitle()//获得当前页面的title
getCurrentUrl()//获得当前页面url

```

