package test_runner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test_base.WebTestBase;
import web_ui.HomePage;

public class HomeTest extends WebTestBase {
    HomePage homePage;


    @BeforeClass
    public void setupObjects() {
        homePage = new HomePage(webDriver);

    }

    @Test(priority = 1)
    public void verifySearchBarAppear() {
        Assert.assertTrue(webDriver.findElement(homePage.getSearchBar()).isDisplayed());

    }

    @Test(priority = 2)
    public void verifySearchBarAccessible() {
        homePage.clickOnSearchBar();
        webDriver.findElement(homePage.getSearchBar()).sendKeys("Chefaa App");


    }

    @Test(priority = 3)
    public void verifyClearanceOfSearchBox() {
        homePage.clickOnDismissBtn();
        Assert.assertTrue(webDriver.findElement(homePage.getSearchBar()).getText().equalsIgnoreCase(""));
    }

    @Test(priority = 4)
    public void verifySearchResultDisplayed() {
        webDriver.findElement(homePage.getSearchBar()).sendKeys("Chefaa App", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getByFirstSearchResult()));
        Assert.assertTrue(homePage.findFirstSearchResult().isDisplayed());

    }

    @Test(priority = 5)
    public void verifySearchRelevantResult() {
        Assert.assertTrue(homePage.findFirstSearchResult().getText().contains("Chefaa"));

    }

}
