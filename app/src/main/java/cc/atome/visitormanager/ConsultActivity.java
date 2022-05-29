package cc.atome.visitormanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cc.atome.visitormanager.managers.VisitorManager;
import cc.atome.visitormanager.utils.IntentStorage;
import cc.atome.visitormanager.visitor.Visitor;

public class ConsultActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        listView = findViewById(R.id.listView);

        VisitorManager visitorManager = new VisitorManager();

        ArrayList<Visitor> allVisitors = new ArrayList<Visitor>();
        allVisitors = visitorManager.getAllVisitors();

        ArrayAdapter<Visitor> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allVisitors);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        VisitorManager visitorManager = new VisitorManager();
        ArrayList<Visitor> allVisitors = visitorManager.getAllVisitors();

        Intent intent = new Intent(ConsultActivity.this, ModifActivity.class);
        IntentStorage.add(intent, "modifyVisitor",allVisitors.get(i));
        startActivity(intent);

    }
}