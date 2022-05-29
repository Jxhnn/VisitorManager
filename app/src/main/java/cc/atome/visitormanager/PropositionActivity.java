package cc.atome.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PropositionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addVisitor, showVisitor, modifyVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);

        addVisitor = findViewById(R.id.addVisitor);
        addVisitor.setOnClickListener(this);

        showVisitor = findViewById(R.id.showVisitor);
        showVisitor.setOnClickListener(this);

        modifyVisitor = findViewById(R.id.modifyVisitor);
        modifyVisitor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == addVisitor) {
            Intent i = new Intent(PropositionActivity.this, AjoutActivity.class);
            startActivity(i);
            finish();

        } else if (view == showVisitor) {
            Intent i = new Intent(PropositionActivity.this, ConsultActivity.class);
            startActivity(i);
            finish();

        } else if (view == modifyVisitor) {
            Intent i = new Intent(PropositionActivity.this, ModifActivity.class);
            startActivity(i);
            finish();
        }
    }
}