package br.com.ifsc.list2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        packageManager= getPackageManager();
        packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        List<ApplicationInfo> packageInfoList = packageManager.getInstalledApplications
                (PackageManager.GET_META_DATA);

        adapter Adapter = new adapter(this,R.layout.item_lista,packageInfoList);
        listView.setAdapter(Adapter);

    }
}