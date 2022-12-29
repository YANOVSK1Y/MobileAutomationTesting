package pm.academy.ayanovskiy.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SportPage extends BasePage{

    @AndroidFindBy(accessibility = "Title Sports")
    private MobileElement sportsTitle;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])[1]")
    private MobileElement firstEventCard;

    @AndroidFindBy(xpath = "(//*[contains(@content-desc, 'eventCard')])[1]//*[contains(@content-desc, 'outcome_1')]")
    private MobileElement outcomeOneForFirstEventOnPage;

    @AndroidFindBy(accessibility = "quickBetPlaceButton")
    private MobileElement quickPlaceBetBtn;

    @AndroidFindBy(xpath = "(//*[@content-desc = 'rvSportEvents']/android.widget.FrameLayout)[2]//*[@content-desc = 'outcome_1']//*[@content-desc='odd']")
    private MobileElement firstOddForW1MainBlockOfContent;

    @AndroidFindBy(accessibility = "tvOddCoefficient")
    private MobileElement betSlipOddCoefficient;

    public void betFirstOutcomeFirstSportEvent(){
        waitForExpectedElement(outcomeOneForFirstEventOnPage).click();
    }

    public void placeBet(){
        waitForExpectedElement(quickPlaceBetBtn).click();
    }

    public double getOddForFirstMatchW1FromMainBlockOfContent(){
        return Double.parseDouble(waitForExpectedElement(firstOddForW1MainBlockOfContent).getText());
    }

    public double getOddForFirstMatchW1FromBetSlip(){
        return Double.parseDouble(waitForExpectedElement(betSlipOddCoefficient).getText());
    }

    @Override
    public boolean isPageExist() {
        return waitForExpectedElement(sportsTitle).isDisplayed() && waitForExpectedElement(firstEventCard).isDisplayed();
    }
}
