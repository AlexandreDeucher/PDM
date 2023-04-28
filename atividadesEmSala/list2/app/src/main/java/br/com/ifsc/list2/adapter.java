package br.com.ifsc.list2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapter extends ArrayAdapter {
    Context context;
    int resource;
    List<ApplicationInfo> listApps;
    public adapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listApps=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView= layoutInflater.inflate(R.layout.item_lista,parent,false);

        ImageView imageView=convertView.findViewById(R.id.imageView);
        TextView textView=convertView.findViewById(R.id.textView);

        ApplicationInfo appInfo= this.listApps.get(position);

        textView.setText(appInfo.loadLabel(this.context.getPackageManager()));
        imageView.setImageDrawable(appInfo.loadIcon(this.context.getPackageManager()));

        return convertView;

    }
}
