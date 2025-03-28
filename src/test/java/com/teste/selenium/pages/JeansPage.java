package com.teste.selenium.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class JeansPage extends BasePage {
    // Locators

    private By menCategoryMenuLocator = By.cssSelector("#accordian > div:nth-child(2) > div.panel-heading > h4 > a");

    private By jeansMenuLocator = By.cssSelector("#Men > div > ul > li:nth-child(2) > a");

    public void viewCasualJeansPage() {
        if (!super.isDisplayed(menCategoryMenuLocator)) {
            System.out.println("menCategoryMenuLocator isn't displayed");
        }
        super.click(menCategoryMenuLocator);
        super.waitForElement(jeansMenuLocator, 5);
        super.click(jeansMenuLocator);
    }

}
