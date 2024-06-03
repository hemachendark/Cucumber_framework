package org.web.framework.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserDriver {

    public WebDriver driver;
    private static browserDriver instance;

    public browserDriver(){
        this.driver=driver;
    }

//    public static synchronized browserDriver getInstance(){
//        if(instance == null){
//            instance = new browserDriver();
//        }
//        return instance;
//    }

    public void getDriverLaunch(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void setDown(){

        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        assert  this.driver != null;
        return driver;
    }
}
