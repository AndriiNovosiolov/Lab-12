package com.novosiolov.lab12.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TextBoxElement {
    private final WebElement element;
    private final WebDriver driver;

    public TextBoxElement(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    public void setText(String text) {
        System.out.println("👉 setText(): " + text);
        element.clear();
        element.sendKeys(text);
    }

    public String getText() {
        String value = element.getAttribute("value");
        System.out.println("📥 getText(): " + value);
        return value;
    }

    public void waitForText(String expectedText) {
        System.out.println("⏳ waitForText(): " + expectedText);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> element.getAttribute("value").equals(expectedText));
        System.out.println("✅ Text appeared");
    }
}

