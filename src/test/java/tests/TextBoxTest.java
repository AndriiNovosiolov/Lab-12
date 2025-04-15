package com.novosiolov.lab13.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners({com.novosiolov.lab13.listeners.CustomListener.class})
public class TextBoxTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void testTextBoxForm() throws InterruptedException {
        driver.findElement(By.id("userName")).sendKeys("Andrii");
        driver.findElement(By.id("userEmail")).sendKeys("andrii@example.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Kyiv");

        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        WebElement outputName = driver.findElement(By.id("name"));
        Assert.assertTrue(outputName.getText().contains("Andrii"), "Name not found in output");
    }

    @Test
    public void failTestExample() {
        Assert.assertTrue(false, "Цей тест має впасти для перевірки логів і відео 🎥");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

