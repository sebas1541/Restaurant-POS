package model;

import java.util.HashMap;
import java.util.Map;

public class Auth {
    private Map<String, User> userList;

    public Auth() {
        userList = new HashMap<>();
    }


    public void addUser(User user) {
        userList.put(user.getUsername(), user);
    }


    public String authenticate(String username, String password) {
        User user = userList.get(username);
        String salida = null;

        if (user != null) {
            if (password != null && user.getPassword().equals(password)) {
                salida = "Se ha ingresado con éxito";
            } else {
                salida = "La contraseña es incorrecta";
            }
        } else {
            salida = "El nombre de usuario es incorrecto";
        }

        return salida;
    }


    public String getUserListString() {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            String username = entry.getKey();
            User user = entry.getValue();
            output.append("Username: ").append(username).append("\n").append(user.toString()).append("\n");
        }
        return output.toString();
    }

    public static void main(String[] args) {

        User user = new User("Hola", "hola1234", "password123", "cajero");
        Auth auth = new Auth();
        auth.addUser(user);

        System.out.println("User List:\n" + auth.getUserListString());

        System.out.println(auth.authenticate("hola1234", "password123"));
    }
}
