package devTo;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevToStepsDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Given("I am on the devTo main page")
    public void i_am_on_the_dev_to_main_page() {
        driver.get("https://dev.to");
    }
    @When("I click on week button")
    public void i_click_on_week_button() {
        driver.findElement(By.xpath("//a[@href='/top/week']")).click();
    }
    @When("I click on month button")
    public void iClickOnMonthButton() {
        driver.findElement(By.xpath("//a[@href='/top/month']")).click();
    }
    @Then("I should be redirected to {string} page")
    public void i_should_be_redirected_to_page(String expected) {
        wait.until(ExpectedConditions.urlContains(expected));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(expected));
    }
}
