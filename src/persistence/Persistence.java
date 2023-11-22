package persistence;

import model.Ingredient;
import model.Inventory;

import javax.json.*;
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
    public void writeIngredientsFile(ArrayList<Ingredient> ingredient) {
        JsonObjectBuilder objcontructor = Json.createObjectBuilder();
        JsonArrayBuilder arrayJson = Json.createArrayBuilder();
        for (int i = 0; i < ingredient.size(); i++) {
            for (Ingredient ingr : ingredient) {
                JsonObjectBuilder bob = Json.createObjectBuilder()
                        .add("Ingrediente", ingr.getName())
                        .add("Cantidad", ingr.getQuantity());
                arrayJson.add(bob);
            }
            objcontructor.add("Ingredients", arrayJson);
        }
        JsonObject rutJsonObject = objcontructor.build();

        try (FileWriter writer = new FileWriter("src/data/Ingredients.json", true)) {
            JsonWriter jsonWriter = Json.createWriter(writer);
            jsonWriter.writeObject(rutJsonObject);
            jsonWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void writeInvoiceToFile(String T) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/invoice.txt"));
            writer.write(T);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }
}