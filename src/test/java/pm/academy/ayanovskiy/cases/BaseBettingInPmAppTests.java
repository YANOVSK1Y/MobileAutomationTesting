package pm.academy.ayanovskiy.cases;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pm.academy.ayanovskiy.base.BaseTest;
import pm.academy.ayanovskiy.pages.LoginPage;
import pm.academy.ayanovskiy.pages.MainPage;
import pm.academy.ayanovskiy.pages.RegistrationPage;
import pm.academy.ayanovskiy.pages.SportPage;

public class BaseBettingInPmAppTests extends BaseTest {

    /**
     * Test main logic. Base open application, close register window and opan main page.
     */
    @Test
    public void mainPageLoadingTest(){
        SoftAssertions softAssertions = new SoftAssertions();
        RegistrationPage registrationPage = new RegistrationPage();

        softAssertions.assertThat(new RegistrationPage().isPageExist()).isTrue();
        if (registrationPage.isCloseBtnDisplayed()){
            registrationPage.closeRegistrationForm();
        }
        registrationPage.openMainPage();
        softAssertions.assertThat(new MainPage().isPageExist()).isTrue();
        softAssertions.assertAll();
    }

    /**
     * Place bet testing.
     * Open application, close register page,
     * open sport page, place bet and check opened register page.
     */
    @Test
    public void betOnEventTest(){
        SoftAssertions softAssertions = new SoftAssertions();

        // if registration window exist, close it
        if (new RegistrationPage().isPageExist() && new RegistrationPage().isCloseBtnDisplayed()){
            new RegistrationPage().closeRegistrationForm();
        }

        softAssertions.assertThat(new MainPage().isBottomNavBarExist()).isTrue();

        new MainPage().openSportPage();
        softAssertions.assertThat(new SportPage().isPageExist()).isTrue();

        new SportPage().betFirstOutcomeFirstSportEvent();

        // Comparing odd coefficients. From main block of games and from betSlip.
        softAssertions.assertThat(new SportPage().getOddForFirstMatchW1FromMainBlockOfContent()).isEqualTo(new SportPage().getOddForFirstMatchW1FromBetSlip());

        new SportPage().placeBet();

        softAssertions.assertThat(new LoginPage().isPageExist()).isTrue();

        softAssertions.assertAll();
    }
}
