package com.hackathon.hcl.Acres_Syntax_Squad.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hackathon.hcl.Acres_Syntax_Squad.base.BasePage;

public class SearchResult extends BasePage {

    // Constructor
    public SearchResult(WebDriver driver) {
        super(driver);
    }

    // Open First Property
    public PropertyPage openFirstProperty() {

        int attempts = 0;
        int maxAttempts = 3;

        boolean isClicked = false;

        while (attempts < maxAttempts) {

            try {

                // Freshly locate property each retry
                WebElement firstProperty =
                        driver.findElement(
                                By.xpath("(//div[contains(@class,'PseudoTupleRevamp__contentWrapAb')]//a[@title])[1]")
                        );

                // Click Property
                firstProperty.click();

                isClicked = true;

                break;

            } catch (StaleElementReferenceException e) {

                attempts++;

                System.out.println("Retrying due to stale element...");
            }
        }

        // If click failed after retries
        if (!isClicked) {

            throw new RuntimeException(
                    "Unable to click first property after retries"
            );
        }

        // Switch To New Tab
        ArrayList<String> tabs =
                new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        return new PropertyPage(driver);
    }
}