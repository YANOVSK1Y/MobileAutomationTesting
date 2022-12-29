package pm.academy.ayanovskiy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "com.parimatch:id/ivLogo")
    private MobileElement mainLogo;

    @AndroidFindBy(accessibility = "Top match")
    private MobileElement mainContentBlock;

    @AndroidFindBy(accessibility = "bottomNavigation")
    private MobileElement bottomNavBar;

    @AndroidFindBy(accessibility = "sport-tab")
    private MobileElement bottomSportsPageBtn;

    public boolean isMainLogeDisplayed() {
        return waitForExpectedElement(mainLogo).isDisplayed();
    }

    public boolean isMainContentBlock() {
        return waitForExpectedElement(mainContentBlock).isDisplayed();
    }

    public boolean isBottomNavBarExist() {
        return waitForExpectedElement(bottomNavBar).isDisplayed();
    }

    public void openSportPage(){
        waitForExpectedElement(bottomSportsPageBtn).click();
    }
    @Override
    public boolean isPageExist() {
        return isMainLogeDisplayed() && isMainContentBlock() && isBottomNavBarExist();
    }
}
