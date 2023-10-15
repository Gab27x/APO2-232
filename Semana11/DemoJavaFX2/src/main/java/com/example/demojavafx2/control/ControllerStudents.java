package com.example.demojavafx2.control;

import com.example.demojavafx2.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;

public class ControllerStudents {

    private static ControllerStudents instance;

    public static ControllerStudents getInstance(){
        if(instance == null){
            instance = new ControllerStudents();
        }
        return instance;
    }

    private ObservableList<Student> students;

    private ControllerStudents() {
        students = FXCollections.observableArrayList();
    }

    public void addStudent(String name, String id, int age){
        Student student = new Student(name, id, age);
        students.add(student);
    }

    public String printStudents(){
        String msj = "";
        for (Student st: students) {
           msj += st + "\n";
        }
        return msj;
    }

    public ObservableList<Student> getStudents(){
        return students;
    }
}
