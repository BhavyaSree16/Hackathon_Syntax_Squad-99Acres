package com.hackathon.hcl.Acres_Syntax_Squad.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hackathon.hcl.Acres_Syntax_Squad.base.BasePage;

public class SearchResult extends BasePage {

    // Constructor
    public SearchResult(WebDriver driver) {
        super(driver);
    }

    // Open First Property
    public PropertyPage openFirstProperty() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        int attempts = 0;

        while (attempts < 3) {

            try {

                // Freshly locate element every retry
                WebElement firstProperty =
                        driver.findElement(
                                By.xpath("(//div[contains(@class,'PseudoTupleRevamp__contentWrapAb')]//a[@title])[1]")
                        );

                // Click Property
                firstProperty.click();

                break;

            } catch (StaleElementReferenceException e) {

                attempts++;

                System.out.println("Retrying due to stale element...");
            }
        }

        // Switch To New Tab
        ArrayList<String> tabs =
                new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        return new PropertyPage(driver);
    }
}