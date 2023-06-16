package br.com.ifsc.list2;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        packageManager= getPackageManager();
            ArrayList<String> NomeDosApps = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, NomeDosApps);

        List<ApplicationInfo> aplicações = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

            adapter adaptadorNovo = new adapter(
                    this, R.layout.itens, aplicações
            );
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ApplicationInfo applicationInfo = (ApplicationInfo) parent.getItemAtPosition(position);
                        String packageName = applicationInfo.packageName;
                            Toast.makeText(MainActivity.this, "aplicativo em processo de execução", Toast.LENGTH_SHORT).show();
                    Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                        if (intent != null) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "erro ao tentar abrir o aplicativo", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        listView.setAdapter(adaptadorNovo);
    }
}