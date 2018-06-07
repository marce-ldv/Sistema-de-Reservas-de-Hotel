package domain;

import exepciones.CampoVacioException;
import exepciones.InicioSesionException;
import exepciones.InvalidUsernameAndPasswordException;
import exepciones.InvalidUsernameException;
import files.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import swing.LoginGUI;

public class Hotel
{

    public String leerDatosUsuario(String tipoUsuario) throws JSONException{
        JsonUtiles jsonUt = new JsonUtiles();
        return jsonUt.leer(tipoUsuario);
    }


    public Usuario loguearse(String user, String pass) throws InvalidUsernameAndPasswordException, InvalidUsernameException, CampoVacioException, InicioSesionException, JSONException {
        LoginGUI loginGUI = new LoginGUI();
        Usuario usu = null;
        String objUsuarios="";

        String urlUsuario = loginGUI.getTipoDeUsuario();

            objUsuarios = leerDatosUsuario(urlUsuario);
            JSONArray jsonArray = new JSONArray(objUsuarios);
            for (int i=0; i<jsonArray.length();i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("usernane").equals(user))
                {
                    if (jsonObject.getString("password").equals(pass))
                    {
                        usu = new Usuario();
                        usu.setPassword(pass);
                        usu.setUsuario(user);
                    }
                    else
                    {
//contraseña incorrecta exception
                    }
                }
            }
            if (usu==null)
            {
                //usu no encontrado exception
            }
        return usu;
    }


}
