package org.web.framework.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.web.framework.driverManager.browserDriver;


public class SetPageObjects extends browserDriver {
    PageObjectsInterface pageObjectsInterface;
    String pageObjectName;
    WebDriverWait wait;
//browserDriver browserdriver =browserDriver.getInstance();

    public SetPageObjects(){
        driver= null;
        this.wait = null;
        this.pageObjectsInterface = null;
    }

    public SetPageObjects(WebDriver driver,String objectName) {

        this();
        this.driver=driver;
        this.pageObjectName = objectName;

    }

        private void setPageObject(PageobjectsEnum objName) {
        switch (objName) {
            case LOGINPAGE:
                this.pageObjectsInterface = new LoginPage(driver);
                break;
            case DASHBOARD:
                this.pageObjectsInterface =  new Dashboard(driver);
                break;
            default:

        }
    }
    public PageObjectsInterface  getPageObject( ){

        switch(pageObjectName.toLowerCase().trim()) {

            case "login_page":
                this.setPageObject(PageobjectsEnum.LOGINPAGE);
                break;
            case "dashboard_page":
                this.setPageObject(PageobjectsEnum.DASHBOARD);
                break;
            default:
                this.pageObjectsInterface = null;
        }
        assert this.pageObjectsInterface != null;
        return this.pageObjectsInterface;


    }

    }

