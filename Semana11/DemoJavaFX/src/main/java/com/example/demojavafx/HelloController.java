package com.example.demojavafx;

import com.example.demojavafx.control.UserController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {

    private UserController userController;

    public HelloController() {
        userController = new UserController();
    }

    @FXML
    private Label welcomeText;

    @FXML
    private TextArea inputInfoTextArea;

    @FXML
    protected void onAddUser() {

        String inputData = inputInfoTextArea.getText();
        String[] partialData = inputData.split(",");
        userController.addUser(partialData[0], partialData[1], Integer.parseInt(partialData[2]));
        welcomeText.setText(userController.printUsers());
    }
}