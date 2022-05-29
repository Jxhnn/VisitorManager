package cc.atome.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cc.atome.visitormanager.managers.VisitorManager;
import cc.atome.visitormanager.visitor.Visitor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText loginVisitor, passVisitor;

    private VisitorManager visitorManager;
    private Visitor thisVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        loginVisitor = findViewById(R.id.loginVisitor);
        passVisitor = findViewById(R.id.passVisitor);


        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        VisitorManager visitorManager = new VisitorManager();
        boolean out = visitorManager.loginVisitor(loginVisitor.getText().toString(),
                passVisitor.getText().toString());

        if (out) {
            Intent i = new Intent(MainActivity.this, PropositionActivity.class);
            startActivity(i);

            Toast.makeText(this, "Vous êtes bien connecté !",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Les indentifiants sont incorrects !",
                    Toast.LENGTH_SHORT).show();
        }

    }
}