package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    String baseUrl = "https://demowebshop.tricentis.com/login";
    private LoginPage dashboardPage;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigateToLoginPage(){
        driver.navigate().to(baseUrl);
        dashboardPage = new LoginPage(driver);
    }

    @Test(description = "Verify successful login and account visibility")
    public void loginSucess(){
        // driver.navigate().to(baseUrl);
        // DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.loginUser("nashtechhoang@gmail.com","123321456");
        Assert.assertTrue(dashboardPage.verifyWebElementIsDisplayed(dashboardPage.accountUser()));
    }
    @Test(description="Verify failed login")
    public void loginFail(){
        // driver.navigate().to(baseUrl);
        // DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.loginUser("nashtechhoang@gmail.com","123");
        Assert.assertTrue(dashboardPage.verifyWebElementIsDisplayed(dashboardPage.spanLoginUnsuccessful()));
        Assert.assertTrue(dashboardPage.verifyWebElementIsDisplayed(dashboardPage.liLoginUnsuccessful()));
        Assert.assertEquals(dashboardPage.getText(dashboardPage.spanLoginUnsuccessful()),"Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(dashboardPage.getText(dashboardPage.liLoginUnsuccessful()),"The credentials provided are incorrect");
    }
    @Test(description = "Verify blank field")
    public void loginFieldBlank(){
        // driver.navigate().to(baseUrl);
        // DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.loginUser("nashtechhoang@gmail.com","   ");
        Assert.assertTrue(dashboardPage.verifyWebElementIsDisplayed(dashboardPage.spanLoginUnsuccessful()));
        Assert.assertTrue(dashboardPage.verifyWebElementIsDisplayed(dashboardPage.liLoginUnsuccessful()));
        Assert.assertEquals(dashboardPage.getText(dashboardPage.spanLoginUnsuccessful()),"Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(dashboardPage.getText(dashboardPage.liLoginUnsuccessful()),"The credentials provided are incorrect");
    }
    @Test(description = "Verify Tab functionality")
    public void tabIsWorking(){
        // driver.navigate().to(baseUrl);
        // DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.useTab();
        Assert.assertEquals(dashboardPage.inputRememberMe(),dashboardPage.focusedElement());
    }
    @Test(description = "Verify Enter is working")
    public void enterIsWorking(){
        // driver.navigate().to(baseUrl);
        // DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.loginEnter();
        Assert.assertEquals(dashboardPage.getText(dashboardPage.spanLoginUnsuccessful()),"Login was unsuccessful. Please correct the errors and try again.");
    }
    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
