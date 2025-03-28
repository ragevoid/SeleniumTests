package com.teste.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    // Locators (Elementos de la pagina)

    private By emailLocator = By.cssSelector("input[data-qa='login-email']");

    private By passLocator = By.cssSelector("input[data-qa='login-password']");

    private By loginBtn = By.cssSelector("button[data-qa='login-button']");

    private By uernameTag = By.xpath("//a[contains(text(),'Logged in as')]");

    @Value("${SITE_USERNAME}")
    private String siteUsername;

    @Value("${SITE_PASS}")
    private String sitePass;

    // Funcion para hacer el Login
    public void logIn() {
        if (!super.isDisplayed(emailLocator)) {
            System.out.println("Email field is not enable");
        }
        super.type(siteUsername, emailLocator);
        super.type(sitePass, passLocator);
        super.click(loginBtn);

        super.waitForElement(uernameTag, 5);

    }

    // Funcion para obtener el nombre del elemento que indica que el usuario logo
    // correctamente
    public String getUsernameTagText() {
        WebElement usernameElement = super.waitForElement(uernameTag, 5);
        return usernameElement.getText();
    }

}
