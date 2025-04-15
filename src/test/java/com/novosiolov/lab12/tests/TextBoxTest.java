package com.novosiolov.lab12.tests;

import com.novosiolov.lab12.pages.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TextBoxTest {

    private WebDriver driver;
    private TextBoxPage page;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        page = new TextBoxPage(driver);
    }

    @Test
    public void testTextBoxWrapperLogging() {
        String name = "Andrii";
        String email = "andrii@example.com";
        String address = "Kyiv";

        page.fullName().setText(name);
        page.email().setText(email);
        page.address().setText(address);

        page.fullName().waitForText(name);
        page.email().waitForText(email);

        page.clickSubmit();

        assert page.fullName().getText().equals(name);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
