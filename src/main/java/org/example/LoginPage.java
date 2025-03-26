package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement emailLogin(){
        return driver.findElement(By.xpath("//input[@id='Email']"));
    }
    public WebElement passwordLogin(){
        return driver.findElement(By.xpath("//input[@id='Password']"));
    }
    private WebElement buttonLogin(){
        return driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
    }
    public WebElement accountUser(){
        return driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@class='account']"));
    }

    public WebElement spanLoginUnsuccessful(){
        return driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
    }
    public WebElement liLoginUnsuccessful(){
        return driver.findElement(By.xpath("//div[@class='validation-summary-errors']/ul/li"));
    }

    public WebElement inputRememberMe(){
        return driver.findElement(By.xpath("//input[@id='RememberMe']"));
    }

    public void loginUser(String email,String password){
        emailLogin().sendKeys(email);
        passwordLogin().sendKeys(password);
        buttonLogin().click();
    }

    public boolean verifyWebElementIsDisplayed(WebElement value){
        return value.isDisplayed();
    }
    public String getText(WebElement element){
        return element.getText();
    }
    public WebElement focusedElement(){
        return driver.switchTo().activeElement();
    }
    public void useTab(){
        emailLogin().sendKeys(Keys.TAB);
        passwordLogin().sendKeys(Keys.TAB);
    }
    public void loginEnter(){
        emailLogin().sendKeys(Keys.ENTER);
    }
}
