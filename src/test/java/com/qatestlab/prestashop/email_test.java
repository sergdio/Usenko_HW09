package com.qatestlab.prestashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class email_test {
//    @BeforeMethod
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, 10);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void EmailValid() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");

        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("sergdio@ukr.net");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        String textSucces = driver.findElement(By.xpath("//*[@id=\"authentication\"]")).getText();
        Assert.assertTrue(textSucces.contains("CREATE AN ACCOUNT"));
        //driver.quit();
    }

    @Test
    public void EmailInvalid() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("sergdioukr.net");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();


        String Unsuccess = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]")).getText();
        Assert.assertTrue(Unsuccess.contains("Invalid email address."));


        //driver.quit();

    }
}

