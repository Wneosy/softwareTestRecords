import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from time import sleep


class TestLogin:

    def setup_method(self):
        self.driver = webdriver.Chrome()
        #打开浏览器
        self.driver.get("http://120.26.37.204:8088/marks/login/")
        self.driver.maximize_window()
        sleep(2)

    def test_login_success(self):
        # 定位到登陆页面的输入、点击元素
        username = self.driver.find_element(By.NAME,"userName")
        password = self.driver.find_element(By.NAME,"passWord")
        submit = self.driver.find_element(By.ID,"loginFormBtn")
        username.send_keys("fangchen")
        sleep(2)
        password.send_keys("123456")
        sleep(2)
        submit.click()
        sleep(2)
        #对图片进行截图操作
        self.driver.save_screenshot('screenhot0.png')

    @pytest.mark.parametrize("user,pwd,screens",
                                 [("","123456","screenshot1.png"),("zzy","123456","screenshot2.png"),
                                  ("admin","","screenshot3.png"),
                                  (" "," ","screenshot4.png"),
                                  ("admin","123567","screenshot5.png")])
    def test_login_fail(self,user,pwd,screens):
            #定位到登陆页面的输入、点击元素
            username = self.driver.find_element(By.NAME,"userName")
            password = self.driver.find_element(By.NAME,"passWord")
            submit = self.driver.find_element(By.ID,"loginFormBtn")
            username.send_keys(user)
            sleep(2)
            password.send_keys(pwd)
            sleep(2)
            submit.click()
            sleep(2)
            notice = self.driver.find_element(By.XPATH,"/html/body/div[1]/div/div[1]").text
            assert "登录" in notice
            self.driver.save_screenshot(screens)

    def teardown_method(self):
            self.driver.quit()