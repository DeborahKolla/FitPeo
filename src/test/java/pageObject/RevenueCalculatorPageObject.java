package pageObject;

import baseClass.BaseClass;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;





import java.awt.AWTException;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class RevenueCalculatorPageObject extends BaseClass {

    public RevenueCalculatorPageObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/revenue-calculator']//div[contains(text(),'Revenue Calculator')]")
    @CacheLookup
    public WebElement revenueCalculatorElement;

    // Scroll slider upto the value 820 take original
    By sliderBallMovementElement = By.cssSelector(
            ".MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.css-sy3s50");

    By sliderBallElement = By.xpath("//input[@type='range']");

    By textBoxBySliderBoxElement = By.xpath(
            "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']");


    // Enter the text value 560
    By textBoxBySliderElement = By.id(":r9:");  // not using

    By textBoxBySliderElementDisable = By.id(":R57alklff9da:");  // not using


    By totalRecurring = By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per Month:')]//following-sibling::p");




    // Start the logic from here

    JavascriptExecutor jsExecute = (JavascriptExecutor) driver;

    public void clickRevenueCalculator() throws InterruptedException {

        revenueCalculatorElement.click();
        Thread.sleep(1000);

        System.out.println("click on the Revenue Calculator");

    }

    // Validate Text input value from slider
    public void inputTextForSlider() throws InterruptedException, AWTException {

        WebElement textBoxBySlider = driver.findElement(textBoxBySliderBoxElement);

        WebElement sliderBall = driver.findElement(sliderBallElement);

        jsExecute.executeScript("arguments[0].scrollIntoView(false);", sliderBall);

        textBoxBySlider.click();

        int EnterTheValueInTextInputField = 0; // The number you want to enter


        // Clean text input
        textBoxBySlider.sendKeys(Keys.CONTROL, "a");
        textBoxBySlider.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(2000);
        // Press the up arrow key the required number of times
        while(EnterTheValueInTextInputField<560) {

            textBoxBySlider.sendKeys(Keys.ARROW_UP);
            EnterTheValueInTextInputField++;
        }

        Thread.sleep(2000);
        // Take the value of slider
        String sliderValueAfterEnterValue = sliderBall.getAttribute("aria-valuenow");

        String textBoxBySliderValue = textBoxBySlider.getAttribute("value");

        System.out.println("Slider current Value is " + sliderValueAfterEnterValue);

        Assert.assertEquals(textBoxBySliderValue, sliderValueAfterEnterValue);

        System.out.println("inputTextForSlider() run successfully ");

    }

    // Validate Slider value from input text
    public void moveSlider() throws Exception {


        WebElement sliderBall = driver.findElement(sliderBallElement);

        //	WebElement textBoxBySlider = driver.findElement(textBoxBySliderElementDisable);
        WebElement textBoxBySlider = driver.findElement(textBoxBySliderBoxElement);

        jsExecute.executeScript("arguments[0].scrollIntoView(false);", textBoxBySlider); // scroll on the element

        int setTheSliderValue = 820;


        // Clean text input
        textBoxBySlider.sendKeys(Keys.CONTROL, "a");
        textBoxBySlider.sendKeys(Keys.BACK_SPACE);

        for (int i = 0; i < setTheSliderValue; i++) {
            sliderBall.sendKeys(Keys.ARROW_UP);
        }

        // Take the value of slider
        String sliderValueAfterEnterValue = sliderBall.getAttribute("aria-valuenow");

        String textBoxBySliderValue = textBoxBySlider.getAttribute("value");

        System.out.println("Slider current Value is " + sliderValueAfterEnterValue);


        Assert.assertEquals(textBoxBySliderValue, sliderValueAfterEnterValue);

    }

    // CPT-99091, CPT-99453, CPT-99454, and CPT-99474

    public void clickCheckBoxes(){

        // Select the first checkbox (CPT-99091)
        WebElement checkbox1 = driver.findElement(By.xpath("//p[text()='CPT-99091']/following-sibling::label//input[@type='checkbox']"));
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        // Select the second checkbox (CPT-99453)
        WebElement checkbox2 = driver.findElement(By.xpath("//p[text()='CPT-99453']/following-sibling::label//input[@type='checkbox']"));
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        // Select the third checkbox (CPT-99454)
        WebElement checkbox3 = driver.findElement(By.xpath("//p[text()='CPT-99454']/following-sibling::label//input[@type='checkbox']"));
        if (!checkbox3.isSelected()) {
            checkbox3.click();
        }

        // Select the checkbox for CPT-99474
        WebElement checkbox4 = driver.findElement(By.xpath("//p[text()='CPT-99474']/following-sibling::label//input[@type='checkbox']"));
        if (!checkbox4.isSelected()) {
            checkbox4.click();
        }



    }




    // Validate Recurring Amount
    public void validateRecurringAmount() {

        String actualRecurringAmount = "110700";

        WebElement recurringAmount = driver.findElement(totalRecurring);  // Header value

        String takeFromUIRecurringAmount = recurringAmount.getText().substring(1); // Remove the dollar sign

        System.out.println("takeFromUI "+takeFromUIRecurringAmount);

        Assert.assertEquals(takeFromUIRecurringAmount, actualRecurringAmount);


    }




}