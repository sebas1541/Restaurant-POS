package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistence {

    public String readIngredientsFile() {
        String ruta = "src/data/Ingredients.txt";
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
