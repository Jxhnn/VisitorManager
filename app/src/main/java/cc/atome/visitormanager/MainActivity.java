package cc.atome.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cc.atome.visitormanager.managers.VisitorManager;
import cc.atome.visitormanager.visitor.Visitor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText idVisitor, passVisitor;

    private VisitorManager visitorManager;
    private Visitor thisVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        idVisitor = findViewById(R.id.idVisitor);
        passVisitor = findViewById(R.id.passVisitor);


        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, PropositionActivity.class);
        startActivity(i);
    }
}