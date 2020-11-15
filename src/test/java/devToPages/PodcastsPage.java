package devToPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PodcastsPage {
    WebDriver driver;
    String url = "https://dev.to/pod";
    @FindBy(css = "div.articles-list > div > a:first-child")
    public WebElement firstPodcast;
    @FindBy(tagName = "h3")
    public  WebElement firstPodcastClicable;
    public PodcastsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void selectFirstPodcast(){
        firstPodcastClicable.click();
    }
}
