package com.novosiolov.lab12.pages;

import com.novosiolov.lab12.elements.TextBoxElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TextBoxPage {
    private final WebDriver driver;

    @FindBy(id = "userName")
    private WebElement fullNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "currentAddress")
    private WebElement addressInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TextBoxElement fullName() {
        return new TextBoxElement(driver, fullNameInput);
    }

    public TextBoxElement email() {
        return new TextBoxElement(driver, emailInput);
    }

    public TextBoxElement address() {
        return new TextBoxElement(driver, addressInput);
    }

    public void clickSubmit() {
        System.out.println("🖱️ clickSubmit()");
        submitButton.click();
    }
}
