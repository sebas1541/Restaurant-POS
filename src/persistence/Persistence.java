package persistence;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Persistence {

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
}
