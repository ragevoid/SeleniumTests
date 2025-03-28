package com.teste.selenium.testes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.teste.selenium.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

@SpringBootTest
@TestPropertySource("classpath:env.properties")
public class TestLoginPage {

    @Autowired // Spring inyecta LoginPage automáticamente
    private LoginPage loginPage;

    private final String URL = "https://automationexercise.com/login";

    @BeforeEach
    void setUp() {
        this.loginPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() {
        this.loginPage.quitWebDriver();
    }

    @Test
    void teste() {
        this.loginPage.logIn();
        String tagExpected = "Logged in as Ricardo";
        assertEquals(tagExpected, this.loginPage.getUsernameTagText());
    }
}
