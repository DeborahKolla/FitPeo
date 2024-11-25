package testCase;

import baseClass.BaseClass;
import org.testng.annotations.Test;
import pageObject.HomePageObject;
import pageObject.RevenueCalculatorPageObject;

public class HomePageTestCase extends BaseClass {


    @Test(priority = 1)
    public void validateTextToSlider() throws Exception {

        HomePageObject openHomepage = new HomePageObject(driver);
        openHomepage.navigateToHomePage();
        System.out.println("Home page opened");

        RevenueCalculatorPageObject revenueCalculatorPageObject = new RevenueCalculatorPageObject(driver);


        revenueCalculatorPageObject.clickRevenueCalculator();

        revenueCalculatorPageObject.inputTextForSlider();




    }


    @Test(priority = 2)
    public void validateRecurringAmount() throws Exception {

        HomePageObject openHomepage = new HomePageObject(driver);
        openHomepage.navigateToHomePage();
        System.out.println("Home page opened");

        RevenueCalculatorPageObject  revenueCalculatorPageObject = new RevenueCalculatorPageObject(driver);


        revenueCalculatorPageObject.clickRevenueCalculator();

        revenueCalculatorPageObject.moveSlider();
        revenueCalculatorPageObject.clickCheckBoxes();
       revenueCalculatorPageObject.validateRecurringAmount();




    }





}
