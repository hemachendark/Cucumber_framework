package org.web.framework.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.web.framework.driverManager.browserDriver;

import java.text.MessageFormat;

public class Dashboard extends browserDriver implements PageObjectsInterface
{
//    WebDriver driver;
    Wait<WebDriver> wait;
    static final Logger logger = LogManager.getLogger(PageObjectsInterface.class.getName());

    By dashboard_headerText = By.xpath("//div[@class=\"mat-mdc-card-header-text\"]");
    By logged_out_button=By.xpath("//button[@id='logoutButton']//span[@class='mat-mdc-button-touch-target']");
    By my_results_button=By.xpath("//button[@id='resultsButton-button']");
    By my_results_page_headertxt=By.xpath("//h1[normalize-space()='Pathology Results']");
    By filter_text_search=By.xpath("//input[@id='mat-input-0']");
    By load_report_btn= By.xpath("(//button[@mattooltip=\"Episode report\"]//span[@class=\"mdc-button__label\"])[1]");
    By download_btn=By.xpath("//button[@id='download']");
    By cumulative_btn= By.xpath("//button[@mattooltipclass=\"customTooltip\"]//span[normalize-space()='Cumulative']");
By pathcare_southafrica_btn =By.xpath("//div[@class='cdk-overlay-container']//button[1]");
By my_profile_btn=By.xpath("//button[@id='profileButton-button']");
By id_numbr=By.xpath("//td[normalize-space()='7810275800089']");
By user_name=By.xpath("//td[normalize-space()='FLINTSTONE']");
By fst_name =By.xpath("//td[normalize-space()='FRED']");
By email=By.xpath("//td[normalize-space()='tmpkceml.7810275800089@pathcare.co.za']");
By cell_num =By.xpath("//td[normalize-space()='083 590 6677']");
By default_practice_txt=By.xpath("//span[@class='ng-star-inserted']");


    public Dashboard(WebDriver driver) {
        this.driver=driver;
    }

//    public Dashboard(WebDriver driver){
//
//        this.driver = null;
//        this.wait =null;
//
//    }

    public WebElement getWebElement(String elementName)  {
        {
            WebElement el = null;
            switch (elementName.toLowerCase()) {
                case "dashboard_textfield":
                    el = this.driver.findElement(dashboard_headerText);
                    break;
                case "log_out_button":
                    el = this.driver.findElement(logged_out_button);
                    break;
                case "my_result_btn":
                    el = this.driver.findElement(my_results_button);
                    break;
                case "my_result_header_txt":
                    el = this.driver.findElement(my_results_page_headertxt);
                    break;
                case "filter_result":
                    el = this.driver.findElement(filter_text_search);
                    break;
                case "load_report_button":
                    el = this.driver.findElement(load_report_btn);
                    break;
                case "download_button":
                    el = this.driver.findElement(download_btn);
                    break;
                case "cumulative_button":
                    el = this.driver.findElement(cumulative_btn);
                    break;
                case "pathcare_southafrica_button":
                    el = this.driver.findElement(pathcare_southafrica_btn);
                    break;
                case "my_profile_button":
                    el = this.driver.findElement(my_profile_btn);
                    break;
                case "id_number_txt":
                    el = this.driver.findElement(id_numbr);
                    break;
                case "user_name_txt":
                    el = this.driver.findElement(user_name);
                    break;
                case "first_name_txt":
                    el = this.driver.findElement(fst_name);
                    break;
                case "email_txt":
                    el = this.driver.findElement(email);
                    break;
                case "cell_txt":
                    el = this.driver.findElement(cell_num);
                    break;
                case "default_practice_text":
                    el = this.driver.findElement(default_practice_txt);
                    break;

            }
            assert el !=null;

            return el;
        }
    }




    public void typeText(String element, String text) throws InterruptedException {
        {

            WebElement webElement = getWebElement(element);
            assert webElement != null;
            webElement.sendKeys(text);

        }
    }

    public void clickWebElement(String elementName) throws InterruptedException {
        WebElement webElement = this.getWebElement(elementName);
        assert webElement != null;
        webElement.click();
    }


    public boolean verifyWebElementAttribute(String attributeName, String action, String expectedValue) {
           WebElement element=this.getWebElement(attributeName);
           String actualValue=element.getText().trim();
           logger.debug("Actual value = "+ actualValue);
           logger.debug("Expected value = "+ expectedValue);
        if(action.equals("contains")){
            return actualValue.contains(expectedValue.trim());
        } else if (action.equals("is_equal_to")) {
            return  actualValue.equals(expectedValue);
        }else {

            logger.error(MessageFormat.format("Comparison type {0} is unsupported",action));
        }


        return false;
    }


}
