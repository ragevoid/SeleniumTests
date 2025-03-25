package com.teste.selenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

@SpringBootTest
class SeleniumApplicationTests {

	private WebDriver driver;

	@Test
	void epaSelenium() {
		System.getProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");

		String currentUrl = driver.getCurrentUrl();
		String expected = "https://automationexercise.com/";

		assertEquals(expected, currentUrl);

		driver.quit();
	}

	@Test
	void shouldAnswerTrue() {
		assertTrue(true);
	}
}
