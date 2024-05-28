package stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class MedicineSearchSteps {

    private String searchResult = "";
    private String searchTerm = "";
    private final String[] availableMedicines = {"Aspirin", "Aspirin Forte", "Aspirin Cardio"};
    private String selectedCategory = "";

    @Given("The patient is on the homepage")
    public void thePatientIsOnTheHomepage() {
        // Simulate patient on homepage
    }

    @When("The patient enters {string} in the search box")
    public void thePatientEntersInTheSearchBox(String medicine) {
        searchTerm = medicine;
        searchResult = "";
        for (String med : availableMedicines) {
            if (med.toLowerCase().contains(medicine.toLowerCase())) {
                searchResult += med + " ";
            }
        }
        searchResult = searchResult.trim();
    }

    @When("The patient selects the {string} category")
    public void thePatientSelectsTheCategory(String category) {
        selectedCategory = category;
    }

    @And("clicks the {string} button")
    public void clicksTheButton(String button) {
        // Simulate button click, the search logic is handled in the previous steps
    }

    @Then("The system shows all available medicines containing {string} in the name")
    public void theSystemShowsAllAvailableMedicines(String medicine) {
        if (medicine.isEmpty()) {
            assertTrue(searchResult.isEmpty());
        } else {
            for (String med : availableMedicines) {
                if (med.toLowerCase().contains(medicine.toLowerCase())) {
                    assertTrue(searchResult.contains(med));
                }
            }
        }
    }

    @Then("The system shows no available medicines containing {string} in the name")
    public void theSystemShowsNoAvailableMedicinesContainingInTheName(String medicine) {
        if (searchTerm.isEmpty()) {
            assertTrue(searchResult.isEmpty());
        } else {
            assertFalse(searchResult.contains(medicine));
        }
    }

    @Then("The system shows all available medicines in the {string} category")
    public void theSystemShowsAllAvailableMedicinesInTheCategory(String category) {
        for (String med : availableMedicines) {
            // Simulate filtering by category
            if (med.toLowerCase().contains(selectedCategory.toLowerCase())) {
                assertTrue(searchResult.contains(med));
            }
        }
    }
}
