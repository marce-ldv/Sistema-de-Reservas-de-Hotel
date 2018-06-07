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
     * Recibe los datos de un usario que se registro en el JFrame RegistrarPAsajeroGUI, esa informacion la conviene en un
     * objeto JSON y la retorna
     * @param nombre
     * @param apellido
     * @param username
     * @param password
     * @param dni
     * @param telefono
     * @param nacionalidad
     * @return
     * @throws JSONException
     */
    public JSONObject registrarUsuario(String nombre,String apellido, String username, String password,
                                       String dni,String telefono,String nacionalidad,int tipoCliente) throws JSONException {
        String tipoC="";
        if(tipoCliente==0){
            tipoC = "Administrador";
        }if(tipoCliente==1){
            tipoC = "Empleado";
        }if(tipoCliente==2){
            tipoC = "Conserje";
        }

        JSONObject pasajeroDatos = new JSONObject();
        pasajeroDatos.put("nombre", nombre);
        pasajeroDatos.put("apellido", apellido);
        pasajeroDatos.put("username", username);
        pasajeroDatos.put("password", password);
        pasajeroDatos.put("dni", dni);
        pasajeroDatos.put("telefono", telefono);
        pasajeroDatos.put("nacionalidad", nacionalidad);
        pasajeroDatos.put("tipoCliente", tipoC);

        return pasajeroDatos;
    }

    public void grabarRegistrosEnJson(JSONObject jsonObj,String tipoUsuario) throws JSONException {

        JsonUtiles jsonUt = new JsonUtiles();
        JSONArray arregloJSON = new JSONArray();
        
        arregloJSON.put(jsonObj);

        jsonUt.grabar(arregloJSON,tipoUsuario);
    }

    public void leerDatosUsuario(int tipoUsuario) throws JSONException{
        JsonUtiles jsonUt = new JsonUtiles();
        if(tipoUsuario == 0){
            jsonUt.leer("registroAdmin.json");
        }else{
            jsonUt.leer("registroUsuarioEstandar");
        }
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
