package com.teste.selenium.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.teste.selenium.pages.JeansPage;

@SpringBootTest
@TestPropertySource("classpath:env.properties")
public class TestJeansPage {

    @Autowired // Spring inyecta JeansPage automáticamente
    private JeansPage jeansPage;

    private final String URL = "https://automationexercise.com/";

    @BeforeEach
    void setUp() {
        this.jeansPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() {
        this.jeansPage.quitWebDriver();
    }

    @Test
    void teste() {
        this.jeansPage.viewCasualJeansPage();
        String expectedUrl = "https://automationexercise.com/category_products/6";
        String currentURL = this.jeansPage.getCurrentUrl();
        assertEquals(expectedUrl, currentURL);
        String expectedViewCardText = "Your product has been added to cart.";
        String currentViewCardText = this.jeansPage.getviewCartLinkText();
        assertEquals(expectedViewCardText, currentViewCardText);

    }
}
