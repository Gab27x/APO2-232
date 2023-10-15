package com.example.demojavafx2.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.InputMismatchException;

public class FormAddStudentController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField ageTextField;

    @FXML
    private Button addStudentBtn;

    public void onAddStudent(ActionEvent event) {
        String name = nameTextField.getText();
        String id = idTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());

        ControllerStudents.getInstance().addStudent(name, id, age);

        Stage stage = (Stage) addStudentBtn.getScene().getWindow();
        stage.close();



    }
}
