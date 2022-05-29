package cc.atome.visitormanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import cc.atome.visitormanager.managers.VisitorManager;
import cc.atome.visitormanager.utils.IntentStorage;
import cc.atome.visitormanager.visitor.Visitor;


public class ModifActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Button modifyButton, deleteButton;
    private Spinner visitorSpinner;
    private VisitorManager visitorManager;
    private ArrayList<Visitor> visitors;
    private TextView textViewChoice;
    private EditText editTextId, editTextNom, editTextPre, editTextLogin,
            editTextMdp, editTextAdRue, editTextCP, editTextVille, editTextDate;

    private String newId, newName, newLastName, newLogin,
            newPassword, newAddress, newZipCode, newTown, newTakenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif);

        editTextId = findViewById(R.id.editTextId);
        editTextNom = findViewById(R.id.editTextNom);
        editTextPre = findViewById(R.id.editTextPre);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextMdp = findViewById(R.id.editTextMdp);
        editTextAdRue = findViewById(R.id.editTextAdRue);
        editTextCP = findViewById(R.id.editTextCP);
        editTextVille = findViewById(R.id.editTextVille);
        editTextDate = findViewById(R.id.editTextDate);
        modifyButton = findViewById(R.id.modifyButton);
        visitorSpinner = findViewById(R.id.visitorSpinner);
        textViewChoice = findViewById(R.id.textViewChoice);
        deleteButton = findViewById(R.id.deleteButton);

        visitorManager = new VisitorManager();

        visitors = new ArrayList<>();
        visitors = visitorManager.getAllVisitors();
        Log.d("DEBUG", "" + visitors.get(0).toString());

        if (IntentStorage.get(getIntent(), "modifyVisitor") != null) {
            visitorSpinner.setVisibility(View.INVISIBLE);
            textViewChoice.setVisibility(View.INVISIBLE);
            Visitor modifyVisitor = IntentStorage.get(getIntent(), "modifyVisitor");

            visitors.clear();
            visitors.add(modifyVisitor);
        }

        ArrayAdapter<Visitor> visitorAdapter = new ArrayAdapter<Visitor>(this,
                android.R.layout.simple_spinner_dropdown_item, visitors);


        visitorSpinner.setAdapter(visitorAdapter);
        visitorSpinner.setOnItemSelectedListener(this);

        modifyButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Visitor selectedVisitor = visitors.get(i);
        editTextId.setText(selectedVisitor.getId());
        editTextNom.setText(selectedVisitor.getName());
        editTextPre.setText(selectedVisitor.getLastName());
        editTextLogin.setText(selectedVisitor.getLogin());
        editTextMdp.setText(selectedVisitor.getPassword());
        editTextAdRue.setText(selectedVisitor.getAddress());
        editTextCP.setText(selectedVisitor.getZipCode());
        editTextVille.setText(selectedVisitor.getTown());
        editTextDate.setText(selectedVisitor.getTakenDate());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        if (view == modifyButton) {

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
                    newLogin, newPassword, newAddress, newZipCode,
                    newTown, newTakenDate);

            visitorManager.modifyVisitor(newVisitor,
                    ((Visitor) visitorSpinner.getSelectedItem()).getId());

            Toast.makeText(this, "Le visiteur à bien été modifié !",
                    Toast.LENGTH_SHORT).show();

            finish();
            startActivity(new Intent(this, ModifActivity.class));

        } else if (view == deleteButton) {

            newId = editTextId.getText().toString();
            boolean out = visitorManager.deleteVisitor(newId);
            if (out) {
                Toast.makeText(this, "Le visiteur à été supprimé !",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erreur dans la suppression du visiteur",
                        Toast.LENGTH_SHORT).show();
            }

            Intent i = new Intent(ModifActivity.this, PropositionActivity.class);
            finish();
            startActivity(i);
        }
    }

    @Override
    protected void onDestroy() {
        IntentStorage.remove(getIntent());
        super.onDestroy();
    }
}
