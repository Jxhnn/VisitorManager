package cc.atome.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PropositionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addVisitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);

        addVisitor = findViewById(R.id.addVisitor);
        addVisitor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == addVisitor) {
            Intent i = new Intent(PropositionActivity.this, AjoutActivity.class);
            startActivity(i);
        }
    }
}