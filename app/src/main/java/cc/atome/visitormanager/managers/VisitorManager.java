package cc.atome.visitormanager.managers;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import cc.atome.visitormanager.requests.HttpPostRequest;
import cc.atome.visitormanager.visitor.Visitor;


public class VisitorManager {

    public VisitorManager() {
    }

    
    public String addVisiteur(Visitor visitor) {
        String result = "";
        String myUrl="http://www.atome.cc/api/functions/addVisiteur.php";

		String params = "id=" + visitor.getId()
                +"&nom=" + visitor.getName()
                + "&prenom=" + visitor.getLastName()
                + "&login=" + visitor.getLogin()
                + "&mdp=" + visitor.getPassword()
                + "&adresse=" + visitor.getAddress()
                + "&cp=" + visitor.getZipCode()
                + "&ville=" + visitor.getTown()
                + "&dateEmbauche=" + visitor.getTakenDate();

		Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat",result);
        return result;
    }

}
