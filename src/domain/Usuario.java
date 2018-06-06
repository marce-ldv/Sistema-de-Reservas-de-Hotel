package domain;

import exepciones.CampoVacioException;
import exepciones.InicioSesionException;
import exepciones.InvalidUsernameAndPasswordException;
import exepciones.InvalidUsernameException;
import files.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Usuario {

    private String usuario, password;
    private Integer idUsuario;

    public Usuario() {
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
    /*
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
    */
    public void registrarUsuario() throws JSONException {
        JsonUtiles jsonUt = new JsonUtiles();
        JSONObject objetoJSON = new JSONObject();
        JSONArray arregloJSON = new JSONArray();
        String tipoAdmin = "registroAdmin";
        String tipoEstandar = "registroEstandar";

        for(int i = 0; i < 5; i++){
            arregloJSON.put(objetoJSON);
        }

        jsonUt.grabar(arregloJSON,tipoAdmin);
    }

    public void leerDatosUsuario() throws JSONException{
        JsonUtiles jsonUt = new JsonUtiles();
        String tipoAdmin = "registroAdmin";
        String tipoEstandar = "registroEstandar";
        jsonUt.leer(tipoAdmin);
    }

    public boolean loguearse(String user, String pass) throws InvalidUsernameAndPasswordException, InvalidUsernameException, CampoVacioException, InicioSesionException {

        if ((usuario.equals(user)) && (password.equals(pass))) {
            return true;
        } else {
            if ((usuario.equals("")) || (password.equals(""))) {
                throw new CampoVacioException("");
            } else {
                throw new InvalidUsernameAndPasswordException(user);
            }
        }
    }
}
