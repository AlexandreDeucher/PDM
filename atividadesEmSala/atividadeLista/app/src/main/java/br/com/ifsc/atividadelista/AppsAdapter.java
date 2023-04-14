package br.com.ifsc.atividadelista;

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

public class AppsAdapter extends ArrayAdapter{
    Context context;
    List<ApplicationInfo> apps;
    int resourceLayout;
    public AppsAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.apps = objects;
        this.resourceLayout = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resourceLayout, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        ApplicationInfo app = apps.get(position);
        imageView.setImageDrawable(app.loadIcon(context.getPackageManager()));
        textView.setText(app.loadLabel(context.getPackageManager()));

        return convertView;

    }
}
