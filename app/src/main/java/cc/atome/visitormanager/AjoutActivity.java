package cc.atome.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cc.atome.visitormanager.managers.VisitorManager;
import cc.atome.visitormanager.visitor.Visitor;

public class AjoutActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonValiderAjout;
    private VisitorManager visitorManager;
    private EditText editTextId, editTextNom, editTextPre, editTextLogin,
            editTextMdp, editTextAdRue, editTextCP, editTextVille, editTextDate;

    private String newId, newName, newLastName, newLogin,
            newPassword, newAddress, newZipCode, newTown, newTakenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        editTextId = findViewById(R.id.editTextId);
        editTextNom = findViewById(R.id.editTextNom);
        editTextPre = findViewById(R.id.editTextPre);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextMdp = findViewById(R.id.editTextMdp);
        editTextAdRue = findViewById(R.id.editTextAdRue);
        editTextCP = findViewById(R.id.editTextCP);
        editTextVille = findViewById(R.id.editTextVille);
        editTextDate = findViewById(R.id.editTextDate);
        buttonValiderAjout = findViewById(R.id.buttonValiderAjout);

        buttonValiderAjout.setOnClickListener(this);

        visitorManager = new VisitorManager();
    }

    @Override
    public void onClick(View view) {
        // TODO: insert query with API REST

        newId = editTextId.getText().toString();
        newName = editTextNom.getText().toString();
        newLastName = editTextPre.getText().toString();
        newLogin = editTextLogin.getText().toString();
        newPassword = editTextMdp.getText().toString();
        newAddress = editTextAdRue.getText().toString();
        newZipCode = editTextCP.getText().toString();
        newTown = editTextVille.getText().toString();
        newTakenDate = editTextDate.getText().toString();


        Visitor newVisitor = new Visitor(newId, newName, newLastName,
                newLogin, newPassword, newAddress, newZipCode, newTown, newTakenDate);

        visitorManager.addVisitor(newVisitor);
    }
}