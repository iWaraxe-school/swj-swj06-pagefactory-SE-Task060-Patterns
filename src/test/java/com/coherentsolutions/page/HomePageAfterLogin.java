package com.coherentsolutions.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object encapsulates the Home Page after login
 */
public class HomePageAfterLogin extends BasePage {

    @FindBy(css = "span.logged-in")
    private WebElement welcomeBy;
    @FindBy(className = "customer-name")
    private WebElement switchBy;
    @FindBy(xpath = "//a[contains (text(), 'Sign Out')]")
    private WebElement signOutBy;
    @FindBy(linkText = "Sign In")
    private WebElement  signInBy;


    /**
     * get welcome message by welcomeBy
     * @return text of welcome message
     */
    public String showWelcomeMessage() {
        return welcomeBy.getText();
    }
    /**
     * get switch by switchBy
     * click the switch
     * wait for sign out link to display
     * click sign out
     * wait for 6 s to display sign in message
     * @return Home Page back
     */
    public HomePage logout() {
        switchBy.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(signOutBy));
        signOutBy.click();
        wait.until(ExpectedConditions.visibilityOf(signInBy));
        return new HomePage();
    }
}

