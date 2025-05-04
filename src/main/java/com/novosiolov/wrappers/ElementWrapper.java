package com.novosiolov.wrappers;

import org.openqa.selenium.WebElement;

public class ElementWrapper {

    public void setText(WebElement element, String text) {
        System.out.println("[LOG] Встановлюємо текст: " + text);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        String value = element.getText();
        System.out.println("[LOG] Отримано текст: " + value);
        return value;
    }

    public void waitForText(WebElement element, String expectedText) {
        System.out.println("[LOG] Очікуємо текст: " + expectedText);
        int retries = 5;
        while (retries-- > 0) {
            if (element.getText().equals(expectedText)) {
                System.out.println("[LOG] Текст знайдено.");
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[WARN] Текст не зʼявився.");
    }
}

