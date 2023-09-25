package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.plaf.SpinnerUI;

public class PersonList {

    private ArrayList<Person> people;
    private File dataFolder;
    private File result;

    private File jsonFile;

    public PersonList() {
        people = new ArrayList<>();
        // la ruta absoluta del proyecto
        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir+"/data");
        result = new File(dataFolder+"/result.csv");
        jsonFile = new File(dataFolder+"/people.json");
    }

    private void createResources() throws IOException {
        if(!dataFolder.exists()){
            dataFolder.mkdir();
            if(!result.exists()){
                result.createNewFile();
            }
            if (!jsonFile.exists()){
                jsonFile.createNewFile();
            }
        }
    }

    public void save() throws IOException {
        createResources();

        // result --> funte de la información (archivo)
        // FileOutputStream --> Enlazador de la información --> conectar el lenguaje (java) con la fuente de la información
        FileOutputStream fos = new FileOutputStream(result); // FileNotFountException

        // fuente de la información
        // Definir el formato con el que se guarda la información
        String data = "";
        for (int i = 0; i < people.size(); i++) {
            data = people.get(i).getName() + "," + people.get(i).getId() + "," + people.get(i).getYears() + "\n";
        }
        // OutputStreamWriter --> empaquetador de la información --> preparar el recurso donde queremos escribir
        // BufferedWriter --> escritor de la información
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data); // IOException
        writer.flush();
        writer.close();
    }

    public void load() throws IOException {
        FileInputStream fis = new FileInputStream(result);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String content = "";
        String line = "";
        while ( (line = reader.readLine()) != null){
           content = line;
           String[] arr = content.split(",");
           people.add(new Person(arr[0], arr[1], Integer.parseInt(arr[2])));
        }
        reader.close();
    }

    public void saveToJson() throws IOException {
        // crear los recursos --> archivos y carpetas
        createResources();

        // Serializador de la información --> https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1
        Gson gson = new Gson();

        // result --> funte de la información (archivo)
        // FileOutputStream --> Enlazador de la información --> conectar el lenguaje (java) con la fuente de la información
        FileOutputStream fos = new FileOutputStream(jsonFile); // FileNotFountException

        // fuente de la información
        // Definir el formato con el que se guarda la información
        String data = gson.toJson(people);

        // OutputStreamWriter --> empaquetador de la información --> preparar el recurso donde queremos escribir
        // BufferedWriter --> escritor de la información
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data); // IOException
        writer.flush();
        writer.close();
    }

    public void loadFromJson() throws IOException {
        Gson gson = new Gson();
        FileInputStream fis = new FileInputStream(jsonFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String content = "";
        String line = "";
        while ( (line = reader.readLine()) != null){
            content += line;
        }
        reader.close();

        Person[] persons = gson.fromJson(content, Person[].class);
        people = gson.fromJson(content, people.getClass());
        // people = Arrays.asList(persons);

    }

    public void listDirs(){
        File[] files = dataFolder.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
            // retorna un objeto file identico a dataFolder
            System.out.println(files[i].getParentFile().getName());
            // retorna un string con la ruta absoluta de la carpeta que lo contiene
            System.out.println(files[i].getParent());

        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public String print(){
        String msj = "";
        for (Person p: people) {
           msj += p + ", ";
        }
        return msj;
    }
}
