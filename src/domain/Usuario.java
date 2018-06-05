package domain;

import swing.AdministradorGUI;
import swing.LoginGUI;

import javax.swing.*;

public class Usuario{

    private String usuario,password;

    public Usuario(){
        usuario = "Admin";
        password = "admin";
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Este metodo permite hacer la validacion del login
     * Recibe como argumentos las cadenas de texto del usuario y contraseña
     */
    public boolean loguearse(String user,String pass){

        if((usuario.equals(user)) && (password.equals(pass))){
            return true;
        }else {
            return false;
        }
    }
}
