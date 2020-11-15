package devToPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;
    String url = "https://dev.to";

    @FindBy(xpath = "//a[@href='/top/week']")
    public WebElement weekBtn;

    @FindBy(xpath = "//a[@href='/top/month']")
    public WebElement monthBtn;

    @FindBy(xpath = "//a[@href=\"https://dev.to/pod\"]")
    public WebElement podcastBtn;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.get(url);
    }

    public void goToWeek(){
        weekBtn.click();
    }

    public void goToMonth() {
        monthBtn.click();
    }

    public void goToPocasts(){
        podcastBtn.click();
    }
}
