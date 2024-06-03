package org.web.framework.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Wait;
import org.web.framework.driverManager.browserDriver;

import java.text.MessageFormat;

public class LoginPage extends browserDriver implements PageObjectsInterface {


    //public WebDriver driver;
    Wait<WebDriver> wait;
    static final Logger logger = LogManager.getLogger(PageObjectsInterface.class.getName());

    By usernameTextField = By.name("username");
    By passwordTextField = By.xpath("//input[@id=\"password\"]");
    By signInButton = By.xpath("//input[@name=\"login\"]");

    public LoginPage(WebDriver driver) {
       this.driver=driver;
    }


    public WebElement getWebElement(String elementName) throws InterruptedException {
        {
            WebElement el = null;
            switch (elementName.toLowerCase()) {
                case "username_textfield":
                    System.out.println("By locator "+usernameTextField);
                    el = this.driver.findElement(usernameTextField);
                    break;
                case "password_textfield":
                    el = this.driver.findElement(passwordTextField);
                    break;
                case "sign_in_button":
                    el = this.driver.findElement(signInButton);
                    break;

            }
            assert el !=null;

            return el;
        }
    }

    @Override
    public void typeText(String element, String text) throws InterruptedException {
        {
            WebElement webElement = getWebElement(element);
            System.out.println("webelement locator "+webElement);
            assert webElement != null;
            webElement.sendKeys(text);

        }
    }

    public void clickWebElement(String elementName) throws InterruptedException {
        WebElement webElement = this.getWebElement(elementName);
        System.out.println(" click webelement locator "+webElement);
        assert webElement != null;
          webElement.click();
    }
    public boolean verifyWebElementAttribute(String attributeName, String action, String expectedValue) throws InterruptedException {
        WebElement element=this.getWebElement(attributeName);
        String actualValue=element.getText().trim();
        logger.debug("Actual value = "+ actualValue);
        logger.debug("Expected value = "+ expectedValue);
        if(action.equals("contains")){
            return  actualValue.contains(expectedValue.trim());
        } else if (action.equals("is_equal_to")) {
            return  actualValue.equals(expectedValue);
        }else {

            logger.error(MessageFormat.format("Comparison type {0} is unsupported",action));
        }

        return false;
    }
}
