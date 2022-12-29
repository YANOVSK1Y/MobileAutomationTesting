package pm.academy.ayanovskiy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage{

    @AndroidFindBy(accessibility = "Login title")
    private MobileElement loginTitle;

    @Override
    public boolean isPageExist() {
        return waitForExpectedElement(loginTitle).isDisplayed();
    }
}
