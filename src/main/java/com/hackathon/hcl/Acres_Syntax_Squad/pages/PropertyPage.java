package com.hackathon.hcl.Acres_Syntax_Squad.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hackathon.hcl.Acres_Syntax_Squad.base.BasePage;

public class PropertyPage extends BasePage {

    // Constructor
    public PropertyPage(WebDriver driver) {
        super(driver);
    }

    // Handle Popup
    public PropertyPage handlePopup() {

        try {

            WebElement popupButton =
                    driver.findElement(
                            By.xpath("//span[text()='OK, Got it']")
                    );

            popupButton.click();

        } catch (Exception e) {

            System.out.println("Popup not displayed");
        }

        return this;
    }

    // Get Property Name
    public String getPropertyName() {

        return driver.findElement(
                By.xpath("//div[@id='project-details']//h1")
        ).getText();
    }

    // Get Property Location
    public String getPropertyLocation() {

        return driver.findElement(
                By.xpath("//span[contains(@class,'ProjectInfo__imgBox1SubTxt')]")
        ).getText();
    }
    
 // Get Property Page Title
    public String getPropertyPageTitle() {

        return getPageTitle();
    }
}