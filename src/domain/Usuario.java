package domain;

import swing.AdministradorGUI;
import swing.LoginGUI;

import javax.swing.*;

public class Usuario{

    private String usuario,password;
    private Integer idUsuario;

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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * Este metodo permite hacer la validacion del login
     * Recibe como argumentos las cadenas de texto del usuario y contraseña
     */
    public boolean loguearse(String user,String pass){

        if((usuario.equals(user)) && (password.equals(pass))){
            return true;
        }else if((usuario.equals("")) && (password.equals(""))){
            JOptionPane.showMessageDialog(null,"Debe completar todos los campos");
            return false;
        }else if((usuario.equals(""))){
            JOptionPane.showMessageDialog(null,"El campo usuario esta vacio");
            return false;
        }else if((password.equals(""))){
            JOptionPane.showMessageDialog(null,"El campo password esta vacio");
            return false;
        }else if((usuario.compareTo(user) != 0) && (password.compareTo(pass) != 0)){
            JOptionPane.showMessageDialog(null,"Usuario o contrasenia incorrectos");
            return false;
        }else{
            return false;
        }
    }
}
