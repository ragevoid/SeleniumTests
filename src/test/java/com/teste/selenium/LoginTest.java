package com.teste.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;;;

public class LoginTest {

    private WebDriver driver;

    @Value("${SITE_USERNAME}")
    public String siteUsername;

    @Value("${SITE_PASS}")
    public String sitePass;

    @BeforeEach
    void setUp() throws Exception {
        System.getProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

    }

    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    void teste() {
        WebElement header = driver.findElement(By.id("header"));
        boolean headerFlag = header.isDisplayed();

        System.out.println("Header element is displayed: " + headerFlag);

        driver.get("https://automationexercise.com/login");
        WebElement headerImg = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
        boolean headerImgFlag = headerImg.isDisplayed();

        System.out.println("Header element is displayed: " + headerImgFlag);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        emailField.sendKeys(siteUsername);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        passwordField.sendKeys(sitePass);

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        loginBtn.click();

        WebElement tagUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String tagUsernameText = tagUsername.getText();

        String tagExpected = "Logged in as Ricardo";
        System.out.println("Username Text is: " + tagUsernameText);

        assertEquals(tagExpected, tagUsernameText);

    }

}
