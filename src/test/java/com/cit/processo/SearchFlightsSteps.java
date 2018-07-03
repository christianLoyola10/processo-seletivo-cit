package com.cit.processo;



import static org.junit.Assert.assertEquals;
import java.awt.Component;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class SearchFlightsSteps {

    private WebDriver driver;
    
    
    @Given("^a user access the Azul website$")
    public void acessaAzulWebSite() {
    	System.setProperty("webdriver.gecko.driver", "D:\\Projetos\\geckodriver.exe");
    	driver = new FirefoxDriver();
    	driver.get("https://www.voeazul.com.br/en/home");
    }
    
    @And("^Departure field was filled with '(.+)'$")
    public void insertDeparture(String departure) {	
		Actions action = new Actions(driver);
    	WebElement origin = driver.findElement(By.xpath("//fieldset[@id='ticket-content']/div/div/div/div/div/a/span"));
		action.moveToElement(origin).build().perform();
		origin.click();
		WebElement city = driver.findElement(By.xpath("//div[@id='Brazil']/div/div[2]/div/div/div/div[4]/ul/li[8]/b"));
		city.click();
    }
 
    @And("^Departure Date field was filled with '(.+)'$")
    public void insertDepartureDate(String DepartureDate) {
		WebElement Date = driver.findElement(By.id("ticket-departure1"));
		Date.click();
		Date.sendKeys(DepartureDate);
    }
    
    @And("^Destination field was filled with '(.+)'$")
    public void insertDestination(String Destination) {
		Actions action = new Actions(driver);
    	WebElement destination = driver.findElement(By.xpath("//html//fieldset[@id='ticket-content']/div[@class='grid-g ps-relative']/div[@class='grid-12-24 gutter--t15 gutter--b5 gutter--l30 gutter--lg-l45']//a[@class='icon-0001 ps-right ps-top']/span[1]"));
		action.moveToElement(destination).build().perform();
		destination.click();
		WebElement city = driver.findElement(By.xpath("//li[contains(@class,'destination-0001__item')][contains(text(),'Florianópolis (FLN)')]"));
		city.click();
    }
    
    @And("^Return Date field was filled with '(.+)'$")
    public void insertReturnDate (String Return) {
		WebElement ReturnDateField = driver.findElement(By.id("ticket-arrival1"));
		ReturnDateField.click();
		ReturnDateField.sendKeys(Return);
    }
    
    @And("^Adult field was filled with '(.+)'$")
    public void insertAdult(String Adult) {
		WebElement adultField = driver.findElement(By.id("ticket-adults"));
		adultField.click();
		adultField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Adult);
		adultField.sendKeys(Adult);
    }
    
    @And("^Child field was filled with '(.+)'$")
    public void insertChild (String Child) {
		WebElement childField = driver.findElement(By.id("ticket-children"));
		childField.click();
		childField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Child);
		childField.sendKeys(Child);
    }
    
    @And("^Infant field was filled with '(.+)'$")
    public void insertInfant (String Infant) {
		WebElement infantField = driver.findElement(By.id("ticket-babies"));
		infantField.click();
		infantField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		infantField.sendKeys(Infant);
    }
    
    @When("^the Search and Buy button be pushed$")
    public void submitPage(){
    	WebElement submitButton = driver.findElement(By.xpath("//button[@class='button-0003 skin-0008 text--0001'][contains(text(),'Search and buy')]"));
    	submitButton.submit();
    }
    
    @Then("^the site shall redirect and show available flights with Departure as '(.+)'$")
    public void assertDepartureField(String Departure) throws Throwable {
    	Thread.sleep(20000);    	
    	WebElement changeSearchButton1 = driver.findElement(By.xpath("//div[@id='btnChangeSearch']"));
    	changeSearchButton1.click();
    	
    	WebElement departureField= driver.findElement(By.id("ticket-origin1"));
    	assertEquals(departureField.getText().trim(), Departure.trim());
    }
    @And ("^And departure date as '(.+)'$")
    public void assertDepartureDateField(String DepartureDate) throws Throwable {
    	WebElement departureDateField= driver.findElement(By.id("ticket-departure1"));
    	assertEquals(departureDateField.getText().trim(), DepartureDate.trim());
    }
    @And ("^And Arrival as '(.+)'$")
    public void assertArrivalField(String Arrival) throws Throwable {
    	WebElement arrivalField= driver.findElement(By.id("ticket-departure1"));
    	assertEquals(arrivalField.getText().trim(), Arrival.trim());
    }
    @And ("^And Arrival Date as '(.+)'$")
    public void assertArrivalDateField(String arrivalDate) throws Throwable {
    	WebElement arrivalDateField= driver.findElement(By.id("ticket-departure1"));
    	assertEquals(arrivalDateField.getText().trim(), arrivalDate.trim());
    }
}