package com.hackathon.hcl.Acres_Syntax_Squad.tests;

import org.testng.annotations.Test;

import com.hackathon.hcl.Acres_Syntax_Squad.basetest.BaseTest;
import com.hackathon.hcl.Acres_Syntax_Squad.pages.HomePage;
import com.hackathon.hcl.Acres_Syntax_Squad.pages.PropertyPage;
import com.hackathon.hcl.Acres_Syntax_Squad.pages.SearchResult;

public class PropertySearchTest extends BaseTest {

    @Test
    public void testPropertySearchFlow() {

        HomePage homePage = new HomePage(driver);

        // Homepage → Search Result Page
        SearchResult searchResultPage =
                homePage
                    .acceptCookies()
                    .clickBuyOption()
                    .enterLocation()
                    .selectFirstSuggestion()
                    .reopenSearchPanel()
                    .openBedroomDropdown()
                    .selectTwoBhk()
                    .clickSearchButton();

        // Search Result → Property Page
        PropertyPage propertyPage =
                searchResultPage.openFirstProperty();

        // Handle Popup
        propertyPage.handlePopup();

        // Fetch Property Details
        String propertyName =
                propertyPage.getPropertyName();

        String propertyLocation =
                propertyPage.getPropertyLocation();
        
        String pageTitle =
                propertyPage.getPropertyPageTitle();

        // Print Details
        System.out.println("Page Title : " + pageTitle);
        System.out.println("Property Name : " + propertyName);
        System.out.println("Property Location : " + propertyLocation);

        System.out.println("Property Search Flow Executed Successfully");
    }
}