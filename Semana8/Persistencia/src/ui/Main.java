package ui;

import model.Person;
import model.PersonList;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private PersonList listToSave;
    private PersonList listToLoad;

    public Main() {
        listToSave = new PersonList();
        listToLoad = new PersonList();
    }

    public static void main(String[] args) {
        Main m = new Main();

        // ruta absoluta --> /home/i2t/Git/icesi/APO2-232/Semana8/Persistencia
        // ruta relativa --> ./Persistencia

        // Formas de las rutas absolutas:
        // Win --> C:\Users\i2t\Desktop
        // Unix --> /home/i2t/Desktop
        // Linux --> /home/i2t/Desktop

        Person p1 = new Person("name1", "123", 10);
        Person p2 = new Person("name2", "123", 20);
        Person p3 = new Person("name3", "123", 30);
        Person p4 = new Person("name4", "123", 40);
        Person p5 = new Person("name5", "123", 50);
        Person p6 = new Person("name6", "123", 60);
        Person p7 = new Person("name7", "123", 70);

        m.listToSave.getPeople().add(p1);
        m.listToSave.getPeople().add(p2);
        m.listToSave.getPeople().add(p3);
        m.listToSave.getPeople().add(p4);
        m.listToSave.getPeople().add(p5);
        m.listToSave.getPeople().add(p6);
        m.listToSave.getPeople().add(p7);

        System.out.println(m.listToSave.print());

        try {
            m.listToSave.save();
        } catch (IOException e) {
           e.printStackTrace();
        }

        System.out.println("Lista vacia");
        System.out.println(m.listToLoad.print());

        try {
            m.listToLoad.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Lista cargada");
        System.out.println(m.listToLoad.print());
    }
}
