package web_ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPageBase {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By searchBar = By.id("APjFqb");

    private final By googleLogo = By.className("lnXdpd");

    private final By firstResult = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']");

    private final By dismissBtn = By.className("vOY7J");

    public void clickOnSearchBar() {
        webDriver.findElement(searchBar).click();
    }

    public String getGoogleLogo() {
        return webDriver.findElement(googleLogo).getText();
    }
    public By getSearchBar(){
        return searchBar;
    }
    public By getByFirstSearchResult(){
        return firstResult;
    }
    public WebElement findFirstSearchResult(){
       return webDriver.findElement(searchBar);
    }
    public void clickOnDismissBtn(){
        webDriver.findElement(dismissBtn).click();
    }
}
