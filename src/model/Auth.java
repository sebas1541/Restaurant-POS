package model;

import javax.naming.AuthenticationException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Auth {
    private Map<String, User> userList;
    public Auth(){
        userList = new HashMap<>();
    }
    private void addUser(User user){
        userList.put(user.getUsername(), user);
    }

   public String authenticate(String username, String password){
        User user = userList.get(username);
        String salida="";
        if (username != null && user != null){
            if (user.getUsername().equals(username)){
                if (password != null){
                    if (user.getPassword().equals(password)){
                        salida = "se ha ingresado con exito";
                    }else {
                        salida = "La contrasena es incorrecta";
                    }
                } else {
                    salida = "La contrasena no puede estar en blanco";}
            } else {
            salida = "El nombre de usuario es icorrecto";}
        } else {
            salida = "El nombre de usuario no puede estar en blanco";
        }

        return salida;

   }

    public String myGetStringListStudents() {
        StringBuilder output=new StringBuilder();
        for (Map.Entry<String, User> entry : userList.entrySet()) {
            String key = entry.getKey();
            User val = entry.getValue();
            output.append("").append(key.toString()).append("User: \n").append(val.toString()).append("\n");
        }
        return output.toString();
    }

    public static void main(String[] args) {
        User user = new User("Hola", "hola1234", "password123", "cajero");
        Auth auth = new Auth();
        auth.addUser(user);
        auth.myGetStringListStudents();
        System.out.println("Datos del usuario: \n"+auth.myGetStringListStudents());


        System.out.println(auth.authenticate("hola1234", "password123"));

    }
}
