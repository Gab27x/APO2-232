package com.example.demojavafx2.control;

import com.example.demojavafx2.HelloApplication;
import com.example.demojavafx2.control.ControllerStudents;
import com.example.demojavafx2.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    private ControllerStudents controllerStudents;

    @FXML
    private TableView<Student> studentsTableView;

    @FXML
    private TableColumn<Student, String> nameTC;
    @FXML
    private TableColumn<Student, String> idTC;
    @FXML
    private TableColumn<Student, Integer> ageTC;

    @FXML
    private Button addStudentBtn;

    @FXML
    protected void onAddStudent() {
        HelloApplication.openWindow("form-add-student.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));

        studentsTableView.setItems(ControllerStudents.getInstance().getStudents());


    }
}