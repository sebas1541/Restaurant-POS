package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Auth para la autenticación de usuarios.
 * Gestiona una lista de usuarios y proporciona métodos para agregar usuarios y autenticar.
 */
public class Auth {
    private Map<String, User> userList; // Mapa para almacenar usuarios con su nombre de usuario como clave.

    /**
     * Constructor que inicializa la lista de usuarios.
     */
    public Auth() {
        userList = new HashMap<>();
    }

    /**
     * Agrega un nuevo usuario a la lista de usuarios.
     *
     * @param user El usuario a agregar.
     */
    public void addUser(User user) {
        userList.put(user.getUsername(), user);
    }

    /**
     * Autentica a un usuario basado en su nombre de usuario y contraseña.
     *
     * @param username El nombre de usuario del usuario a autenticar.
     * @param password La contraseña del usuario.
     * @return Un mensaje indicando si la autenticación fue exitosa o no.
     */
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

    /**
     * Genera y devuelve una cadena de texto que representa la lista de usuarios.
     *
     * @return Una cadena de texto con los nombres de usuario y la información de los usuarios.
     */
    public String getUserListString() {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            String username = entry.getKey();
            User user = entry.getValue();
            output.append("Username: ").append(username).append("\n").append(user.toString()).append("\n");
        }
        return output.toString();
    }

}
