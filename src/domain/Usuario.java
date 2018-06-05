package domain;

import swing.AdministradorGUI;
import swing.LoginGUI;

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

    public boolean loguearse(){
        LoginGUI loginGui = new LoginGUI();
        datosLogin(usuario,password);
        if((usuario.equals(loginGui.getTextFieldUsername())) && (password.equals(loginGui.getPasswordField()))){
            return true;
        }
        return false;
    }
}
