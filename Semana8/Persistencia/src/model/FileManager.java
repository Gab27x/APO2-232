package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static FileManager instance;

    private File dataFolder;
    private File result;
    private File jsonFile;

    private FileManager(){
        // la ruta absoluta del proyecto
        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir+"/data");
        result = new File(dataFolder+"/result.csv");
        jsonFile = new File(dataFolder+"/people.json");
    }

    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
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

    public void saveToJson(ArrayList<Person> people) throws IOException {
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


}
