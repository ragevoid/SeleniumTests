package com.teste.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class JeansPage extends BasePage {
    // Locators

    private By menCategoryMenuLocator = By.cssSelector("#accordian > div:nth-child(2) > div.panel-heading > h4 > a");

    private By jeansMenuLocator = By.cssSelector("#Men > div > ul > li:nth-child(2) > a");

    private By firstProductCard = By.cssSelector(
            "body > section > div > div.row > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products");

    private By addToCardButton = By.cssSelector(
            "body > section > div > div.row > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products > div.product-overlay > div > a");

    private By addedToCartMessage = By.cssSelector(
            "#cartModal > div > div > div.modal-body > p:nth-child(1)");

    public void viewCasualJeansPage() {
        if (!super.isDisplayed(menCategoryMenuLocator)) {
            System.out.println("menCategoryMenuLocator isn't displayed");
        }
        super.click(menCategoryMenuLocator);
        super.waitForElement(jeansMenuLocator, 5);
        super.click(jeansMenuLocator);

        if (!super.isDisplayed(firstProductCard)) {
            System.out.println("menu dresses was not found");
        }

        super.actionMoveToElementPerform(firstProductCard);
        super.actionMoveToElementClickPerform(addToCardButton);

        super.waitForElement(addedToCartMessage, 5);

    }

    public String getviewCartLinkText() {
        WebElement viewCartLinkText = super.waitForElement(addedToCartMessage, 5);
        return viewCartLinkText.getText();
    }

}
