package cc.atome.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AjoutActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonValiderAjout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        buttonValiderAjout = findViewById(R.id.buttonValiderAjout);
        buttonValiderAjout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}