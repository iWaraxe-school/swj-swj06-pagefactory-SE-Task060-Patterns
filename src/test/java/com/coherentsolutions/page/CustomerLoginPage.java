package com.coherentsolutions.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

/**
 * Page Object encapsulates the Customer Login page
 */
public class CustomerLoginPage extends BasePage {
    @FindBy(name = "login[username]")
    private WebElement usernameBy;
    @FindBy(name = "login[password]")
    private WebElement passwordBy;
    @FindBy(name = "send")
    private WebElement signinBy;
    @FindBy(css = "span.logged-in")
    private WebElement welcomeBy;

    /**
     * Method to send attribute to userName and password
     */
    public void sendKeys(String userName, String password) {
        usernameBy.sendKeys(userName);
        passwordBy.sendKeys(password);
    }
    /**
     * Log in method
     * Explicit wait is used to wait until welcome text is shown
     * Polling every 5 s, total 30
     * So exception will be shown in case during 30 s element is not found
     */
    public HomePageAfterLogin login() {
        signinBy.click();
        Wait<WebDriver> waitMore = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5));
        waitMore.until(ExpectedConditions.visibilityOf(welcomeBy));
        return new HomePageAfterLogin();
    }
}
