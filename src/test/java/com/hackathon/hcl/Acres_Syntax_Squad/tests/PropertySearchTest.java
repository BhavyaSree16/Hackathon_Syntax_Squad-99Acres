package com.hackathon.hcl.Acres_Syntax_Squad.tests;

import org.testng.annotations.Test;

import com.hackathon.hcl.Acres_Syntax_Squad.basetest.BaseTest;
import com.hackathon.hcl.Acres_Syntax_Squad.pages.HomePage;

public class PropertySearchTest extends BaseTest {

    @Test
    public void testPropertySearchFlow() {

        HomePage homePage = new HomePage(driver);

        homePage
                .acceptCookies()
                .clickBuyOption()
                .enterLocation()
                .selectFirstSuggestion()
                .reopenSearchPanel()
                .openBedroomDropdown()
                .selectTwoBhk()
                .clickSearchButton();

        System.out.println("Property Search Flow Executed Successfully");
    }
}