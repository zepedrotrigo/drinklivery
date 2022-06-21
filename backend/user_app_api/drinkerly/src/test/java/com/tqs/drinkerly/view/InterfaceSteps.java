package com.tqs.drinkerly.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.CoreMatchers;
import org.hamcrest.text.IsEmptyString;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class InterfaceSteps {
    private WebDriver driver;
    private Random rand;
    private String rng;

    // Test User Register in App Scenario Steps

    @When("I load the webpage {string}")
    public void loadWebPage(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("I click the Enter button located in the navigation bar")
    public void clickEnterButton() {
        driver.findElement(By.id("enterBtn")).click();
    }

    @And("I fill the signup form with my information")
    public void FillSignUpForm() {
        rand = new Random();
        rng = Integer.toString(rand.nextInt(999999999-911111111) + 911111111);

        driver.findElement(By.id("registerFirstName")).sendKeys("José");
        driver.findElement(By.id("registerLastName")).sendKeys("Trigo");
        driver.findElement(By.id("registerAge")).sendKeys("21");
        driver.findElement(By.id("registerEmail")).sendKeys("josetrigo"+rng+"@ua.pt");
        driver.findElement(By.id("registerPhone")).sendKeys(rng);
        driver.findElement(By.id("registerAddress")).sendKeys("Campus de Santiago");
        driver.findElement(By.id("registerNIF")).sendKeys(rng);
        driver.findElement(By.id("registerPassword")).sendKeys("testingpassword123");
        driver.findElement(By.id("registerConfirmPassword")).sendKeys("testingpassword123");
    }

    @And("I click the {string} button")
    public void andClickButton(String s) {
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
        driver.findElement(By.id(s+"Btn")).click();
    }

    @Then("a green confirmation text shows I registered succesfully")
    public void ConfirmRSignUp() {
        assertTrue(!driver.findElements(By.id("userCreatedSuccess")).isEmpty());
    }

    // Login add to cart and checkout steps
    @And("I fill the login form with my information")
    public void FillSignInForm() {
        driver.findElement(By.id("loginEmail")).sendKeys("user.teste@gmail.com");
        driver.findElement(By.id("loginPassword")).sendKeys("testingpassword123");
    }

    @Then("I am redirected to the page {string}")
    public void CheckIfRedirect(String url) {
        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }

        assertEquals(url, driver.getCurrentUrl());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
