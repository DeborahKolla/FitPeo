package baseClass;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.ReadConfig;


public class BaseClass {

    static ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getApplicationURL();

    protected static WebDriver driver;


    @BeforeClass
    public WebDriver launchBrowser() throws InterruptedException {


        // Auto download the chrome Driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions  disableEvent =  new ChromeOptions();  // Disbled unexpected event occure while lounching chrome browser

        driver = new ChromeDriver(disableEvent);

        disableEvent.addArguments("--disable-extensions"); // Disable extensions

        disableEvent.addArguments("--disable-web-security"); // Disable webSecurity
        disableEvent.addArguments("--ignore-certificate-errors"); // ignore certificate error.
        disableEvent.addArguments("--disable-popup-blocking");
//

        driver.get(baseURL); // hit the url on the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);



        return driver;

    }




    @AfterClass

    public void quit() {

        driver.quit();
    }




}
