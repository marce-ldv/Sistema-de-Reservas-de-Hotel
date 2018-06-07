package files;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtiles{
    public JsonUtiles(){}

    public void grabar(JSONArray array,String nombreDirectorio) {
        try {
            FileWriter file = new FileWriter(nombreDirectorio);
            file.write(array.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leer(String nombreDirectorio)
    {
        try
        {
            String contenido = new String(Files.readAllBytes(Paths.get(nombreDirectorio)));
            JSONArray array = new JSONArray(contenido);
            System.out.println(contenido);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Anomalia al leer el directorio ");
            e.printStackTrace();
        }

    }
}
