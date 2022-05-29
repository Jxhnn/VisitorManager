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

    public ArrayList<Visitor> getAllVisitors() {

        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
        String result = "";
        String myUrl="https://www.atome.cc/api/functions/getVisiteurs.php";

        String params = "";

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
        Log.d("resultat", "result: " + result);


        JSONArray array = null;
        try {
            array = new JSONArray(result);

            for (int i = 0; i < array.length(); i++) {
                String idVisitor = array.getJSONObject(i).getString("id");
                String nameVisitor = array.getJSONObject(i).getString("prenom");
                String lastNameVisitor = array.getJSONObject(i).getString("nom");
                String loginVisitor = array.getJSONObject(i).getString("login");
                String passwordVisitor = array.getJSONObject(i).getString("mdp");
                String addressVisitor = array.getJSONObject(i).getString("adresse");
                String zipCodeVisitor = array.getJSONObject(i).getString("cp");
                String townVisitor = array.getJSONObject(i).getString("ville");
                String takenDate = array.getJSONObject(i).getString("dateEmbauche");

                Visitor thisVisitor = new Visitor(idVisitor, nameVisitor, lastNameVisitor,
                        loginVisitor, passwordVisitor, addressVisitor, zipCodeVisitor,
                        townVisitor, takenDate);

                visitors.add(thisVisitor);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return visitors;

    }
    
    public String addVisitor(Visitor visitor) {
        String result = "";
        String myUrl="https://www.atome.cc/api/functions/addVisiteur.php";

		String params = "";

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
        Log.d("resultat", "result: " + result);
        return result;
    }

    public String modifyVisitor(Visitor visitor, String oldId) {
        String result = "";

        String myUrl="https://www.atome.cc/api/functions/modifVisiteurById.php";

        String params = "idVisitor=" + visitor.getId()
                + "&nameVisitor=" + visitor.getName()
                + "&lastnameVisitor=" + visitor.getLastName()
                + "&loginVisitor=" + visitor.getLogin()
                + "&passVisitor=" + visitor.getPassword()
                + "&addressVisitor=" + visitor.getAddress()
                + "&zipVisitor=" + visitor.getZipCode()
                + "&townVisitor=" + visitor.getTown()
                + "&takenDate=" + visitor.getTakenDate()
                + "&oldIdVisitor=" + oldId;

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
        Log.d("resultat", "result: " + result);
        return result;
    }

    public boolean deleteVisitor(String id) {
        String result = "";
        String myUrl="https://www.atome.cc/api/functions/supVisiteurById.php";
        String params = "idVisitor=" + id;

        HttpPostRequest postRequest = new HttpPostRequest();
        try {
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result.equals("done");
    }

    public boolean loginVisitor(String login, String pass) {
        String result = "";
        String myUrl="https://www.atome.cc/api/functions/loginVisitor.php";
        String params = "loginVisitor=" + login
                + "&passVisitor=" + pass;

        HttpPostRequest postRequest = new HttpPostRequest();
        try {
            result = postRequest.execute(new String []{myUrl, params}).get();

            JSONObject object = new JSONObject(result);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
