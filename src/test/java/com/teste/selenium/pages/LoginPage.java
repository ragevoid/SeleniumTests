package com.teste.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @TestPropertySource("classpath:env.properties")
@Component
public class LoginPage extends BasePage {

    // Locators (Elementos de la pagina)

    // <input type="email" data-qa="login-email" placeholder="Email Address"
    // name="email" value="" required="">
    private By emailLocator = By.cssSelector("input[data-qa='login-email']");

    // <input type="password" data-qa="login-password" placeholder="Password"
    // name="password" value="" required="">
    private By passLocator = By.cssSelector("input[data-qa='login-password']");

    // <button type="submit" data-qa="login-button" class="btn
    // btn-default">Login</button>

    private By loginBtn = By.cssSelector("button[data-qa='login-button']");

    // <a><i class="fa fa-user"></i> Logged in as <b>Ricardo</b></a>
    private By uernameTag = By.xpath("//a[contains(text(),'Logged in as')]");
    // private By uernameTag = By.className("fa-user");
    // Credenciales para acesso al sitio web, utilizando env.properties

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
