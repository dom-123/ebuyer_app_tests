package com.ebuyer.domain;

import com.ebuyer.pages.HomePage;
import com.ebuyer.pages.SearchPage;

import static org.junit.Assert.assertEquals;

public class SearchDomain {

    SearchPage searchPage = new SearchPage();
    HomePage homePage = new HomePage();

    public SearchDomain searchForAProduct ( String product ) {

        homePage.acceptCookiePreferences();
        searchPage.enterProductSearchBox(product)
                .clickProductSearchButton();
        return this;
    }

    public void verifyQuickFind () {
        String expected = "QuickFind: 384008";
        assertEquals(expected, searchPage.getQuickFindText());
        System.out.println(searchPage.getQuickFindText());
    }
}