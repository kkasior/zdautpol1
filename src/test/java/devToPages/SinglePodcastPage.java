package devToPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SinglePodcastPage {
    WebDriver driver;
    @FindBy(className = "record")
    public WebElement playButton;

    @FindBy(className = "record-wrapper")
    public WebElement recordWrapper;

    @FindBy(className = "status-message")
    public WebElement initializing;

    public SinglePodcastPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void playPodcast(){
        playButton.click();
    }
}
