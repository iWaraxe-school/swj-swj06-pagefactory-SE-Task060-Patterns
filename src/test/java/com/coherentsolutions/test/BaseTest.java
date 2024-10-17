package com.coherentsolutions.test;

import com.coherentsolutions.page.HomePage;
import com.coherentsolutions.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * BaseTest is a base class for all test classes.
 * It sets up and tears down the WebDriver and handles the initialization of common resources.
 */
public class BaseTest {

    private static final String BASE_URL = TestConfig.get("url.home");
    protected HomePage homePage;

    /**
     * Initializes the test environment, including opening the browser and navigating to the home page.
     */
    @BeforeEach
    public void setUp() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(BASE_URL);
        homePage = new HomePage();
        homePage.getTitle();
    }

    /**
     * Tears down the WebDriver instance after each test.
     */
    @AfterEach
    public void cleanUp() {
        DriverManager.tearDown();
    }
}
