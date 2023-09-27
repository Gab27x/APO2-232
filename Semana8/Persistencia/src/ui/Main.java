package ui;

import model.FileManager;
import model.Person;
import model.PersonList;
import model.Pet;

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

    public static void main(String[] args)  {
        Main m = new Main();

        // ruta absoluta --> /home/i2t/Git/icesi/APO2-232/Semana8/Persistencia
        // ruta absoluta --> C:\\user\\i2t\\Documents\\icesi\\APO2-232\\Semana8\\Persistencia

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

        p1.setPet(new Pet("pet2", 20));
        p2.setPet(new Pet("pet3", 30));
        p3.setPet(new Pet("pet4", 40));
        p4.setPet(new Pet("pet5", 50));
        p5.setPet(new Pet("pet6", 60));
        p6.setPet(new Pet("pet7", 70));
        p7.setPet(new Pet("pet8", 80));

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


        System.out.println("Ejemplo Json");
        try {
            m.listToSave.saveToJson();
        } catch (IOException e) {
           e.printStackTrace();
        }

        try {
            System.out.println("información del content: ");
            m.listToLoad.loadFromJson();
        } catch (IOException e) {
           e.printStackTrace();
        }

        System.out.println("peole from list to load ");
        System.out.println(m.listToLoad.print());


        m.listToSave.listDirs();


        FileManager fileManager = FileManager.getInstance();
        try {
            fileManager.saveToJson(m.listToSave.getPeople());
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
