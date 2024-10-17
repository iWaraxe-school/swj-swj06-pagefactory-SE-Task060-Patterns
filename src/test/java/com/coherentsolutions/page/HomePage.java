package com.coherentsolutions.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

/**
 * Page Object encapsulates the Home Page as starting page
 */
public class HomePage extends BasePage {
    @FindBy(linkText = "Sign In")
    private WebElement signInBy;
    private final String HOME_PAGE_TITLE = "Home Page";
    private static final Logger logger = Logger.getLogger(HomePage.class.getName());
    private final String CUSTOMER_LOGIN_PAGE_TITLE = "Customer Login";


    public void getTitle() {
        if (!driver.getTitle().equals(HOME_PAGE_TITLE)) {
            throw new PageNotLoadedException("This is not Home page," +
                    " current page is: " + driver.getCurrentUrl());
        }
        logger.info("Home page is loaded successfully.");
    }

    /**
     * Click the link
     * Wait for 3 s
     * @return CustomerLoginPage object
     */
    public CustomerLoginPage clickLink() {
        signInBy.click();
        WebDriverWait waitMore = new WebDriverWait(driver, Duration.ofSeconds(3));
        waitMore.until(ExpectedConditions.titleIs(CUSTOMER_LOGIN_PAGE_TITLE));
        return new CustomerLoginPage();
    }
    /**
     * get sign in message by signInBy
     * @return text of sign in message
     */
    public String showSignInMessage() {
        return signInBy.getText();
    }
}
