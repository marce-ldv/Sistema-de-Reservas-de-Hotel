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
     *
     */
    public void datosLogin(String user,String pass){
        this.usuario="Admin";
        this.password="admin";
    }

    /**
     * Este metodo permite hacer la validacion del login
     * Recibe como argumentos la caja de texto del usuario en el Jframe y tambien de la password
     * JTextField y JPasswordField
     * @param usTextField
     * @param passField
     * @return
     */
    public boolean loguearse(JTextField usTextField,JPasswordField passField){
        LoginGUI loginGui = new LoginGUI();
        datosLogin(usuario,password);

        if((usuario.equals(usTextField)) && (password.equals(passField))){
            JOptionPane.showMessageDialog(null,"funciono");
            return true;
        }else {
            JOptionPane.showMessageDialog(null,"No funciono");
            return false;
        }
    }
}
