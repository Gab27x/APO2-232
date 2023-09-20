package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private List<Person> people;
    private File dataFolder;
    private File result;

    public PersonList() {
        people = new ArrayList<>();
        // la ruta absoluta del proyecto
        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir+"/data");
        result = new File(dataFolder+"/result.csv");
    }

    private void createResources() throws IOException {
        if(!dataFolder.exists()){
            dataFolder.mkdir();
            if(!result.exists()){
                result.createNewFile();
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
            data += people.get(i).getName() + "," + people.get(i).getId() + "," + people.get(i).getYears() + "\n";
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
