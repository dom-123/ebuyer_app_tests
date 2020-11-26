package com.ebuyer.steps;

import com.ebuyer.domain.SearchDomain;
import com.ebuyer.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class SearchStep {

    HomePage homePage = new HomePage();
    SearchDomain searchDomain = new SearchDomain();

    @Given("I am on ebuyer home page")
    public void iAmOnEbuyerHomePage () throws IOException {
        homePage.visit();
    }

    @When("I enter a product {string} into search field and click search")
    public void iEnterAProductAndClickSearch ( String product ) {
        searchDomain.searchForAProduct(product);
    }

    @Then("quick find number is displayed")
    public void quickFindNumberIsDisplayed () {
        searchDomain.verifyQuickFind();
    }
}