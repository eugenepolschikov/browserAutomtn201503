package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by ypolshchykau on 31.03.2015.
 */
public class DriverInit {
    private WebDriver driver;

    private final static Logger log = LoggerFactory.getLogger(DriverInit.class);
    /*public static LoginPage loginPage;
    public static FacebookUserPage homePage;
*/


//staring   hub - nodes model (on local WIN machine) over GhostDriver- pHantomJS


    public static WebDriver driverGhostInit(WebDriver driver) throws MalformedURLException {


//        File phantomjs = Phanbedder.unpack(); //Phanbedder to the rescue!

        File phantomjs = new File(System.getProperty("java.io.tmpdir") + File.separator + "phantomjs-1.9.7");


        DesiredCapabilities dcaps = new DesiredCapabilities();
        dcaps.setCapability("takesScreenshot", true);


        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());

// !!!!! hardCoded initizliations of GhostDriver node
//        driver = new RemoteWebDriver(new URL("http://localhost:8080"), dcaps);

//    driver initialization   using  method  providing IP of running Ghost node connected to running hub
//        this.driver= new RemoteWebDriver(new URL("http://"+getGhostNodesIp()+":8080"),dcaps);

//        node  connected to linux hub OR in local mode:
        driver = new RemoteWebDriver(new URL("http://localhost:8080"), dcaps);


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        //page instances init()
//        loginPage = PageFactory.initElements(driver, LoginPage.class);
//        homePage = PageFactory.initElements(driver, FacebookUserPage.class);
        return driver;


    }


}
