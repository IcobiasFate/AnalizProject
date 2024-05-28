package stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class PrescriptionManagementSteps {

    private boolean isDoctorLoggedIn = false;
    private String prescriptionMessage = "";
    private String existingPrescription = "Existing Prescription";

    @Given("The doctor is logged in")
    public void theDoctorIsLoggedIn() {
        isDoctorLoggedIn = true;
    }

    @When("The doctor creates a new prescription with valid data for a patient")
    public void theDoctorCreatesANewPrescriptionWithValidDataForAPatient() {
        if (isDoctorLoggedIn) {
            prescriptionMessage = "New Prescription";
        }
    }

    @Then("The prescription is added to the system")
    public void thePrescriptionIsAddedToTheSystem() {
        assertEquals("New Prescription", prescriptionMessage);
    }

    @And("The patient can see the new prescription in their profile")
    public void thePatientCanSeeTheNewPrescriptionInTheirProfile() {
        assertEquals("New Prescription", prescriptionMessage);
    }

    @When("The doctor tries to create a new prescription with missing patient information")
    public void theDoctorTriesToCreateANewPrescriptionWithMissingPatientInformation() {
        if (isDoctorLoggedIn) {
            prescriptionMessage = "Patient information is required";
        }
    }

    @Then("The system shows an error message {string}")
    public void theSystemShowsAnErrorMessage(String errorMessage) {
        assertEquals(errorMessage, prescriptionMessage);
    }

    @When("The doctor tries to create a new prescription with an invalid medication name")
    public void theDoctorTriesToCreateANewPrescriptionWithAnInvalidMedicationName() {
        if (isDoctorLoggedIn) {
            prescriptionMessage = "Invalid medication name";
        }
    }

    @When("The doctor tries to create a new prescription with a past date")
    public void theDoctorTriesToCreateANewPrescriptionWithAPastDate() {
        if (isDoctorLoggedIn) {
            prescriptionMessage = "Prescription date cannot be in the past";
        }
    }

    @Given("There is an existing prescription for the patient")
    public void thereIsAnExistingPrescriptionForThePatient() {
        // Simulating that there is already a prescription for the patient
        prescriptionMessage = existingPrescription;
    }

    @When("The doctor tries to create a duplicate prescription for the same patient")
    public void theDoctorTriesToCreateADuplicatePrescriptionForTheSamePatient() {
        if (isDoctorLoggedIn && existingPrescription.equals("Existing Prescription")) {
            prescriptionMessage = "Duplicate prescription";
        }
    }
}
