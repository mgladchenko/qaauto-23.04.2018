package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchResults;

import java.util.List;

public class LinkedinSearchTest extends LinkedinBaseTest{

    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";

        LinkedinHomePage linkedinHomePage =
                linkedinLoginPage.login("iteatest@i.ua", "1q2w3e_4r5t");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not loaded.");

        LinkedinSearchResults linkedinSearchResults = linkedinHomePage.search(searchTerm);
        Assert.assertTrue(linkedinSearchResults.isPageLoaded(),
                "SearchResults Page is not loaded.");

        List<String> searchResultsList = linkedinSearchResults.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 10,
                "Count of search result items is wrong.");

        for (String searchResult:searchResultsList) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "Searchterm "+searchTerm+" was not found in: \n"+searchResult);
        }


    }

}
