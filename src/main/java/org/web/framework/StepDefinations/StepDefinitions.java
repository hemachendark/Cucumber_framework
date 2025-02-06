package org.web.framework.StepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.web.framework.driverManager.browserDriver;
import org.web.framework.pageObjects.Dashboard;
import org.web.framework.pageObjects.LoginPage;
import org.web.framework.pageObjects.SetPageObjects;

import java.text.MessageFormat;

public class StepDefinitions extends browserDriver {
    private static final Logger logger = LogManager.getLogger(StepDefinitions.class.getName());
    SetPageObjects setPageObjects;
    LoginPage loginPage;
    Dashboard dashboard;
    //Hooks
    @Before
    public void setup(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();


    }
    @After
    public  void set_down(){
        driver.close();
        driver.quit();
    }


    @Given("the user navigate to the {string} url")
    public void theUserNavigateToTheUrl(String url) {

        driver.navigate().to(url);
    }



    @And("the user clicks the {string} button on {string} page")
    public void theUserClicksTheButtonOnPage(String elementName, String objectName) {
        try {
//            this.setPageObjects = new SetPageObjects(objectName);
            this.setPageObjects = new SetPageObjects(driver,objectName);
            this.setPageObjects.getPageObject().clickWebElement(elementName);
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while attempting to tap  \"{0}\"", elementName));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }


    }

    @And("the verify that web element attribute {string} action {string} text {string} on {string} page")
    public void theVerifyThatWebElementAttributeActionTextOnPage(String attributeName, String action, String expectedValue, String objectName) {
        try {
            Thread.sleep(5000);
//            this.setPageObjects = new SetPageObjects(objectName);
            this.setPageObjects = new SetPageObjects(driver,objectName);
            this.setPageObjects.getPageObject().verifyWebElementAttribute(attributeName,action,expectedValue);
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while attempting verify \"{0}\"", attributeName));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }

    }

    @And("the user types {string} into  the {string} textField on {string} page")
    public void theUserTypesIntoTheTextFieldOnPage(String elementName, String value, String objectName) {

        try {
            Thread.sleep(2000);
            //this.setPageObjects = new SetPageObjects(objectName);
            System.out.println("setpage object name "+objectName);
            this.setPageObjects = new SetPageObjects(driver,objectName);
            this.setPageObjects.getPageObject().typeText(elementName,value);
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while typing text into \"{0}\"", elementName));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }


    }
}
