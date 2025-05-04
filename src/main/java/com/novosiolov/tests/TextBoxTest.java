package com.novosiolov.tests;

import com.novosiolov.pages.TextBoxPage;
import com.novosiolov.wrappers.ElementWrapper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxTest {
    public static void main(String[] args) throws Exception {
        // Вказуємо шлях до драйвера
        System.setProperty("webdriver.chrome.driver", "C:/Users/Andriy/Desktop/chromedriver-win64/chromedriver.exe");

        // Запускаємо браузер
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        // Ініціалізуємо сторінку та обгортку
        TextBoxPage page = new TextBoxPage(driver);
        ElementWrapper wrapper = new ElementWrapper();

        // Вводимо текст у поле Full Name
        wrapper.setText(page.fullNameInput, "Andrii");

        // Прокручуємо сторінку до кнопки Submit і клікаємо по ній
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page.submitButton);
        Thread.sleep(500); // трішки почекаємо
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", page.submitButton);

        // Очікуємо результат на сторінці
        wrapper.waitForText(page.outputName, "Name:Andrii");

        // Закриваємо браузер
        driver.quit();
    }
}
