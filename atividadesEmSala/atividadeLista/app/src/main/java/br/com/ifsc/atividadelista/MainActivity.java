package br.com.ifsc.atividadelista;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    PackageManager pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listaView);

        //recuperar os dados (apps do sistema)
        pm = getPackageManager();
        ArrayList<String> appsName = new ArrayList<>();
        List<ApplicationInfo> apps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for(ApplicationInfo app : apps){
            appsName.add(app.loadLabel(pm).toString());
        }
        //Adaptador padrao
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                appsName);

        //Adaptador personalizado
        AppsAdapter adapter2 = new AppsAdapter(
          this, R.layout.item_lista,apps
        );

        listView.setAdapter(adapter2);

    }
}