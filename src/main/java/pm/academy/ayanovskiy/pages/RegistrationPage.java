package pm.academy.ayanovskiy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationPage extends BasePage {
    private static final Logger LOG = LogManager.getRootLogger();
    @AndroidFindBy(accessibility = "close_button")
    private MobileElement closeRegistrationFormBtn;
    @AndroidFindBy(accessibility = "bottomNavigation")
    private MobileElement bottomNavBar;
    @AndroidFindBy(accessibility = "registration_page_title")
    private MobileElement registrationTitle;

    @AndroidFindBy(accessibility = "top-tab")
    private MobileElement mainPageBtn;

    @AndroidFindBy(accessibility = "sport-tab")
    private MobileElement sportTabBtn;

    public boolean isCloseBtnDisplayed() {
        try {
            return waitForExpectedElement(closeRegistrationFormBtn).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException tmEx) {
            LOG.error("Error: " + tmEx);
            return false;
        }
    }

    public void closeRegistrationForm() {
        waitForExpectedElement(closeRegistrationFormBtn).click();
    }

    public void openMainPage() {
        waitForExpectedElement(mainPageBtn).click();
    }

    public void openSportPage(){
        waitForExpectedElement(sportTabBtn).click();
    }

    @Override
    public boolean isPageExist() {
        return waitForExpectedElement(registrationTitle).isDisplayed();
    }
}
