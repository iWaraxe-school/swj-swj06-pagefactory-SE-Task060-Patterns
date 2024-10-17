package com.coherentsolutions.test;

import com.coherentsolutions.page.CustomerLoginPage;
import com.coherentsolutions.page.HomePageAfterLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/***
 * Tests login feature
 */
public class LoginTest extends BaseTest {
    private CustomerLoginPage customerLoginPage;

    /**
     * Initializes the test by navigating to the CustomerLoginPage page.
     */
    @BeforeEach
    public void goToCustomerLoginPage() {
        customerLoginPage = homePage.clickLink();
    }

    /**
     * The method acts as a source of data for the test method below.
     */
    private static Stream<Arguments> inputs() {
        return Stream.of(
                Arguments.of("sashakrupskaya@maildrop.cc", "Qwerty123!")
        );
    }
    /**
     *
     * login and password from source "inputs" are as attributes
     * Method sendKeys is called
     * Method login when use Explicit Wait with polling frequency is called
     * As a proof of successful login welcome message is verified
     */
    @ParameterizedTest
    @MethodSource("inputs")
    public void testLogin(String login, String password) {
        customerLoginPage.sendKeys(login, password);
        HomePageAfterLogin homePageAfterLogin = customerLoginPage.login();

        assertTrue(homePageAfterLogin.showWelcomeMessage().contains("Welcome,"), "Welcome message is not shown.");
    }
}

