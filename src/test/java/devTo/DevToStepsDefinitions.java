package devTo;

import devToPages.MainPage;
import devToPages.PodcastsPage;
import devToPages.SinglePodcastPage;
import driver.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DevToStepsDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    String podcastBtnHref;
    String podcastHrefFromList;
    MainPage mainPage;

    @Before
    public void setup() {
        BaseDriver baseDriver = new BaseDriver();
        driver = baseDriver.initializeChromeDriverInHeadlessMode();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //zanim wywalisz nosuchelementexception poczekaj przez 10 sek i co sekundę sprawdzaj czy element jest juz na stronie, dziala przy wszystkich kolejnych findElement() lub findElements()
    }

    @Given("I am on the devTo main page")
    public void i_am_on_the_dev_to_main_page() {
        mainPage = new MainPage(driver);
    }

    @When("I click on week button")
    public void i_click_on_week_button() {
        mainPage.goToWeek();
    }

    @When("I click on month button")
    public void iClickOnMonthButton() {
        mainPage.goToMonth();
    }

    @When("I go to podcasts page")
    public void i_go_to_podcasts_page() {
        podcastBtnHref = mainPage.podcastBtn.getAttribute("href");
        mainPage.goToPocasts();
    }

    @And("I select the first podcast from list")
    public void i_select_the_first_podcast_from_list() {
        wait.until(ExpectedConditions.urlToBe(podcastBtnHref));
        PodcastsPage podcastsPage = new PodcastsPage(driver);
        podcastHrefFromList = podcastsPage.firstPodcast.getAttribute("href");
        podcastsPage.selectFirstPodcast();
    }

    @And("I play the podcast")
    public void i_play_the_podcast() {
        SinglePodcastPage singlePodcastPage = new SinglePodcastPage(driver);
        wait.until(ExpectedConditions.visibilityOf(singlePodcastPage.playButton));
        singlePodcastPage.playPodcast();
    }

    @Then("I should be redirected to {string} page")
    public void i_should_be_redirected_to_page(String expected) {
        wait.until(ExpectedConditions.urlContains(expected));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(expected));
    }

    @Then("I should be redirected to valid podcast page")
    public void i_should_be_redirected_to_valid_podcast_page() {
        SinglePodcastPage singlePodcastPage = new SinglePodcastPage(driver);
        wait.until(ExpectedConditions.visibilityOf(singlePodcastPage.playButton));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Podcasts aren't the same", podcastHrefFromList, actualUrl);
    }

    @Then("Podcast should be played")
    public void podcast_should_be_played() {
        SinglePodcastPage singlePodcastPage = new SinglePodcastPage(driver);
        wait.until(ExpectedConditions.visibilityOf(singlePodcastPage.recordWrapper));
        singlePodcastPage.playPodcast();
        wait.until(ExpectedConditions.invisibilityOf(singlePodcastPage.initializing));
        boolean isRecordWrapperPlaying = singlePodcastPage.recordWrapper.getAttribute("class").contains("playing");
        Assert.assertTrue(isRecordWrapperPlaying);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
