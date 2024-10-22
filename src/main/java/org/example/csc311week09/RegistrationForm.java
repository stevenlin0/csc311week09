package org.example.csc311week09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The form has fields for first name, last name, email, date of birth, and zip code.
 * It checks if the input is valid and the "add" button is only enabled
 * when all fields have the correct input.
 */

public class RegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {

        // This creates text fields with the prompt text thing
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField dobField = new TextField();
        dobField.setPromptText("Date of Birth (MM/DD/YYYY)");

        TextField zipField = new TextField();
        zipField.setPromptText("Zip Code");

        // This creates the add button and keep it disabled at first
        Button addButton = new Button("Add");
        addButton.setDisable(true);

        // This checks the input when the person clicks away from a field
        firstNameField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateFirstName(firstNameField);
        });
        lastNameField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateLastName(lastNameField);
        });
        emailField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateEmail(emailField);
        });
        dobField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateDOB(dobField);
        });
        zipField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateZip(zipField);
        });

        // This enables and disables the add button depending on if the fields are valid
        firstNameField.textProperty().addListener((obs, oldVal, newVal) -> checkValidForm(addButton, firstNameField, lastNameField, emailField, dobField, zipField));
        lastNameField.textProperty().addListener((obs, oldVal, newVal) -> checkValidForm(addButton, firstNameField, lastNameField, emailField, dobField, zipField));
        emailField.textProperty().addListener((obs, oldVal, newVal) -> checkValidForm(addButton, firstNameField, lastNameField, emailField, dobField, zipField));
        dobField.textProperty().addListener((obs, oldVal, newVal) -> checkValidForm(addButton, firstNameField, lastNameField, emailField, dobField, zipField));
        zipField.textProperty().addListener((obs, oldVal, newVal) -> checkValidForm(addButton, firstNameField, lastNameField, emailField, dobField, zipField));

        // This shows what happens when the add button is clicked
        addButton.setOnAction(e -> navigateToNextPage());

        // This is to create the layout and scene
        VBox layout = new VBox(10, firstNameField, lastNameField, emailField, dobField, zipField, addButton);
        Scene scene = new Scene(layout, 300, 250);

        // This is to set up the stage
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This checks if the first name is valid.
     * The first name can only have letters and needs to be 2 to 25 characters long.
     *
     * @param firstNameField The TextField takes the person's first name.
     */
    private void validateFirstName(TextField firstNameField) {
        String regex = "^[a-zA-Z]{2,25}$";
        if (!firstNameField.getText().matches(regex)) {
            firstNameField.setStyle("-fx-border-color: red;");
        } else {
            firstNameField.setStyle("");
        }
    }

    /**
     * This checks if the last name is valid.
     * The last name can only have letters and needs to be 2 to 25 characters long.
     *
     * @param lastNameField The TextField takes the person's last name.
     */
    private void validateLastName(TextField lastNameField) {
        String regex = "^[a-zA-Z]{2,25}$";
        if (!lastNameField.getText().matches(regex)) {
            lastNameField.setStyle("-fx-border-color: red;");
        } else {
            lastNameField.setStyle("");
        }
    }

    /**
     * This checks if the email is valid.
     * The email can only have the farmingdale emails like the format.
     *
     * @param emailField The TextField takes the person's email.
     */
    private void validateEmail(TextField emailField) {
        String regex = "^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$";
        if (!emailField.getText().matches(regex)) {
            emailField.setStyle("-fx-border-color: red;");
        } else {
            emailField.setStyle("");
        }
    }

    /**
     * This checks if the date of birth is valid.
     * The date of birth has to be like this format mm/dd/yyyy.
     *
     * @param dobField The TextField takes the person's date of birth.
     */
    private void validateDOB(TextField dobField) {
        String regex = "^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$";
        if (!dobField.getText().matches(regex)) {
            dobField.setStyle("-fx-border-color: red;");
        } else {
            dobField.setStyle("");
        }
    }

    /**
     * This checks if the zip code is valid.
     * The zip code has to have a five digits number.
     *
     * @param zipField The TextField takes the person's zip code.
     */
    private void validateZip(TextField zipField) {
        String regex = "^\\d{5}$";
        if (!zipField.getText().matches(regex)) {
            zipField.setStyle("-fx-border-color: red;");
        } else {
            zipField.setStyle("");
        }
    }

    /**
     * This checks if all the fields are valid and enables or disables the add button.
     * The add button is only enabled when all fields are correct.
     *
     * @param addButton The add button to enable and disable.
     * @param fields The fields to check.
     */
    private void checkValidForm(Button addButton, TextField... fields) {
        for (TextField field : fields) {
            if (field.getStyle().contains("red") || field.getText().isEmpty()) {
                addButton.setDisable(true);
                return;
            }
        }
        addButton.setDisable(false);
    }

    /**
     * This runs when the add button is clicked and the form is valid.
     * It shows a message saying you're going to the next page.
     * This method doesn't return anything.
     *
     * @return void
     */
    private void navigateToNextPage() {
        System.out.println("Navigating to the next page...");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
