package com.coherentsolutions.page;

import com.coherentsolutions.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * BasePage provides a common structure for all page classes.
 * It holds the WebDriver instance and is used as a parent class for specific pages.
 */
public abstract class BasePage {

    protected WebDriver driver;

    /**
     * Constructor that initializes the WebDriver instance by calling DriverManager.
     * It initializes the WebElements using PageFactory.
     *
     * driver and page are as parameters
     */
    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}