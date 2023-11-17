package persistence;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class Persistence {
    private ArrayList<String> datos;

    public Persistence() {
        datos = new ArrayList<>();
    }

    public JsonArray readIngredientsFile() {
        String filePath = "src/data/Ingredients.json";
        JsonArray ingredientsArray = null;

        try {
            InputStream fis = new FileInputStream(filePath);
            JsonReader reader = Json.createReader(fis);
            JsonObject jsonObject = reader.readObject();
            ingredientsArray = jsonObject.getJsonArray("ingredients");
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ingredientsArray;
    }

    public void crearPropertiesFile() {
        File archivo = new File("src/data/userPassword.properties");
        try {
            OutputStream os = new FileOutputStream(archivo);
            Properties prop = new Properties();
            prop.setProperty("usuario", "dogzilla");
            prop.setProperty("password", "1234");

            String usuario = prop.getProperty("usuario");
            String contraseña = prop.getProperty("password");
            datos.add(usuario);
            datos.add(contraseña);

            prop.store(os, "Archivo de configuraciones");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}